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

class Bullet {// �ڹ� Bean
	int x, y;// �Ѿ��� ��ǥ
	int dx, dy;// �Ѿ��� �̵���
	ImageView iv;// �Ѿ��� �̹�����

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
	final int MAX_NUM =20;// �Ѿ��� �ִ� ����

	ArrayList<Bullet> list = new ArrayList<Bullet>(); // �Ѿ� ��ü���� ������ ArrayList

	Handler handler = new Handler();
	Runnable r = new Runnable() { // ȭ���� �����ϴ� �۾� 

		@Override
		public void run() {
			if (list.size() < MAX_NUM) {// �Ѿ� ��ü �߰� ����
				// �ڹ��ڵ忡�� �������� ������ �����ϱ�
				ImageView iv = new ImageView(getApplicationContext());
				iv.setImageResource(R.drawable.bb);
				al.addView(iv, 100, 100);
				// �ʱ� ��ġ ����
				int x = ran.nextInt(al.getWidth());
				int y = ran.nextInt(al.getHeight());
				// �Ѿ��� �̵��� ����
				int dx = ran.nextInt(21)-10;
				int dy = ran.nextInt(21)-10;
				// �Ѿ��� �̵����� 0�̸� ���� => �������� ���Ƿ� ����
				if (dx==0 && dy == 0) {
					dx = ran.nextInt(10)+1;
					dy = ran.nextInt(10)+1;
				}
				
				// �Ѿ��� ���ư��� �������� ȸ���ϰ� �������
				iv.setRotation((float)(Math.atan2(dy,dx)*180/Math.PI)+90);
				

				list.add(new Bullet(x, y, dx, dy, iv));// �ϼ��� �Ѿ� ��ü�� list�� �߰�
			}

			// �� �Ѿ��� ��ġ�� ��ȭ�� ��ŭ �̵�
			//			for (int i = 0; i < list.size(); i++) {
			//			}
			// �ڷᱸ�����鿡�� �߰��� �����ϸ�, �ǳ� �ٴ� ������ �߻��� �� �ִ�.
			// ����, �Ź� ����Ʈ�� ����� Ȯ���ؾ� �ϱ� ������ �ӵ��� �� ������.
			for (int i = list.size()-1; i >= 0; i--) {
				Bullet b = list.get(i);
				b.x+= b.dx;
				b.y+= b.dy;
				// ��ũ�� ������� Ȯ���ϱ�
				if (b.x<0||b.x>al.getWidth()||b.y<0||b.y>al.getHeight()) {
					// ��ũ������ ����� �̹��� �並 �����ϱ�
					al.removeView(b.iv);
					list.remove(i); // �Ѿ˵��� ������ List������ ����
				} else {
					b.iv.setX(b.x);
					b.iv.setY(b.y);
				}
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
