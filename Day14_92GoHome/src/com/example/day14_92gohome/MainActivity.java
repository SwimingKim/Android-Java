package com.example.day14_92gohome;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Toast to;
	
	Rect rect_mu;
	Rect rect_ic;
	Rect ic;
	Handler handler = new Handler();
	Runnable r_mu = new Runnable() {
		public void run() {
			rect_mu.left = (int)iv_mu.getX();
			rect_mu.top = (int)(iv_mu.getY()+iv_mu.getHeight());
			rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
			rect_mu.bottom = (int)iv_mu.getY();
			
			handler.post(r_mu);
		}
	};
	Runnable r_ic = new Runnable() {
		public void run() {
			rect_ic.left = (int)iv_ic.getX();
			rect_ic.top = (int)(iv_ic.getY()+iv_ic.getHeight());
			rect_ic.right = (int)(iv_ic.getX()+iv_ic.getWidth());
			rect_ic.bottom = (int)iv_ic.getY();
			
			handler.post(r_ic);
		}
	};
	Runnable r_check = new Runnable() {
		public void run() {

			String str = "";
			if (rect_mu.intersect(rect_ic)) {
				to.setText("충돌");
				to.setDuration(Toast.LENGTH_SHORT);
				to.show();
				str = "충돌";		
			} 
			
			Log.d("line", "mu"+rect_mu.left+","+rect_mu.top+","+rect_mu.right+","+rect_mu.bottom + ",    ic"+rect_ic.left+","+rect_ic.top+","+rect_ic.right+","+rect_ic.bottom + ",    " + str);
			handler.postDelayed(r_check,10);			
//			handler.post(r_check);	
		}
	};
	private ImageView iv_mu;
	private ImageView iv_ic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		to = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
		Button b1 = (Button)findViewById(R.id.button1);
		Button b2 = (Button)findViewById(R.id.button2);
		Button b3 = (Button)findViewById(R.id.button3);
		Button b4 = (Button)findViewById(R.id.button4);
		Button b5 = (Button)findViewById(R.id.button5);
		Button b6 = (Button)findViewById(R.id.button6);
		iv_mu = (ImageView)findViewById(R.id.imageView1);
		iv_ic = (ImageView)findViewById(R.id.imageView2);
		
		rect_mu = new Rect();
		rect_ic = new Rect();
		
		rect_mu.left = (int)iv_mu.getX();
		rect_mu.top = (int)iv_mu.getY();
		rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
		rect_mu.bottom = (int)(iv_mu.getY()+iv_mu.getHeight());
		
		rect_ic.left = (int)iv_ic.getX();
		rect_ic.top = (int)iv_ic.getY();
		rect_ic.right = (int)(iv_ic.getX()+iv_ic.getWidth());
		rect_ic.bottom = (int)(iv_ic.getY()+iv_ic.getHeight());

//		handler.post(r_check);		

		boolean b11 = new Rect(0,0,100,100).intersect(new Rect(50,50,200,200));
		Log.e("line", "b11 : " + b11);
		
		//1. post -> postdelay
		//2. 뷰의 좌표 는 부모의 뷰 안에서 좌표를 결정하기 때문에, 부모의 좌표를 얻어서 더해줘야 최종 절대좌표가 됨
		//3. 뷰의 크기를 결정하는 시기
		
		iv_mu.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() { // 화면크기를 읽어오는 코드를 작성
				rect_mu.left = (int)iv_mu.getX();
				rect_mu.top = (int)iv_mu.getY();
				rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
				rect_mu.bottom = (int)(iv_mu.getY()+iv_mu.getHeight());
				
				rect_ic.left = (int)iv_ic.getX();
				rect_ic.top = (int)iv_ic.getY();
				rect_ic.right = (int)(iv_ic.getX()+iv_ic.getWidth());
				rect_ic.bottom = (int)(iv_ic.getY()+iv_ic.getHeight());
				
				iv_mu.getViewTreeObserver().removeOnGlobalLayoutListener(this);
			}
		});
		
		b1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv_mu.setX(iv_mu.getX()-20);
				rect_mu.left = (int)iv_mu.getX();
				rect_mu.top = (int)(iv_mu.getY()+iv_mu.getHeight());
				rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
				rect_mu.bottom = (int)iv_mu.getY();
				String str = "";
				if (rect_mu.intersect(rect_ic)) {
					to.setText("충돌");
					to.setDuration(Toast.LENGTH_SHORT);
					to.show();
					str = "충돌";
					Log.e("line", "충돌");
				} 
				Log.d("line", "mu"+rect_mu.left+","+rect_mu.top+","+rect_mu.right+","+rect_mu.bottom + ",    ic"+rect_ic.left+","+rect_ic.top+","+rect_ic.right+","+rect_ic.bottom + ",    " + str);
				return true;
			}
		});
		b2.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv_mu.setX(iv_mu.getX()+20);
				rect_mu.left = (int)iv_mu.getX();
				rect_mu.top = (int)(iv_mu.getY()+iv_mu.getHeight());
				rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
				rect_mu.bottom = (int)iv_mu.getY();
				String str = "";
				if (rect_mu.intersect(rect_ic)) {
					to.setText("충돌");
					to.setDuration(Toast.LENGTH_SHORT);
					to.show();
					str = "충돌";
					Log.e("line", "충돌");
				} 
				Log.d("line", "mu"+rect_mu.left+","+rect_mu.top+","+rect_mu.right+","+rect_mu.bottom + ",    ic"+rect_ic.left+","+rect_ic.top+","+rect_ic.right+","+rect_ic.bottom + ",    " + str);
				return true;
			}
		});
		b3.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv_mu.setY(iv_mu.getY()-20);
				rect_mu.left = (int)iv_mu.getX();
				rect_mu.top = (int)(iv_mu.getY()+iv_mu.getHeight());
				rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
				rect_mu.bottom = (int)iv_mu.getY();
				String str = "";
				if (rect_mu.intersect(rect_ic)) {
					to.setText("충돌");
					to.setDuration(Toast.LENGTH_SHORT);
					to.show();
					str = "충돌";
					Log.e("line", "충돌");
				} 
				Log.d("line", "mu"+rect_mu.left+","+rect_mu.top+","+rect_mu.right+","+rect_mu.bottom + ",    ic"+rect_ic.left+","+rect_ic.top+","+rect_ic.right+","+rect_ic.bottom + ",    " + str);
				return true;
			}
		});
		b4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv_mu.setY(iv_mu.getY()+20);
				rect_mu.left = (int)iv_mu.getX();
				rect_mu.top = (int)(iv_mu.getY()+iv_mu.getHeight());
				rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
				rect_mu.bottom = (int)iv_mu.getY();
				String str = "";
				if (rect_mu.intersect(rect_ic)) {
					to.setText("충돌");
					to.setDuration(Toast.LENGTH_SHORT);
					to.show();
					str = "충돌";
					Log.e("line", "충돌");
				} 
				Log.d("line", "mu"+rect_mu.left+","+rect_mu.top+","+rect_mu.right+","+rect_mu.bottom + ",    ic"+rect_ic.left+","+rect_ic.top+","+rect_ic.right+","+rect_ic.bottom + ",    " + str);
				return true;
			}
		});
		b5.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv_mu.setRotation(iv_mu.getRotation()+20);
				rect_mu.left = (int)iv_mu.getX();
				rect_mu.top = (int)(iv_mu.getY()+iv_mu.getHeight());
				rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
				rect_mu.bottom = (int)iv_mu.getY();
				return true;
			}
		});
		b6.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				iv_mu.setRotation(iv_mu.getRotation()-20);
				rect_mu.left = (int)iv_mu.getX();
				rect_mu.top = (int)(iv_mu.getY()+iv_mu.getHeight());
				rect_mu.right = (int)(iv_mu.getX()+iv_mu.getWidth());
				rect_mu.bottom = (int)iv_mu.getY();
				return true;
			}
		});
		
	}//end of onCreate
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r_ic);
		handler.removeCallbacks(r_mu);
		handler.removeCallbacks(r_check);
	}
}//end of class
