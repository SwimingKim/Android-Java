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
	int count = 0; // �Ѿ��� ����
	int x, y; // �Ѿ��� ��ǥ
	int dx, dy;// �Ѿ��� �̵���
	Handler handler = new Handler();
	private ImageView iv1 = null;
	Runnable r = new Runnable() { // ȭ���� �����ϴ� �۾� 

		@Override
		public void run() {
			// �ڹ��ڵ忡�� �������� ������ �����ϱ�
			if (count < 1) {
				iv1 = new ImageView(getApplicationContext());
				iv1.setImageResource(R.drawable.ic_launcher);
				al.addView(iv1);
				x = ran.nextInt(al.getWidth());
				y = ran.nextInt(al.getHeight()); // �ʱ���ġ ����
				dx = ran.nextInt(20)-10;
				dy = ran.nextInt(20);
				count++;
			}
			x+=dx;
			y+=dy;
			// ��ũ�� ������� Ȯ���ϱ�
			if (x<0||x>al.getWidth()||y<0||y>al.getHeight()) {
				// ��ũ������ ����� �̹��� �並 �����ϱ�
				al.removeView(iv1);
				count--;//�Ѿ� ���� 1�� ���̱�
			} else {
				iv1.setX(x);
				iv1.setY(y);
			}

			handler.postDelayed(r, 10);//���� �۾��� �����ϰ� ����
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
				handler.post(r);//ȭ�麯�����
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
