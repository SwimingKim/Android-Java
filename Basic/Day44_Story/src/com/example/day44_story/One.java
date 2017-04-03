package com.example.day44_story;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class One extends Activity{
	MediaPlayer mp;
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		String say[] = {"가루야!!","오늘 중요한 손님이 오시니,","특별 짜장면을 만들꺼야","그러니까 스페셜 춘장을 사와~","저 문을 통해 나갈 수 있어", "꼭 사올테니까 기다려"};
		int i = 0;
		public void run() {
			if (i==say.length-1) {
				tvga.setText(say[i]);
				i = 0;
				handler.removeCallbacks(r);
			} else {
				tv.setText(say[i]);
				handler.postDelayed(r, 1500);
				i++;
			}
		}
	};
	private TextView tv;
	private TextView tvga;
	float SaveX;
	float SaveY;
	private float moveX;
	private float moveY;
	private float difX;
	private float difY;
	Intent intent;
	private FrameLayout layout;
	private FrameLayout layout2;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);

		tv = (TextView)findViewById(R.id.textView1);
		tvga = (TextView)findViewById(R.id.textView2);
		handler.post(r);
		layout = (FrameLayout)findViewById(R.id.FrameLayout1);
		layout2 = (FrameLayout)findViewById(R.id.bb);
		intent = new Intent(getApplicationContext(),Two.class);
		
		mp = MediaPlayer.create(getApplicationContext(), R.raw.china);
		mp.start();
		mp.setLooping(true);

		final ImageView door = (ImageView)findViewById(R.id.mun);
		final ImageView bu = (ImageView)findViewById(R.id.ga);
		
		bu.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if ("꼭 사올테니까 기다려".equals(tvga.getText().toString())) {
					if (event.getAction() == MotionEvent.ACTION_UP) {
						float xd = Math.abs(bu.getX()-door.getX());
						float yd = Math.abs(bu.getY()-door.getY());
						
						if (xd<door.getWidth()/2&&yd<door.getHeight()) {
							bu.setX(door.getX());
							bu.setY(door.getY());
							tv.setText("");
							tvga.setText("문을 클릭해주세요");
						} else{
							float x = bu.getX()-(difX);
							float y = bu.getY()-(difY);
							
							if (x<0) x = 0;
							if (x>layout.getWidth()-bu.getWidth()){
								x = layout.getWidth()-bu.getWidth();
							}
							if (y<layout2.getHeight()-bu.getHeight()-270) {
								y = layout2.getHeight()-bu.getHeight()-270;
							}
							if (y>layout.getHeight()-bu.getHeight()) {
								y = layout.getHeight()-bu.getHeight();
							}
							bu.setX(x);
							bu.setY(y);
						}
					} else if (event.getAction() == MotionEvent.ACTION_DOWN) {
						SaveX = event.getX();
						SaveY = event.getY();
					} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
						float xd = Math.abs(bu.getX()-door.getX());
						float yd = Math.abs(bu.getY()-door.getY());
						
						if (xd<door.getWidth()/2&&yd<door.getHeight()) {
							bu.setX(door.getX());
							bu.setY(door.getY());
							tv.setText("");
							tvga.setText("문을 클릭해주세요");
						} else{
							moveX = event.getX();
							moveY = event.getY();
							difX=SaveX-moveX;
							difY=SaveY-moveY;
							float x = bu.getX()-(difX);
							float y = bu.getY()-(difY);
							if (x<0) x = 0;
							if (x>layout.getWidth()-bu.getWidth()){
								x = layout.getWidth()-bu.getWidth();
							}
							if (y<layout2.getHeight()-bu.getHeight()-270) {
								y = layout2.getHeight()-bu.getHeight()-270;
							}
							if (y>layout.getHeight()-bu.getHeight()) {
								y = layout.getHeight()-bu.getHeight();
							}
							bu.setX(x);
							bu.setY(y);
						}
					}
					
				}
				return true;
			}
		});
		
		door.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN) {
					if ("문을 클릭해주세요".equals(tvga.getText().toString())) {
						intent.putExtra("노래", mp.getCurrentPosition());
						startActivity(intent);
						finish();
					}
				}
				return false;
			}
		});


	}//end of onCreate

	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r);
		finish();
		mp.stop();
	}
}//end of class
