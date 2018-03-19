package skim.dev.kr.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import skim.dev.kr.firstapp.CityAdapter;
import skim.dev.kr.firstapp.R;

/**
 * Created by suyoung on 2018. 2. 25..
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView view = (RecyclerView)findViewById(R.id.view);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        view.setLayoutManager(manager);

        CityAdapter adapter = new CityAdapter();
        view.setAdapter(adapter);
    }
}
