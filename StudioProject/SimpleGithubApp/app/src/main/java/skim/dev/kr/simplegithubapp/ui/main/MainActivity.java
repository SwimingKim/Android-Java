package skim.dev.kr.simplegithubapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import skim.dev.kr.simplegithubapp.R;
import skim.dev.kr.simplegithubapp.ui.search.SearchActivity;

/**
 * Created by suyoung on 2018. 2. 26..
 */

public class MainActivity extends AppCompatActivity {

    FloatingActionButton btnSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = (FloatingActionButton) findViewById(R.id.btnActivityMainSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });
    }
}

