package skim.dev.kr.simplegithubapp.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import skim.dev.kr.simplegithubapp.api.model.GithubRepo

/**
 * Created by suyoung on 2018. 3. 1..
 */
@Dao
interface SearchHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(repo: GithubRepo)

    @Query("SELECT*FROM repositories")
    fun getHistory(): Flowable<List<GithubRepo>>

    @Query("DELETE FROM repositories")
    fun clearAll()

}