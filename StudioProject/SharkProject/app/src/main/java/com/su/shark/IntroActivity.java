package com.su.shark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends Activity {

    final int DIALOG_START = 0;
    final int DIALOG_WAY = 1;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        final RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.content);
        ImageView imageView = (ImageView) findViewById(R.id.centerImage);
        rippleBackground.startRippleAnimation();

        TimerTask task = new TimerTask() {
            public void run() {// 실행할 작업을 기술
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();// 인트호 화면은 없애버리기
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000);

    }//end of onCreate

}//end of class
