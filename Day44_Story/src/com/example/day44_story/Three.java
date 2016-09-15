package com.example.day44_story;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class Three extends Activity{
	String text[] = {"����� �λ���!! �� ģ�� �ƺ̾�","��!!!!","��..�ȳ��ϼ���"};
	Handler handler = new Handler();
	Runnable r = new Runnable() {
		int i = 0;
		public void run() {
			if (ga.getX()>=100) {
				if (i>=text.length) {
					ab.setImageResource(R.drawable.ab_last);
					ga.setImageResource(R.drawable.ga_last);
					tv.setText("ģ���� �����δ� �纸�ؿ�");
				} else{
					tv.setText(text[i]);
					i++;
					handler.postDelayed(r, 1000);
				}
			} else {
				ga.setX(ga.getX()+20);
				handler.postDelayed(r, 50);
				tv.setText("�ѱ�� �� �Դ�!!");
			}
		}
	};

	private ImageView ab;
	private ImageView ga;
	private ImageView bu;
	private TextView tv;
	private MediaPlayer mp;	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three);
		
		ab = (ImageView)findViewById(R.id.imageView1);
		ga = (ImageView)findViewById(R.id.imageView2);
		bu = (ImageView)findViewById(R.id.imageView3);
		tv = (TextView)findViewById(R.id.textView1);
		ga.setX(-200);
		handler.post(r);
		
		Intent in = getIntent();
		
		mp = MediaPlayer.create(getApplicationContext(), R.raw.china);
		mp.seekTo(in.getIntExtra("�뷡", 0));
		mp.start();
		mp.setLooping(true);
		
		
	}//end of onCreate
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		handler.removeCallbacks(r);
		mp.stop();
	}
}//end of class