package com.example.window;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Dialog;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Time;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class LastActivity extends Activity {
	SoundPool sp;
	int soundID1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.last);
		final ImageView iv_tro = (ImageView) findViewById(R.id.imageView3);
		final ImageView iv_man = (ImageView) findViewById(R.id.imageView2);

		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ccc);
		iv_man.startAnimation(animation);

		Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.te);
		iv_tro.startAnimation(animation2);

		sp = new SoundPool(255, AudioManager.STREAM_MUSIC, 0);
		soundID1 = sp.load(this, R.raw.wow, 1);
		sp.play(soundID1, 1, 1, 0, 0, 1);

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			public void run() {
				showDialog(0);
			}
		}, 5000);

	}// end of onCreate

	protected Dialog onCreateDialog(int id) {
		if (id == 0) {
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("성공");
			dialog.setMessage("다시 시작하겠습니까??");
			dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					finish();
				}
			});
			return dialog.create();
		}

		return super.onCreateDialog(id);
	}

}// end of class
