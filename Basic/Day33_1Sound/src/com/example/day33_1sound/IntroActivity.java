package com.example.day33_1sound;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class IntroActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
		findViewById(R.id.bbb).setAnimation(animation);
		if (animation==null) {
			animation.start();
		}		
		
		TimerTask task = new TimerTask() {
			public void run() {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task, 2000);
		
	}//end of onCreate
}//end of class
