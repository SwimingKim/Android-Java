package skim.dev.kr.simplegithubapp.extensions

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver

/**
 * Created by suyoung on 2018. 3. 1..
 */
operator fun Lifecycle.plusAssign(observer: LifecycleObserver) = this.addObserver(observer)