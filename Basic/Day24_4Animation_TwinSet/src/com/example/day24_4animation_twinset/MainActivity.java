package com.example.day24_4animation_twinset;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TextView tv1 = (TextView) findViewById(R.id.TextView01);
		final TextView tv2 = (TextView) findViewById(R.id.TextView02);
		final TextView tv3 = (TextView) findViewById(R.id.textView1);

		final ImageView iv = (ImageView) findViewById(R.id.imageView1);
		Button b = (Button) findViewById(R.id.button1);

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 트윈 애니메이션 - set : 알파값, 크기변경, 이동, 회전 기능을 조합할 수 있다
				Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.set);
				iv.startAnimation(animation);

				Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.s);
				tv1.startAnimation(animation2);

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
