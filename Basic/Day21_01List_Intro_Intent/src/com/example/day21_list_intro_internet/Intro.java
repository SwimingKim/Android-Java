package com.example.day21_list_intro_internet;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Intro extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);// xml 과 연결하는 작업
		// 인트로 화면

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {// 잠시후 예약 실행할 작업을 기술한다.
				// 다음화면(MainActivity)으로 넘어간다.

				// 1. 다음 넘어갈 화면(xml, java)을 준비한다.
				// 2. 화면을 Androidmainfest.xml 에 등록한다.
				// 3. Intent 객체를 만들어서 화면전환 한다.

				Intent intent = new Intent(getApplicationContext(), // 현재화면의
						MainActivity.class); // 다음 넘어갈 클래스
				startActivity(intent); // 화면전환
			}
		}, 3000);

	}// end of onCreate
}// end of class
