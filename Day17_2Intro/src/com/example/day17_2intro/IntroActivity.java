package com.example.day17_2intro;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntroActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

		TimerTask task = new TimerTask() {
			public void run() {// ������ �۾��� ���
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);

				finish();// ��Ʈȣ ȭ���� ���ֹ�����
			}
		};

		Timer timer = new Timer();
		timer.schedule(task, 2000);

	}
}