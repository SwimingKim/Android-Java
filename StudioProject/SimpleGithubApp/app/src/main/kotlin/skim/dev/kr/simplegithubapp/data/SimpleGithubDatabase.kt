package skim.dev.kr.simplegithubapp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import skim.dev.kr.simplegithubapp.api.model.GithubRepo

/**
 * Created by suyoung on 2018. 3. 1..
 */
@Database(entities = arrayOf(GithubRepo::class), version = 1)
abstract class SimpleGithubDatabase : RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDao
}