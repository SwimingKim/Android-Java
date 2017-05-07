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
	Runnable r = new Runnable() {// 지금 바로 화면변경작업을 할 경우
		public void run() {// 화면변경 작업
			sec++;
			if (sec>=60) {
				sec=0;
				min++;
			}
			ts.setText(sec+"초");
			tm.setText(min+"분");
			handler.postDelayed(r, 1000);//1초 후에 화면변경을 할 경우
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tm = (TextView)findViewById(R.id.textView1);
		ts = (TextView)findViewById(R.id.textView2);
		// 메인 UI 쓰레드에서만 화면을 변경할 수 있다
		// 		메인 UI쓰레드가 아닌 별도의 쓰레드에서 화면을 변경하고자 하면, 반드시 Handler를 써야 함

		handler.post(r);



	}//end of onCreate
}//end of class
