package com.example.day45_flower;
import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Random ran;
	Handler handler = new Handler();
	private Piglet object_pig;
	Runnable r = new Runnable() {

		public void run() {
			if (pig.size()<1) {
				AAA();
			}
			object_pig = pig.get(0);
			object_pig.iv.bringToFront();

			object_pig.x += object_pig.dx*1.1f;
			object_pig.y += object_pig.dy*1.1f;

			if (object_pig.x<10) object_pig.dx *= -1;
			if (object_pig.x>al.getWidth()-150) object_pig.dx *= -1;
			if (object_pig.y<10) object_pig.dy *= -1;
			if (object_pig.y>al.getHeight()-180) object_pig.dy *= -1;

			object_pig.iv.setX(object_pig.x);
			object_pig.iv.setY(object_pig.y);

			object_pig.iv.setOnTouchListener(new OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					if (event.getAction()==MotionEvent.ACTION_DOWN) {
						SaveX = event.getX();
						SaveY = event.getY();					
						if (SaveX<10) SaveX=10;
						if (SaveX>al.getWidth()-150) SaveX = al.getWidth()-160;
						if (SaveY<10) SaveY=10;
						if (SaveY>al.getHeight()-170) SaveY = al.getHeight()-180;	
					} else if (event.getAction()==MotionEvent.ACTION_UP) {
						float x = object_pig.iv.getX()-(difX);
						float y = object_pig.iv.getY()-(difY);
						if (x<10) x=10;
						if (x>al.getWidth()-150) x = al.getWidth()-160;
						if (y<10) y=10;
						if (y>al.getHeight()-170) y = al.getHeight()-180;						
						object_pig.iv.setX(x);
						object_pig.iv.setY(y);
					} else if (event.getAction()==MotionEvent.ACTION_MOVE) {
						moveX = event.getX();
						moveY = event.getY();
						difX=SaveX-moveX;
						difY=SaveY-moveY;
						float x = object_pig.iv.getX()-(difX);
						float y = object_pig.iv.getY()-(difY);

						if (x<10) x=10;
						if (x>al.getWidth()-150) x = al.getWidth()-160;
						if (y<10) y=10;
						if (y>al.getHeight()-170) y = al.getHeight()-180;			

						object_pig.iv.setX(x);
						object_pig.iv.setY(y);
						object_pig.x=(int)(object_pig.iv.getX()-(difX));
						object_pig.y=(int)(object_pig.iv.getY()-(difY));
					}
					return true;
				}
			});

			handler.postDelayed(r, 10);
		}
	};
	Runnable rFlo = new Runnable() {
		int pos = 0;

		public void run() {
			ImageView iv = new ImageView(getApplicationContext());
			iv.setImageResource(R.drawable.flower);

			int x = object_pig.x;
			int y = object_pig.y;
			iv.setX(object_pig.x);
			iv.setY(object_pig.y);

			flo.add(new Flower(x, y, iv));

			al.addView(iv,80,80);
			pos++;

			// 길 따라 꽃 생성
			handler.postDelayed(rFlo,100);
		}
	};

	class Piglet {
		int x, y;
		int dx, dy;
		ImageView iv;
		public Piglet(int x, int y, int dx, int dy, ImageView iv) {
			super();
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
			this.iv = iv;
		}
	}
	class Flower {
		int x, y;
		ImageView iv;
		public Flower(int x, int y, ImageView iv) {
			super();
			this.x = x;
			this.y = y;
			this.iv = iv;
		}
	}
	ArrayList<Piglet> pig = new ArrayList<Piglet>();
	ArrayList<Flower> flo = new ArrayList<Flower>();
	private AbsoluteLayout al;
	private Button b;
	private Button bClear;
	float SaveX;
	float SaveY;
	private float moveX;
	private float moveY;
	private float difX;
	private float difY;
	private AnimationDrawable ad;
	MediaPlayer mp;
	int img[] = {R.drawable.one, R.drawable.two, R.drawable.three,R.drawable.back};
	int num = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mp = MediaPlayer.create(getApplicationContext(), R.raw.pooh);
		ran = new Random();
		al = (AbsoluteLayout)findViewById(R.id.layout);
		b = (Button)findViewById(R.id.button1);
		bClear = (Button)findViewById(R.id.button2);
		Button bBack = (Button)findViewById(R.id.button3);

		b.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN) {
					if ("시작".equals(b.getText().toString())) {
						b.setText("정지");
						handler.post(r);
						handler.post(rFlo);
						mp.start();
						mp.setLooping(true);
					} else {
						handler.removeCallbacks(rFlo);
						handler.removeCallbacks(r);
						b.setText("시작");		
						mp.pause();
					}

				}
				return false;
			}
		});


		bClear.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN) {
					for (int i = flo.size()-1; i >= 0; i--) {
						al.removeView(flo.get(i).iv);
						flo.remove(i);
					}

				}


				return true;
			}
		});

		bBack.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN) {
					al.setBackgroundResource(img[num]);
					num++;
					if (num>img.length-1) {
						num = 0;
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
		handler.removeCallbacks(rFlo);
		ad.stop();
		mp.stop();
	}
	void AAA(){
		ImageView iv = new ImageView(getApplicationContext());
		iv.setBackgroundResource(R.drawable.frame_piglet);
		ad = (AnimationDrawable)iv.getBackground();
		ad.start();

		int x = ran.nextInt(al.getWidth()-130)+10;
		int y = ran.nextInt(al.getHeight()-160)+10;

		int dx = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(5)+5);
		int dy = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(5)+5);

		pig.add(new Piglet(x, y, dx, dy, iv));
		al.addView(iv, 120, 120);
	}




}//end of class
