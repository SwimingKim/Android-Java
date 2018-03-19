package skim.dev.kr.simplegithubapp.data

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by suyoung on 2018. 3. 1..
 */
private var instance: SimpleGithubDatabase? = null

fun provideSearchHistoryDao(context: Context): SearchHistoryDao = provideDatabase(context).searchHistoryDao()

private fun provideDatabase(context: Context): SimpleGithubDatabase {
    if (null == instance) {
        instance = Room.databaseBuilder(context.applicationContext, SimpleGithubDatabase::class.java, "simple_gihub.db").build()
    }

    return instance!!
}