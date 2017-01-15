package com.example.day24_3animation_alpa;

import java.lang.annotation.AnnotationTypeMismatchException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		final ImageView iv = (ImageView) findViewById(R.id.imageView1);

		// Animation animation =
		//// AnimationUtils.loadAnimation(getApplicationContext(),
		// R.anim.alpha);
		//
		// iv.startAnimation(animation);

		// b.setOnClickListener(new OnClickListener() {
		// public void onClick(View v) {
		// // 트윈 애니메이션 - Alpha 값 변경
		// Animation animation =
		// AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
		//
		// iv.startAnimation(animation);
		//
		//
		// }
		// });

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 트윈 애니메이션 - Rotation 회전하기
				Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

				iv.startAnimation(animation);

			}
		});

		b3.setOnClickListener(new OnClickListener() {
			// 트윈 애니메이션 - Translate 이동하기
			public void onClick(View v) {
				Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
				iv.startAnimation(animation);

			}
		});

		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 트윈 애니메이션 - Scale 크기변경하기
				Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
				iv.startAnimation(animation);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
