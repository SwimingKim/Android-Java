package com.example.day40_piglet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
	int x,y;
	ImageView iv;
	public Flower(int x, int y, ImageView iv) {
		super();
		this.x = x;
		this.y = y;
		this.iv = iv;
	}
}

public class MainActivity extends Activity {

	Random ran;
	AbsoluteLayout al;
	int w, h;
	int count, flower;
	int level;
	int MAX_FLOWER = 5;
	int MINUM_PIG = 3;
	final int DIALOG_ADDPIG = 0;
	private TextView tv_result;
	private TextView tv_level;
	float SaveX;
	float SaveY;
	private float moveX;
	private float moveY;
	private float difX;
	private float difY;

	ArrayList<Piglet> pig = new ArrayList<Piglet>();
	ArrayList<Flower> flo = new ArrayList<Flower>();
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		public void run() {
			tv_result.setText("누적된 꽃의 수 : "+count+"\n모은 꽃의 수 : "+flower);
			tv_level.setText("레벨 : "+level+"\n피글렛 : "+pig.size()+"   꽃 : "+MAX_FLOWER);
			// 꽃 생성
			if (flo.size()<MAX_FLOWER) {
				BuyFlower();
			}
			// 피글릿 생성
			if (pig.size()<MINUM_PIG) {
				AddPiglet();
			}


			// 피글렛 움직임 및 충돌 관리
			for (int i = pig.size()-1; i >= 0; i--){
				final Piglet object_pig = pig.get(i);


				object_pig.x += object_pig.dx;
				object_pig.y += object_pig.dy;
				object_pig.iv.bringToFront();

				if (object_pig.x<0) object_pig.dx *= -1;
				if (object_pig.x>w-object_pig.iv.getWidth()) object_pig.dx *= -1;
				if (object_pig.y<0) object_pig.dy *= -1;
				if (object_pig.y>h-600) object_pig.dy *= -1;


				for (int j = flo.size()-1; j >= 0; j--){
					Flower object = flo.get(j);
					float xd = Math.abs(object_pig.x-object.iv.getX());
					float yd = Math.abs(object_pig.y-object.iv.getY());

					if (xd<object.iv.getWidth()/2&&yd<object.iv.getHeight()) {
						count++; flower++;
						al.removeView(object.iv);
						flo.remove(j);
					}
				}

				object_pig.iv.setX(object_pig.x);
				object_pig.iv.setY(object_pig.y);

				if (pig.size()/10>level) {
					level++;
					MAX_FLOWER++;
				}






			}

			//			for (int i = pig.size()-1; i >= 0; i--){
			//				Piglet object_pig = pig.get(i);
			//
			//			}

			handler.postDelayed(r, 10);
		}
	};
	Runnable r_check = new Runnable() {
		public void run() {
			for (int i = pig.size()-1; i >= 0; i--){
				final Piglet object_pig = pig.get(i);

				object_pig.iv.setOnTouchListener(new OnTouchListener() {
					public boolean onTouch(View v, MotionEvent event) {
						if (event.getAction()==MotionEvent.ACTION_DOWN) {
							SaveX = event.getX();
							SaveY = event.getY();
							object_pig.iv.setX(SaveX);
							object_pig.iv.setY(SaveY);							
						} else if (event.getAction()==MotionEvent.ACTION_UP) {
							object_pig.iv.setX(object_pig.iv.getX()-(difX));
							object_pig.iv.setY(object_pig.iv.getY()-(difY));
						} else if (event.getAction()==MotionEvent.ACTION_MOVE) {
							moveX = event.getX();
							moveY = event.getY();
							difX=SaveX-moveX;
							difY=SaveY-moveY;
							object_pig.iv.setX(object_pig.iv.getX()-(difX));
							object_pig.iv.setY(object_pig.iv.getY()-(difY));
							object_pig.x=(int)(object_pig.iv.getX()-(difX));
							object_pig.y=(int)(object_pig.iv.getY()-(difY));
						}

						for (int j = flo.size()-1; j >= 0; j--){
							Flower object = flo.get(j);
							float xd = Math.abs(object_pig.x-object.iv.getX());
							float yd = Math.abs(object_pig.y-object.iv.getY());

							if (xd<object.iv.getWidth()/2&&yd<object.iv.getHeight()) {
								count++; flower++;
								al.removeView(object.iv);
								flo.remove(j);
							}
						}
						return true;
					}
				});
			}
			handler.post(r_check);
//			handler.post(r);
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		al = (AbsoluteLayout)findViewById(R.id.mylayout);
		ran = new Random();

		Display dp = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		Point p = new Point();
		dp.getSize(p);
		w = p.x; h = p.y;

		tv_result = (TextView)findViewById(R.id.result);		
		tv_level = (TextView)findViewById(R.id.level);

		Intent intent = getIntent();
		String mode = intent.getStringExtra("모드");
		if ("NEW".equals(mode)) {
			Toast.makeText(getApplicationContext(), mode, 0).show();
		} else if ("LOAD".equals(mode)) {
			Toast.makeText(getApplicationContext(), mode, 0).show();
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("game.txt")));
				String result = "";

				int i = 0;
				while (true) {
					String str = br.readLine();					
					if (str==null) break;
					if (str.substring(0,4).equals("COU:")) {
						count = Integer.valueOf(str.substring(4));
					}
					str = br.readLine();
					if (str.substring(0,4).equals("FLO:")) {
						flower = Integer.valueOf(str.substring(4));
					}
					str = br.readLine();
					if (str.substring(0,4).equals("PIG:")) {
						MINUM_PIG = Integer.valueOf(str.substring(4));
					}
					str = br.readLine();
					if (str.substring(0,4).equals("LEV:")) {
						level = Integer.valueOf(str.substring(4));
					}
					str = br.readLine();
					if (str.substring(0,4).equals("MAX:")) {
						MAX_FLOWER = Integer.valueOf(str.substring(4));
					}
				}
				tv_result.setText("누적된 꽃의 수 : "+count+"\n모은 꽃의 수 : "+flower);
				tv_level.setText("레벨 : "+level+"\n피글렛 : "+pig.size()+"   꽃 : "+MAX_FLOWER);
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Button b = (Button)findViewById(R.id.pigadd);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_ADDPIG);
			}
		});
		handler.post(r_check);
		final Button b_po = (Button)findViewById(R.id.position);
		if (b_po.getText().toString().equals("피글렛 정지")) {
			handler.post(r);
		} else if (b_po.getText().toString().equals("피글렛 동작")){
		}
		b_po.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (b_po.getText().toString().equals("피글렛 정지")) {
					for (int i = pig.size()-1; i >= 0; i--){
						Piglet object_pig = pig.get(i);
						object_pig.iv.bringToFront();

						object_pig.dx = 0;
						object_pig.dy = 0;
					}
					b_po.setText("피글렛 동작");
				} else {
					for (int i = pig.size()-1; i >= 0; i--){
						Piglet object_pig = pig.get(i);
						object_pig.iv.bringToFront();

						int dx = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(6)+2);
						int dy = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(6)+2);

						object_pig.dx = dx;
						object_pig.dy = dy;
					}
					b_po.setText("피글렛 정지");
				}
			}
		});



		Button b_save = (Button)findViewById(R.id.save);
		b_save.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					FileOutputStream fos = openFileOutput("game.txt", Context.MODE_PRIVATE);
					PrintWriter out = new PrintWriter(fos);
					out.println("COU:"+count);//누적된 꽃의 수
					out.println("FLO:"+flower);//현재 가지고 있는 수
					out.println("PIG:"+pig.size());//피글렛의 수
					out.println("LEV:"+level);//레벨
					out.println("MAX:"+MAX_FLOWER);//화면 상의 꽃의 개수
					out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				Toast.makeText(getApplicationContext(), "저장되었습니다", 0).show();
			}
		});





	}//end of onCreate

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ADDPIG:
			AlertDialog.Builder dialog1 = new Builder(this);
			dialog1.setTitle("피글렛 추가");
			dialog1.setMessage("피글렛을 추가하기 위해서는 \n꽃이 10개 필요합니다. \n피글렛을 추가하시겠습니까?");
			dialog1.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					if (flower>=10) {
						AddPiglet();
						flower-=10;
						MINUM_PIG++;
					} else {
						Toast.makeText(getApplicationContext(), "꽃이 부족합니다", 0).show();
					}
				}
			});
			dialog1.setNegativeButton("아니오", null);
			return dialog1.create();
		default:
			break;
		}
		return super.onCreateDialog(id);
	}

	void AddPiglet() {
		ImageView iv = new ImageView(getApplicationContext());
		iv.setBackgroundResource(R.drawable.frame_piglet);
		AnimationDrawable ad = (AnimationDrawable)iv.getBackground();
		ad.start();

		int x = ran.nextInt(w-70);
		int y = ran.nextInt(1250)+100;

		int dx = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(6)+2);
		int dy = ((ran.nextInt(2)==0)?1:(-1))*(ran.nextInt(6)+2);

		//		iv.setRotation((float)(Math.atan2(dy, dx)*180/Math.PI)+90);

		pig.add(new Piglet(x, y, dx, dy, iv));
		al.addView(iv, 150, 150);
	}

	void BuyFlower() {
		ImageView iv = new ImageView(getApplicationContext());
		iv.setImageResource(R.drawable.flower);

		int x = ran.nextInt(w-170)+40;
		int y = ran.nextInt(1250)+100;

		al.addView(iv);
		flo.add(new Flower(x, y, iv));

		for (int i = flo.size()-1; i >= 0; i--){
			Flower object_flo = flo.get(i);
			object_flo.iv.setX(object_flo.x);
			object_flo.iv.setY(object_flo.y);
		}
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
