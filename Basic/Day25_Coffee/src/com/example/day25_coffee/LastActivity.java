package com.example.day25_coffee;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LastActivity extends MainActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.last);

		final TextView tv = (TextView) findViewById(R.id.textView1);
		final ImageView iv = (ImageView) findViewById(R.id.imageView1);

		final AnimationDrawable ad = (AnimationDrawable) iv.getBackground();

		ad.start();
		iv.setImageDrawable(null);

		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				ad.start();

			}
		});

	}// end of onCreate
}// end of class