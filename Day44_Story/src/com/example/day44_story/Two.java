package com.example.day44_story;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Two extends Activity{
	String talk[] = {"1�� ���ҳ�,\n���� ������", "�����,\n�� ���� �첲��", "�ȵſ� �մ�����\n�����ؾ� �ؿ�",
			"���� �߿��� �в�\n�����ؾߵſ�", "�׷� ���� ������\n�� ����� ��������", "�����ϴ�\n���� �����ŵ��"};
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		int i = 0;
		public void run() {
			if (i>talk.length-1) {
				tv_ga.setText("");
				tv_ab.setText("");
				handler.removeCallbacks(r);
				miyo.setEnabled(true);
				handler.post(rgame);
			} else {
				if(i%2!=0) {									
					tv_ga.setText("");
					tv_ab.setText(talk[i]);
				} else if(i%2==0) {				
					tv_ga.setText(talk[i]);
					tv_ab.setText("");
				}	
				handler.postDelayed(r, 1500);
			}
			i++;
		}
	};
	Runnable rgame = new Runnable() {
		public void run() {
			ab.setX(ab.getX()-30);
			ab.setY(ab.getY()-80);
			tv_ga.setText("�̿並 ������\n���� �� �� �־�");
			if (ga.getY()==0||ab.getY()==0) {
				handler.removeCallbacks(rgame);
				if (ab.getY()==0)  {
					tv_ab.setText("�ƽ�!!\n������ ����������");
					tv_ga.setText("");
				}
				handler.removeCallbacks(rgame);
			} else {
				handler.postDelayed(rgame,1000);
			}
		}
	};
	private TextView tv_ga;
	private TextView tv_ab;
	private ImageView ga;
	private ImageView ab;
	private ImageView miyo;
	private Intent intent;
	private ImageView chun;
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);

		tv_ga = (TextView)findViewById(R.id.gs);
		tv_ab = (TextView)findViewById(R.id.as);

		chun = (ImageView)findViewById(R.id.imageView3);
		ga = (ImageView)findViewById(R.id.ga);
		ab = (ImageView)findViewById(R.id.ab);
		miyo = (ImageView)findViewById(R.id.miyo);
		miyo.setEnabled(false);

		Intent in = getIntent();

		mp = MediaPlayer.create(getApplicationContext(), R.raw.china);
		mp.seekTo(in.getIntExtra("�뷡", 0));
		mp.start();
		mp.setLooping(true);

		handler.post(r);
		intent = new Intent(getApplicationContext(),Three.class);

		chun.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_DOWN) {
					if ("�ƽ�!!\n������ ����������".equals(tv_ga.getText().toString())
							|| "�ƽ�!!\n������ ����������".equals(tv_ab.getText().toString())) {
						intent.putExtra("�뷡", mp.getCurrentPosition());
						startActivity(intent);
						finish();
					}
				}
				return false;
			}
		});

	}//end of onCreate

	public boolean onTouchEvent(MotionEvent event) {
		if ("�̿並 ������\n���� �� �� �־�".equals(tv_ga.getText().toString())) {
			if (event.getAction()==MotionEvent.ACTION_MOVE
					||event.getAction()==MotionEvent.ACTION_DOWN
					||event.getAction()==MotionEvent.ACTION_UP) {
				if (ga.getY()==0){
					handler.removeCallbacks(rgame);
					tv_ga.setText("�ƽ�!!\n������ ����������");
					tv_ab.setText("");
				} else{
					ga.setX(ga.getX()+3);
					ga.setY(ga.getY()-8);
				}
			}

		}
		return true;
	}

	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r);
		handler.removeCallbacks(rgame);
		mp.stop();
	}
}//end of class