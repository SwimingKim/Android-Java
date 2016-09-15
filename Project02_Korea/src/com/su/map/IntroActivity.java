package com.su.map;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

public class IntroActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

		AnimationDrawable ad = (AnimationDrawable)findViewById(R.id.imageView1).getBackground();
		ad.start();

		TimerTask task = new TimerTask() {
			public void run() {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();

			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 2500);


	}
}

