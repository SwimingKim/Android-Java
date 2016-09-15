package com.example.day33_2;

import java.util.Timer;
import java.util.TimerTask;

import com.example.day33_2.R.anim;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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

