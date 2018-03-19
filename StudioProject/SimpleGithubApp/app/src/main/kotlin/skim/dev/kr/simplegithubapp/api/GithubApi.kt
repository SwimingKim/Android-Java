package skim.dev.kr.simplegithubapp.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import skim.dev.kr.simplegithubapp.api.model.GithubRepo
import skim.dev.kr.simplegithubapp.api.model.RepoSearchResponse

interface GithubApi {

    @GET("search/repositories")
    fun searchRepository(@Query("q") query: String): Observable<RepoSearchResponse>

    @GET("repos/{owner}/{name}")
    fun getRepository(@Path("owner") ownerLogin: String, @Path("name") repoName: String): Observable<GithubRepo>
}
