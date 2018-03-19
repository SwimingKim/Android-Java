package skim.dev.kr.firstapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.*

/**
 * Created by suyoung on 2018. 2. 25..
 */
class KDetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KDetailActivityUI().setContentView(this)

        Log.d("TAG", intent.extras.getLong("id").toString())
        Log.d("TAG", intent.extras.get("title").toString())
    }
}