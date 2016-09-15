package com.example.day36_3handler_game;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private Random ran = new Random();
	int count = 0; // 총알의 개수
	int x, y; // 총알의 좌표
	int dx, dy;// 총알의 이동량
	Handler handler = new Handler();
	private ImageView iv1 = null;
	Runnable r = new Runnable() { // 화면을 갱신하는 작업 

		@Override
		public void run() {
			// 자바코드에서 동적으로 위젯을 생성하기
			if (count < 1) {
				iv1 = new ImageView(getApplicationContext());
				iv1.setImageResource(R.drawable.ic_launcher);
				al.addView(iv1);
				x = ran.nextInt(al.getWidth());
				y = ran.nextInt(al.getHeight()); // 초기위치 지정
				dx = ran.nextInt(20)-10;
				dy = ran.nextInt(20);
				count++;
			}
			x+=dx;
			y+=dy;
			// 스크린 벗어났는지 확인하기
			if (x<0||x>al.getWidth()||y<0||y>al.getHeight()) {
				// 스크린에서 벗어나면 이미지 뷰를 제거하기
				al.removeView(iv1);
				count--;//총알 개수 1개 줄이기
			} else {
				iv1.setX(x);
				iv1.setY(y);
			}

			handler.postDelayed(r, 10);//다음 작업을 예약하고 종료
		}
	};
	private AbsoluteLayout al;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		al = (AbsoluteLayout)findViewById(R.id.AbsoluteLayout1);
		Button b_start = (Button)findViewById(R.id.button1);
		Button b_end = (Button)findViewById(R.id.button2);
		b_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				handler.post(r);//화면변경시작
			}
		});
		b_end.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				handler.removeCallbacks(r);
			}
		});

		


	}//end of onCreate
}//end of class
