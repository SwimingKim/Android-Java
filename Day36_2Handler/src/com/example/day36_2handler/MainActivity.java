package com.example.day36_2handler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {
	int x;//0~화면폭~이미지폭
	int y;//0~화면높이~이미지높이~타이틀바높이
	Handler handler = new Handler();
	ImageView iv;
	ImageView iv2;
	private int w;
	private int h;
	float jx;
	float jy;
	Runnable r = new Runnable() {//화면변경작업
		@Override
		public void run() {
			if (iv.getX()<=w-iv.getWidth()&&iv.getY()==jy) {
				iv.setX(iv.getX()+10);
			} else if (iv.getX()>=jx&&iv.getY()<=jy+h-iv.getHeight()) {
				iv.setY(iv.getY()+10);				
			} else if (iv.getX()>=jx&&iv.getY()>=jy-h+iv.getHeight()) {
				iv.setX(iv.getX()-10);	
			} else {
				iv.setY(iv.getY()-10);	
			}
			handler.postDelayed(r, 10); // 다음 작업을 예약을 걸어놓고 끝내기
		}
	};
	Runnable r2 = new Runnable() {
		@Override
		public void run() {
			handler.postDelayed(r2, 10);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView)findViewById(R.id.imageView1);
		iv2 = (ImageView)findViewById(R.id.imageView2);
		iv2.setVisibility(View.INVISIBLE);
		jx = iv.getX();
		jy = iv.getY();
		
		handler.post(r);
//		handler.post(r2);
		
		
		WindowManager wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
		Display dp = wm.getDefaultDisplay();
		w = dp.getWidth();
		h = dp.getHeight();
		
		
		
		
	}//end of onCreate
}//end of class
