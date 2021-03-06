package skim.dev.kr.simplegithubapp.ui.repo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_repository.*
import skim.dev.kr.simplegithubapp.R
import skim.dev.kr.simplegithubapp.api.provideGithubApi
import skim.dev.kr.simplegithubapp.rx.AutoClearedDisposable
import skim.dev.kr.simplegithubapp.extensions.plusAssign
import skim.dev.kr.simplegithubapp.ui.GlideApp
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by suyoung on 2018. 2. 26..
 */

class RepositoryActivity : AppCompatActivity() {

    companion object {

        const val KEY_USER_LOGIN = "user_login"
        const val KEY_RERO_NAME = "repo_name"
    }

    internal val api by lazy { provideGithubApi(this) }
    internal val disposables = AutoClearedDisposable(this)

    internal val dateFormatInResponse = SimpleDateFormat("yyyy-MM-dd HH:mm:ssX", Locale.getDefault())
    internal val dateFormatToShow = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        lifecycle += disposables

        val login = intent.getStringExtra(KEY_USER_LOGIN)
                ?: throw IllegalArgumentException("No login into exists in extras")
        val repo = intent.getStringExtra(KEY_RERO_NAME)
                ?: throw IllegalArgumentException("No repo info exists in extras")

        showRepositoryInfo(login, repo)
    }

    private fun showRepositoryInfo(login: String, repoName: String) {

        disposables += api.getRepository(login, repoName)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }
                .doOnError { hideProgress(false) }
                .doOnComplete { hideProgress(true) }
                .subscribe({ repo ->
                    GlideApp.with(this@RepositoryActivity)
                            .load(repo.owner.avatarUrl)
                            .into(ivActivityRepositoryProfile)

                    tvActivityRepositoryName.text = repo.fullName
                    tvActivityRepositoryStars.text = resources.getQuantityString(R.plurals.star, repo.stars, repo.stars)
                    if (null == repo.description) {
                        tvActivityRepositoryDescription.setText(R.string.no_description_provided)
                    } else {
                        tvActivityRepositoryDescription.text = repo.description
                    }
                    if (null == repo.language) {
                        tvActivityRepositoryLanguage.setText(R.string.no_language_specified)
                    } else {
                        tvActivityRepositoryLanguage.text = repo.language
                    }

                    try {
                        val lastUpdate = dateFormatInResponse.parse(repo.updatedAt)
                        tvActivityRepositoryLastUpdate.text = dateFormatToShow.format(lastUpdate)
                    } catch (e: ParseException) {
                        tvActivityRepositoryLastUpdate.text = getString(R.string.unknown)
                    }
                }) {
                    showError(it.message)
                }


    }

    private fun showProgress() {
        llActivityRepositoryContent.visibility = View.GONE
        pbActivityRepository.visibility = View.VISIBLE
    }

    private fun hideProgress(isSucced: Boolean) {
        llActivityRepositoryContent.visibility = if (isSucced) View.VISIBLE else View.GONE
        pbActivityRepository.visibility = View.GONE
    }

    private fun showError(message: String?) {

        with(tvActivityRepositoryMessage) {
            text = message ?: "Unexpected error."
            visibility = View.VISIBLE
        }
    }

}
