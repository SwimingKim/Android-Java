package com.example.day37_mole;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class EndActivity extends Activity{
	MediaPlayer mp;
	int good, bad;
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		public void run() {
			showDialog(0);
		}
	};

	private ImageView iv_all;	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.end);
		
		Intent intent = getIntent();
		good = intent.getIntExtra("성공", 0);
		bad = intent.getIntExtra("실패", 0);
		
		mp = MediaPlayer.create(getApplicationContext(), R.raw.clear);
		mp.start();
		
		ImageView iv_y = (ImageView)findViewById(R.id.imageView1);
		iv_all = (ImageView)findViewById(R.id.imageView2);

		Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.yani);
		iv_y.startAnimation(animation1);
		
		Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.allani);
		iv_all.startAnimation(animation2);
		
		handler.postDelayed(r, 1500);
				
	}//end of onCreate
	@Override
	protected Dialog onCreateDialog(int id) {
		if (id==0) {
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("성공");
			dialog.setMessage(good+"번 성공 "+bad+"번 실패\n게임을 다시 시작하겠습니까?");
			dialog.setPositiveButton("예", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					finish();
				}
			});
			dialog.setNegativeButton("아니오", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			return dialog.create();
		}
		return super.onCreateDialog(id);
	}
}//end of class