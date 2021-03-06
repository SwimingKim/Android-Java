package skim.dev.kr.simplegithubapp.ui.search

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.jakewharton.rxbinding2.support.v7.widget.queryTextChangeEvents
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.startActivity
import skim.dev.kr.simplegithubapp.R
import skim.dev.kr.simplegithubapp.api.model.GithubRepo
import skim.dev.kr.simplegithubapp.api.provideGithubApi
import skim.dev.kr.simplegithubapp.data.provideSearchHistoryDao
import skim.dev.kr.simplegithubapp.extensions.plusAssign
import skim.dev.kr.simplegithubapp.extensions.runOnIoScheduler
import skim.dev.kr.simplegithubapp.rx.AutoClearedDisposable
import skim.dev.kr.simplegithubapp.ui.repo.RepositoryActivity
import java.lang.IllegalStateException

/**
 * Created by suyoung on 2018. 2. 26..
 */

class SearchActivity : AppCompatActivity(), SearchAdapter.ItemClickListener {

    internal lateinit var menuSearch: MenuItem
    internal lateinit var searchView: SearchView
    internal val adapter by lazy {
        SearchAdapter().apply { setItemClickListener(this@SearchActivity) }
    }
    internal val api by lazy { provideGithubApi(this) }
    internal val disposables = AutoClearedDisposable(this)
    internal val viewDisposables = AutoClearedDisposable(this, false)
    internal val searchHitoryDao by lazy { provideSearchHistoryDao(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        lifecycle += disposables
        lifecycle += viewDisposables

        with(rvActivitySearchList) {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = this@SearchActivity.adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_activity_search, menu)
        menuSearch = menu.findItem(R.id.menu_activity_search_query)
        searchView = (menuSearch.actionView as SearchView)

        viewDisposables += searchView.queryTextChangeEvents()
                .filter { it.isSubmitted }
                .map { it.queryText() }
                .filter { it.isNotEmpty() }
                .map { it.toString() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { query ->
                    updateTitle(query)
                    hideSoftKeyboard()
                    collapseSearchView()
                    searchRepository(query)
                }

        menuSearch.expandActionView()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.id.menu_activity_search_query == item.itemId) {
            item.expandActionView()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(repository: GithubRepo) {

        disposables += runOnIoScheduler { searchHitoryDao.add(repository) }
        startActivity<RepositoryActivity>(
                RepositoryActivity.KEY_USER_LOGIN to repository.owner.login,
                RepositoryActivity.KEY_RERO_NAME to repository.name)
    }

    private fun searchRepository(query: String) {

        disposables += api.searchRepository(query)
                .flatMap {
                    if (0 == it.totalCount) {
                        Observable.error(IllegalStateException("No result result"))
                    } else {
                        Observable.just(it.items)
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    clearResults()
                    hideError()
                    showProgress()
                }.doOnTerminate {
                    hideProgress()
                }.subscribe({ items ->
                    with(adapter) {
                        setItems(items)
                        notifyDataSetChanged()
                    }
                }) {
                    showError(it.message)
                }

    }

    private fun updateTitle(query: String) {
        supportActionBar?.run { subtitle = query }
    }

    private fun hideSoftKeyboard() {
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
            hideSoftInputFromWindow(searchView.windowToken, 0)
        }
    }

    private fun collapseSearchView() {
        menuSearch.collapseActionView()
    }

    private fun clearResults() {
        with(adapter) {
            clearItems()
            notifyDataSetChanged()
        }
    }

    private fun showProgress() {
        pbActivitySearch.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        pbActivitySearch.visibility = View.GONE
    }

    private fun showError(message: String?) {
        with(tvActivitySearchMessage) {
            text = message ?: "Unexpected error."
            visibility = View.VISIBLE
        }
    }

    private fun hideError() {
        with(tvActivitySearchMessage) {
            text = ""
            visibility = View.VISIBLE
        }
    }
}
