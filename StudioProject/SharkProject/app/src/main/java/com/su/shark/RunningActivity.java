package com.su.shark;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by suyoung on 2017. 1. 26..
 */

public class RunningActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test);
        ((TextView)findViewById(R.id.textView)).setText("운동");

    }//end of onCreate
}//end of class

