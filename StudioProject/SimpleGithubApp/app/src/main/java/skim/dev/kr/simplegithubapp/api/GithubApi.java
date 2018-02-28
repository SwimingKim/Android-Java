package skim.dev.kr.simplegithubapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import skim.dev.kr.simplegithubapp.api.model.GithubRepo;
import skim.dev.kr.simplegithubapp.api.model.RepoSearchResponse;

public interface GithubApi {

    @GET("search/repositories")
    Call<RepoSearchResponse> searchRepository(@Query("q") String query);

    @GET("repos/{owner}/{name}")
    Call<GithubRepo> getRepository(@Path("owner") String ownerLogin, @Path("name") String repoName);
}
