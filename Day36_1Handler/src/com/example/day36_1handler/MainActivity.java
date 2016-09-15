package com.example.day36_1handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tm;
	private TextView ts;
	int sec = 0;
	int min = 0;
	Handler handler = new Handler();
	Runnable r = new Runnable() {// ���� �ٷ� ȭ�麯���۾��� �� ���
		public void run() {// ȭ�麯�� �۾�
			sec++;
			if (sec>=60) {
				sec=0;
				min++;
			}
			ts.setText(sec+"��");
			tm.setText(min+"��");
			handler.postDelayed(r, 1000);//1�� �Ŀ� ȭ�麯���� �� ���
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tm = (TextView)findViewById(R.id.textView1);
		ts = (TextView)findViewById(R.id.textView2);
		// ���� UI �����忡���� ȭ���� ������ �� �ִ�
		// 		���� UI�����尡 �ƴ� ������ �����忡�� ȭ���� �����ϰ��� �ϸ�, �ݵ�� Handler�� ��� ��

		handler.post(r);



	}//end of onCreate
}//end of class
