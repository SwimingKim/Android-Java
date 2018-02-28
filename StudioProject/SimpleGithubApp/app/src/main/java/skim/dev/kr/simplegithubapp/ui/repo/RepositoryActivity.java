package skim.dev.kr.simplegithubapp.ui.repo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skim.dev.kr.simplegithubapp.R;
import skim.dev.kr.simplegithubapp.api.GithubApi;
import skim.dev.kr.simplegithubapp.api.GithubApiProvider;
import skim.dev.kr.simplegithubapp.api.model.GithubRepo;
import skim.dev.kr.simplegithubapp.ui.GlideApp;

/**
 * Created by suyoung on 2018. 2. 26..
 */

public class RepositoryActivity extends Activity {

    public static final String KEY_USER_LOGIN = "SwimingKim";
    public static final String KEY_RERO_NAME = "Android-Java";

    LinearLayout llContent;
    ImageView ivProfile;
    TextView tvName;
    TextView tvStars;
    TextView tvDescription;
    TextView tvLanguage;
    TextView tvLastUpdate;
    ProgressBar pbProgress;
    TextView tvMessage;
    GithubApi api;
    Call<GithubRepo> repoCall;

    SimpleDateFormat dateFormatInResponse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX", Locale.getDefault());
    SimpleDateFormat dateFormatToShow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository);

        llContent = (LinearLayout)findViewById(R.id.llActivityRepositoryContent);
        ivProfile = (ImageView)findViewById(R.id.ivActivityRepositoryProfile);
        tvName = (TextView)findViewById(R.id.tvActivityRepositoryName);
        tvStars = (TextView)findViewById(R.id.tvActivityRepositoryStars);
        tvDescription = (TextView)findViewById(R.id.tvActivityRepositoryDescription);
        tvLanguage = (TextView)findViewById(R.id.tvActivityRepositoryLanguage);
        tvLastUpdate = (TextView)findViewById(R.id.tvActivityRepositoryLastUpdate);
        pbProgress = (ProgressBar)findViewById(R.id.pbActivityRepository);
        tvMessage = (TextView)findViewById(R.id.tvActivityRepositoryMessage);
        api = GithubApiProvider.provideGithubApi(this);

        String login = getIntent().getStringExtra(KEY_USER_LOGIN);
        if (null == login) {
            throw new IllegalArgumentException("No login into exists in extras");
        }
        String repo = getIntent().getStringExtra(KEY_RERO_NAME);
        if (null == repo) {
            throw new IllegalArgumentException("No repo info exists in extras");
        }

        showRepositoryInfo(login, repo);
    }

    private void showRepositoryInfo(String login, final String repoName) {
        showProgress();

        repoCall = api.getRepository(login, repoName);
        repoCall.enqueue(new Callback<GithubRepo>() {
            @Override
            public void onResponse(Call<GithubRepo> call, Response<GithubRepo> response) {
                hideProgress(true);

                GithubRepo repo = response.body();
                if (response.isSuccessful() && null != repo) {
                    GlideApp.with(RepositoryActivity.this).load(repo.owner.avatarUrl).into(ivProfile);

                    tvName.setText(repo.fullName);
                    tvStars.setText(getResources().getQuantityString(R.plurals.star, repo.stars, repo.stars));
                    if (null == repo.description) {
                        tvDescription.setText(R.string.no_description_provided);
                    } else {
                        tvDescription.setText(repo.description);
                    }
                    if (null == repo.language) {
                        tvLanguage.setText(R.string.no_language_specified);
                    } else {
                        tvLanguage.setText(repo.language);
                    }

                    try {
                        Date lastUpdate = dateFormatInResponse.parse(repo.updatedAt);
                        tvLastUpdate.setText(dateFormatToShow.format(lastUpdate));
                    } catch (ParseException e) {
                        tvLastUpdate.setText(getString(R.string.unknown));
                    }
                } else {
                    showError("Not succesful : "+response.message());
                }
            }

            @Override
            public void onFailure(Call<GithubRepo> call, Throwable t) {
                hideProgress(false);
                showError(t.getMessage());
            }
        });


    }

    private void showProgress() {
        llContent.setVisibility(View.GONE);
        pbProgress.setVisibility(View.VISIBLE);
    }

    private void hideProgress(boolean isSucced) {
        llContent.setVisibility(isSucced ? View.VISIBLE : View.GONE);
        pbProgress.setVisibility(View.GONE);
    }

    private void showError(String message) {
        tvMessage.setText(message);
        tvMessage.setVisibility(View.VISIBLE);
    }
}
