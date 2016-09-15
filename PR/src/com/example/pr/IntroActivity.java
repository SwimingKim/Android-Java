package com.example.pr;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class IntroActivity extends Activity {
	int img[] = { R.drawable.wom, R.drawable.brown };
	int index;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

		final ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
		iv1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				index++;
				if (index == img.length)
					index = 0;
				iv1.setImageResource(img[index]);
			}
		});

		TimerTask task = new TimerTask() {
			public void run() {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		};

		Timer timer = new Timer();
		timer.schedule(task, 3000);

		ImageView iv = (ImageView) findViewById(R.id.imageView2);
		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});

	}// end of onCreate
}// end of class
