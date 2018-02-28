package skim.dev.kr.simplegithubapp.api;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import skim.dev.kr.simplegithubapp.api.model.GithubAccessToken;

public interface AuthApi {

    @FormUrlEncoded
    @POST("login/oauth/access_token")
    @Headers("Accept: application/json")
    Call<GithubAccessToken> getAccessToken(
            @NonNull @Field("client_id") String clientId,
            @NonNull @Field("client_secret") String clientSecret,
            @NonNull @Field("code") String code);
}
