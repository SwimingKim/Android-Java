package com.example.day15_3buttonevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		final TextView tv = (TextView) findViewById(R.id.textView1);

		b1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				// event.getAction();
				tv.setText("터치이벤트 : ");
				Log.d("event", "터치 이벤트 : ");
				return false;
			}
		});

		b2.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				tv.setText("롱클릭 이벤트 : ");
				Log.d("event", "롱클릭 이벤트 : ");
				return false;
			}
		});

		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tv.setText("클릭 이벤트 : ");
				Log.d("event", "클릭 이벤트 : ");
			}
		});
		//////////////////////////////
		b4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {
					tv.setText("터치이벤트 : 다운");
					Log.d("이벤트", "터치이벤트 : 다운");
				} else if (MotionEvent.ACTION_UP == event.getAction()) {
					tv.setText("터치이벤트 : 업");
					Log.d("이벤트", "터치이벤트 : 업");
				} else if (MotionEvent.ACTION_MOVE == event.getAction()) {
					tv.setText("터치이벤트 : 무브");
					Log.d("이벤트", "터치이벤트 : 무브");
				}
				return false;// 리턴값의 의미
				// true : 발생한 이벤트를 다른 리스너에 전달하지 않음
			}
		});
		b4.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				tv.setText("롱클릭이벤트");
				Log.d("event", "롱클릭이벤트");
				return false;
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tv.setText("클릭이벤트");
				Log.d("event", "클릭이벤트");
				// 마지막 이벤트이므로 전달받을 이벤트가 없어서 반환값이 없다
			}
		});

	}// end of onCreate
}// end of class
