package com.su.project03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
class EdWard {
	int x,y;
	int dx, dy;
	ImageView iv;

	public EdWard(int x, int y, int dx, int dy, ImageView iv) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.iv = iv;
	}
}

class Kakao {
	int x,y;
	int dx, dy;
	ImageView iv;
	public Kakao(int x, int y, int dx, int dy, ImageView iv) {
		super();
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.iv = iv;
	}
}

public class MainActivity extends Activity {
	SensorManager sm;
	Sensor sensor;
	Random ran;
	private ImageView sally;
	AbsoluteLayout al;
	AnimationDrawable ad_ed;
	AnimationDrawable ad_ka;

	int count = 0;
	int chance = 1; String heart = "♥♥♥";
	final int MAX_ED_NUM = 20;
	final int MAX_KA_NUM = 5;
	ArrayList<EdWard> list = new ArrayList<EdWard>();
	ArrayList<Kakao> rival = new ArrayList<Kakao>();
	
	int level;

	private Intent intent;
	Handler handler = new Handler();
	Runnable r_ed = new Runnable() {//에드워드와 카카오톡 생성
		public void run() {
			// 카카오톡 생성
			if (list.size()<MAX_ED_NUM) {
				ImageView iv = new ImageView(getApplicationContext());
				iv.setBackgroundResource(R.drawable.frame_chink);
				ad_ed = (AnimationDrawable)iv.getBackground();
				ad_ed.start();
				al.addView(iv, 100, 100);

				int x = (ran.nextInt(2)==0) ? 0 : w-sally.getWidth();
				int y = (ran.nextInt(2)==0) ? 0 : h-sally.getHeight()-200;

				int dx = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(5)+1);
				int dy = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(5)+1);

//				iv.setRotation((float)(Math.atan2(dy, dx)*180/Math.PI)+90);
				list.add(new EdWard(x, y, dx, dy, iv));
				
				up.bringToFront();
				down.bringToFront();
				left.bringToFront();
				right.bringToFront();
				tv_level.bringToFront();
				tv_fish.bringToFront();
				tv_chance.bringToFront();
				sally.bringToFront();
			}


			for (int i = list.size()-1; i >= 0; i--){
				EdWard ed = list.get(i);
				ed.x += ed.dx;
				ed.y += ed.dy;

				float xd = Math.abs(ed.x-(sally.getX()+0.3f*level-0.3f*(chance-1)));
				float yd = Math.abs(ed.y-(sally.getY()+0.3f*level-0.3f*(chance-1)));

				if (ed.x<0||ed.x>al.getWidth()||ed.y<0||ed.y>al.getHeight()) {
					al.removeView(ed.iv);
					list.remove(i);
				} else if (xd<(sally.getWidth())/2
						&&yd<(sally.getHeight())/2){
					if (count==10) {
						count=0;
						level++;
						tv_level.setText("Level : "+level);
						sally.setScaleX(sally.getScaleX()+0.3f);
						sally.setScaleY(sally.getScaleY()+0.3f);
						Toast.makeText(getApplicationContext(), "Level Up", 0).show();
						if (level==3) {
							chance = -1;
							Timer timer = new Timer();
							TimerTask task = new TimerTask() {
								public void run() {
									handler.removeCallbacks(r_finish);
									intent.putExtra("결과", "라인");
									startActivity(intent);
									finish();
								}
							};
							timer.schedule(task, 3000);
							sally.setBackgroundResource(R.drawable.smileshark);
							ad_ka.stop();
							ad.stop();
							handler.post(r_finish);
							sm.unregisterListener(sc, sensor);
						} 
						
					} else {
						tv_fish.setText("Catch : "+count);
						al.removeView(ed.iv);
						list.remove(i);
						count++;
					}
				}
				else {
					ed.iv.setX(ed.x);
					ed.iv.setY(ed.y);
				}

			}


			// 카카오톡 관리
			if (rival.size()<MAX_KA_NUM) {
				ImageView iv_ka = new ImageView(getApplicationContext());
				iv_ka.setBackgroundResource(R.drawable.frame_ka);
				ad_ka = (AnimationDrawable)iv_ka.getBackground();
				ad_ka.start();
				al.addView(iv_ka, 100,100);
				
				int x = ran.nextInt(w);
				int y = ran.nextInt(h);
				
				int dx = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(5)+1);
				int dy = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(5)+1);
				
//				iv_ka.setRotation((float)(Math.atan2(dy, dx)*180/Math.PI)+90);
				rival.add(new Kakao(x, y, dx, dy, iv_ka));
				
				up.bringToFront();
				down.bringToFront();
				left.bringToFront();
				right.bringToFront();
				tv_level.bringToFront();
				tv_fish.bringToFront();
				tv_chance.bringToFront();
				sally.bringToFront();				
			}
			


			for (int i = rival.size()-1; i >= 0; i--){
				Kakao ka = rival.get(i);
				ka.x += ka.dx;
				ka.y += ka.dy;

				float xd = Math.abs(ka.x-(sally.getX()+0.3f*level-0.3f*(chance-1)));
				float yd = Math.abs(ka.y-(sally.getY()+0.3f*level-0.3f*(chance-1)));

				if (ka.x<0||ka.x>al.getWidth()||ka.y<0||ka.y>al.getHeight()) {
					al.removeView(ka.iv);
					rival.remove(i);
				} else if (xd<(sally.getWidth())/2
						&&yd<(sally.getHeight())/2){
					if (chance==4) {
						level = 4;
						chance++;
						sally.setBackgroundResource(R.drawable.madshark);
						ad_ed.stop();
						ad.stop();
						handler.post(r_finish);
						sm.unregisterListener(sc, sensor);
						TimerTask task = new TimerTask() {
							public void run() {
								handler.removeCallbacks(r_finish);								
								intent.putExtra("결과", "카톡");
								startActivity(intent);
								finish();
							}
						};
						Timer timer = new Timer();
						timer.schedule(task, 3000);
					} else {
						Toast.makeText(getApplicationContext(), "Chance lose", 0).show();
						sally.setScaleX(sally.getScaleX()-0.3f);
						sally.setScaleY(sally.getScaleY()-0.3f);
						al.removeView(ka.iv);
						rival.remove(i);
						if (chance!=5) {
							tv_chance.setText("Chance : "+heart.substring(chance));
							chance++;
						}
					}
				} else {
					ka.iv.setX(ka.x);
					ka.iv.setY(ka.y);
				}
			}


			handler.postDelayed(r_ed, 40);
		}
	};
	Runnable r_finish = new Runnable() {
		float a =3;
		public void run() {
			sally.setScaleX(a);
			sally.setScaleY(a);
			a+=0.5f;
			handler.postDelayed(r_finish,300);
		}
	};
	private SensorClass sc;
	private int w;
	private int h;
	private AnimationDrawable ad;
	private TextView tv_level;
	private TextView tv_fish;
	private TextView tv_chance;
	private Button up;
	private Button down;
	private Button left;
	private Button right;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		al = (AbsoluteLayout)findViewById(R.id.layout);
		
		tv_level = (TextView)findViewById(R.id.level);
		tv_fish =  (TextView)findViewById(R.id.fish);
		tv_chance =  (TextView)findViewById(R.id.chance);
		
		tv_level.setText("Level : "+0);
		tv_fish.setText("Catch : "+0);
		tv_chance.setText("Chance : "+"♥♥♥");
		
		final Button b_all = (Button)findViewById(R.id.all);
		final Button b_line = (Button)findViewById(R.id.line);
		final Button b_kakao = (Button)findViewById(R.id.kakao);
		
		up = (Button)findViewById(R.id.up);
		down = (Button)findViewById(R.id.down);
		left = (Button)findViewById(R.id.left);
		right = (Button)findViewById(R.id.right);
		
		b_all.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				b_all.setEnabled(false);
				b_all.setText("");
				for (int i = list.size()-1; i >= 0; i--) {
					al.removeView(list.get(i).iv);
					list.remove(i);
				}
				for (int i = rival.size()-1; i >= 0; i--) {
					al.removeView(rival.get(i).iv);
					rival.remove(i);
				}				
			}
		});
		b_line.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				b_line.setEnabled(false);
				b_line.setText("");
				for (int i = list.size()-1; i >= 0; i--) {
					al.removeView(list.get(i).iv);
					list.remove(i);
				}
			}
		});
		b_kakao.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				b_kakao.setEnabled(false);
				b_kakao.setText("");
				for (int i = rival.size()-1; i >= 0; i--) {
					al.removeView(rival.get(i).iv);
					rival.remove(i);
				}
			}
		});
		
		Intent pri = getIntent();
		String str = pri.getStringExtra("모드");
		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sc = new SensorClass();
		
		if ("센서".equals(str)) {
			up.setVisibility(View.GONE);
			down.setVisibility(View.GONE);
			left.setVisibility(View.GONE);
			right.setVisibility(View.GONE);
			sensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		} else if ("터치".equals(str)) {
			sm.unregisterListener(sc);
		}
		
		intent = new Intent(getApplicationContext(), LastActivity.class);
		ran = new Random();

		WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
		Display dp = wm.getDefaultDisplay();
		Point p = new Point();
		dp.getSize(p);
		w = p.x;
		h = p.y;

		sally = new ImageView(getApplicationContext());
		sally.setBackgroundResource(R.drawable.frame_sally);
		ad = (AnimationDrawable)sally.getBackground();
		al.addView(sally, 200, 180);
		sally.setX(500); sally.setY(700);
		
		handler.post(r_ed);
		
		up.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				float py = sally.getY()-15;
				if (py<0) {
					py = 0;
				}
				sally.setY(py);
				ad.start();
				return false;
			}
		});
		down.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				float py = sally.getY()+15;
				if (py>h-sally.getHeight()-200) {
					py = h-sally.getHeight()-200;
				}
				sally.setY(py);
				ad.start();
				return false;
			}
		});
		left.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				float px = sally.getX()-15;
				if (px<0) {
					px = 0;
				}
				sally.setX(px);
				ad.start();
				return false;
			}
		});
		right.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				float px = sally.getX()+15;
				if (px>w-sally.getWidth()) {
					px = w-sally.getWidth();
				}
				sally.setX(px);
				ad.start();
				return false;
			}
		});


	}//end of onCreate

	@Override
	protected void onResume() {
		super.onResume();
		sm.registerListener(sc, sensor, SensorManager.SENSOR_DELAY_GAME);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sm.unregisterListener(sc, sensor);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r_ed);
		handler.removeCallbacks(r_finish);
	}

	class SensorClass implements SensorEventListener {
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

		public void onSensorChanged(SensorEvent event) {
			if (event.values!=null) {
				ad.start();
				float px = sally.getX()-event.values[2]*0.5f; 
				float py = sally.getY()-event.values[1]*0.5f; 

				if (px<0) px = 0;
				if (px>w-sally.getWidth()) px = w-sally.getWidth();

				if (py<0) py = 0;
				if (py>h-sally.getHeight()-200) py = h-sally.getHeight()-200;

				sally.setX(px);
				sally.setY(py);
			}
		}

	}

}//end of class
