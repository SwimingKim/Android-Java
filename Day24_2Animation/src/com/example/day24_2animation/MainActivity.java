package com.example.day24_2animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		Button b = (Button) findViewById(R.id.button1);
		final AnimationDrawable ad = (AnimationDrawable) iv.getBackground();

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (ad.isRunning()) {
					ad.stop();
				} else {
					ad.start();
				}
			}
		});

	}// end of onCreate
}// end of class
