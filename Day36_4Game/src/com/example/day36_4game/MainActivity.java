package com.example.day36_4game;

import java.util.ArrayList;
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

class Bullet {// 자바 Bean
	int x, y;// 총알의 좌표
	int dx, dy;// 총알의 이동량
	ImageView iv;// 총알의 이미지뷰

	public Bullet(int x, int y, int dx, int dy, ImageView iv) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.iv = iv;
	}
}

public class MainActivity extends Activity {
	private Random ran = new Random();
	final int MAX_NUM =20;// 총알의 최대 개수

	ArrayList<Bullet> list = new ArrayList<Bullet>(); // 총알 객체들을 저장할 ArrayList

	Handler handler = new Handler();
	Runnable r = new Runnable() { // 화면을 갱신하는 작업 

		@Override
		public void run() {
			if (list.size() < MAX_NUM) {// 총알 객체 추가 생성
				// 자바코드에서 동적으로 위젯을 생성하기
				ImageView iv = new ImageView(getApplicationContext());
				iv.setImageResource(R.drawable.bb);
				al.addView(iv, 100, 100);
				// 초기 위치 지정
				int x = ran.nextInt(al.getWidth());
				int y = ran.nextInt(al.getHeight());
				// 총알의 이동량 지정
				int dx = ran.nextInt(21)-10;
				int dy = ran.nextInt(21)-10;
				// 총알의 이동량이 0이면 정지 => 움직임을 임의로 지정
				if (dx==0 && dy == 0) {
					dx = ran.nextInt(10)+1;
					dy = ran.nextInt(10)+1;
				}
				
				// 총알이 날아가는 방향으로 회전하게 만들려면
				iv.setRotation((float)(Math.atan2(dy,dx)*180/Math.PI)+90);
				

				list.add(new Bullet(x, y, dx, dy, iv));// 완성된 총알 객체를 list에 추가
			}

			// 각 총알의 위치를 변화량 만큼 이동
			//			for (int i = 0; i < list.size(); i++) {
			//			}
			// 자료구조측면에서 중간에 삭제하면, 건너 뛰는 문제를 발생할 수 있다.
			// 또한, 매번 리스트의 사이즈를 확인해야 하기 때문에 속도가 더 느리다.
			for (int i = list.size()-1; i >= 0; i--) {
				Bullet b = list.get(i);
				b.x+= b.dx;
				b.y+= b.dy;
				// 스크린 벗어났는지 확인하기
				if (b.x<0||b.x>al.getWidth()||b.y<0||b.y>al.getHeight()) {
					// 스크린에서 벗어나면 이미지 뷰를 제거하기
					al.removeView(b.iv);
					list.remove(i); // 총알들을 저장한 List에서도 제거
				} else {
					b.iv.setX(b.x);
					b.iv.setY(b.y);
				}
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
