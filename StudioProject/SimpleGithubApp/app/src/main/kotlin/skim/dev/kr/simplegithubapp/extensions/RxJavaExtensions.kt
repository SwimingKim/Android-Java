package skim.dev.kr.simplegithubapp.extensions

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import skim.dev.kr.simplegithubapp.rx.AutoClearedDisposable

/**
 * Created by suyoung on 2018. 3. 1..
 */
operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    this.add(disposable)
}

operator fun AutoClearedDisposable.plusAssign(disposable: Disposable) = this.add(disposable)

fun runOnIoScheduler(func: () -> Unit): Disposable = Completable.fromCallable(func).subscribeOn(Schedulers.io()).subscribe()