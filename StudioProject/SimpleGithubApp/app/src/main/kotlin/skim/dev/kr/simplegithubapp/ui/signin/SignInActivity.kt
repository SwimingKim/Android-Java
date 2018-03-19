package skim.dev.kr.simplegithubapp.ui.signin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.longToast
import org.jetbrains.anko.newTask
import skim.dev.kr.simplegithubapp.BuildConfig
import skim.dev.kr.simplegithubapp.R
import skim.dev.kr.simplegithubapp.api.provideAuthApi
import skim.dev.kr.simplegithubapp.data.AuthTokenProvider
import skim.dev.kr.simplegithubapp.rx.AutoClearedDisposable
import skim.dev.kr.simplegithubapp.extensions.plusAssign
import skim.dev.kr.simplegithubapp.ui.main.MainActivity

/**
 * Created by suyoung on 2018. 2. 26..
 */

class SignInActivity : AppCompatActivity() {

    internal val api by lazy { provideAuthApi() }
    internal val authTokenProvider by lazy { AuthTokenProvider(this) }
    internal val disposables = AutoClearedDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        lifecycle += disposables

        btnActivitySignInStart.setOnClickListener {
            val authUri = Uri.Builder().scheme("https").authority("github.com")
                    .appendPath("login").appendPath("oauth").appendPath("authorize")
                    .appendQueryParameter("client_id", BuildConfig.GITHUB_CLIENT_ID).build()


            val intent = CustomTabsIntent.Builder().build()
            intent.launchUrl(this@SignInActivity, authUri)
        }

        if (null != authTokenProvider.token) {
            launchMainActivity()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        showProgress()

        val uri = intent.data ?: throw IllegalArgumentException("No data exists")

        val code = uri.getQueryParameter("code") ?: throw IllegalArgumentException("No code exists")

        getAccessToken(code)
    }

    private fun getAccessToken(code: String) {

        disposables += api.getAccessToken(BuildConfig.GITHUB_CLIENT_ID, BuildConfig.GITHUB_CLIENT_SECRET, code)
                .map { it.accessToken }.observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showProgress() }.doOnTerminate { hideProgress() }
                .subscribe({ token ->
                    authTokenProvider.updateToken(token)
                    launchMainActivity()
                }) {
                    showError(it)
                }

    }

    private fun showProgress() {
        btnActivitySignInStart.visibility = View.GONE
        pbActivitySignIn.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        btnActivitySignInStart.visibility = View.VISIBLE
        pbActivitySignIn.visibility = View.GONE
    }

    private fun showError(throwable: Throwable) {
        longToast(throwable.message ?: "No message available")
    }

    private fun launchMainActivity() {
        startActivity(intentFor<MainActivity>().clearTask().newTask())
    }
}
