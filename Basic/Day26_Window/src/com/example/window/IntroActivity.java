package com.example.window;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroActivity extends Activity {
	ImageView iv[] = new ImageView[5];
	SoundPool sp;
	int soundID1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.intro);

		TextView tv = (TextView) findViewById(R.id.textView1);
		iv[0] = (ImageView) findViewById(R.id.imageView1);
		iv[1] = (ImageView) findViewById(R.id.imageView2);
		iv[2] = (ImageView) findViewById(R.id.imageView3);
		iv[3] = (ImageView) findViewById(R.id.imageView4);
		ImageView ima = (ImageView) findViewById(R.id.imageView5);

		sp = new SoundPool(255, AudioManager.STREAM_MUSIC, 0);
		soundID1 = sp.load(this, R.raw.sound, 1);

		final TimerTask task = new TimerTask() {
			public void run() {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();

			}
		};

		Timer timer = new Timer();
		timer.schedule(task, 3000);

		sp.play(soundID1, 1, 1, 0, 0, 1);

		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ge);
		ima.startAnimation(animation);

		Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
		iv[0].startAnimation(animation2);
		iv[1].startAnimation(animation2);
		iv[2].startAnimation(animation2);
		iv[3].startAnimation(animation2);

	}

}
