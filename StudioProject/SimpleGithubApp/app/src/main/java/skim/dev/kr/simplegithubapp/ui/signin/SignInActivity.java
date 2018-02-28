package skim.dev.kr.simplegithubapp.ui.signin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skim.dev.kr.simplegithubapp.BuildConfig;
import skim.dev.kr.simplegithubapp.R;
import skim.dev.kr.simplegithubapp.api.AuthApi;
import skim.dev.kr.simplegithubapp.api.GithubApiProvider;
import skim.dev.kr.simplegithubapp.api.model.GithubAccessToken;
import skim.dev.kr.simplegithubapp.data.AuthTokenProvider;
import skim.dev.kr.simplegithubapp.ui.main.MainActivity;

/**
 * Created by suyoung on 2018. 2. 26..
 */

public class SignInActivity extends AppCompatActivity {

    Button btnStart;
    ProgressBar progress;
    AuthApi api;
    AuthTokenProvider authTokenProvider;
    Call<GithubAccessToken> accessTokenCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnStart = (Button) findViewById(R.id.btnActivitySignInStart);
        progress = (ProgressBar) findViewById(R.id.pbActivitySignIn);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri authUri = new Uri.Builder().scheme("https").authority("github.com")
                        .appendPath("login").appendPath("oauth").appendPath("authorize")
                        .appendQueryParameter("client_id", BuildConfig.GITHUB_CLIENT_ID).build();

                CustomTabsIntent intent = new CustomTabsIntent.Builder().build();
                intent.launchUrl(SignInActivity.this, authUri);
            }
        });

        api = GithubApiProvider.provideAuthApi();
        authTokenProvider = new AuthTokenProvider(this);

        if (null != authTokenProvider.getToken()) {
            launchMainActivity();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        showProgress();

        Uri uri = intent.getData();
        if (null == uri) {
            throw new IllegalArgumentException("No data exists");
        }

        String code = uri.getQueryParameter("code");
        if (null == code) {
            throw new IllegalArgumentException("No code exists");
        }

        getAccessToken(code);
    }

    private void getAccessToken(String code) {
        showProgress();

        accessTokenCall = api.getAccessToken(BuildConfig.GITHUB_CLIENT_ID, BuildConfig.GITHUB_CLIENT_SECRET, code);
        accessTokenCall.enqueue(new Callback<GithubAccessToken>() {
            @Override
            public void onResponse(Call<GithubAccessToken> call, Response<GithubAccessToken> response) {
                hideProgress();

                GithubAccessToken token = response.body();
                if (response.isSuccessful() && null != token) {
                    authTokenProvider.updateToken(token.accessToken);
                    launchMainActivity();
                } else {
                    showError(new IllegalStateException("Not successful: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<GithubAccessToken> call, Throwable t) {
                hideProgress();
                showError(t);
            }
        });

    }

    private void showProgress() {
        btnStart.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        btnStart.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

    private void showError(Throwable throwable) {
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void launchMainActivity() {
        startActivity(new Intent(this, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
