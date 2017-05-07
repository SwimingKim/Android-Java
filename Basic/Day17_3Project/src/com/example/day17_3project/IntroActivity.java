package com.example.day17_3project;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntroActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

		TimerTask task = new TimerTask() {
			public void run() {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);

				startActivity(intent);
				finish();
			}
		};

		Timer timer = new Timer();
		timer.schedule(task, 3000);

	}// end of onCreate
}// end of class
