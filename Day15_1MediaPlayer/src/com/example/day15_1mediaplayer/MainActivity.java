package com.example.day15_1mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	MediaPlayer mp;// 미디어 플레이어 변수
	// int position;//일시정지용

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button bStart = (Button) findViewById(R.id.button1);
		final Button bPause = (Button) findViewById(R.id.button2);
		final Button bRestart = (Button) findViewById(R.id.button3);
		final Button bStop = (Button) findViewById(R.id.button4);

		bStart.setEnabled(true);
		bPause.setEnabled(false);
		bRestart.setEnabled(false);
		bStop.setEnabled(false);

		bStart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {// 음악시작
				// MediaPlayer 객체를 초기화 작업한다
				if (mp == null || !mp.isPlaying()) {
					mp = MediaPlayer.create(getApplicationContext(), // 현재 화면
																		// 제어권자
							R.raw.dontgo);// 노래파일
					mp.start();// 노래시작
					mp.setLooping(true);// 반복 재생 여부

					bStart.setEnabled(false);
					bPause.setEnabled(true);
					bRestart.setEnabled(false);
					bStop.setEnabled(true);
				}
			}
		});

		bStop.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (mp != null) {
					mp.stop();// 노래 멈추기

					bStart.setEnabled(true);
					bPause.setEnabled(false);
					bRestart.setEnabled(false);
					bStop.setEnabled(false);
				}
			}
		});

		bPause.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (mp != null) {
					// position = mp.getCurrentPosition();
					mp.pause();// 노래 일시정지

					bStart.setEnabled(true);
					bPause.setEnabled(false);
					bRestart.setEnabled(true);
					bStop.setEnabled(true);
				}
			}
		});

		bRestart.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (mp != null) {
					// mp.seekTo(position);
					mp.start();

					bStart.setEnabled(false);
					bPause.setEnabled(true);
					bRestart.setEnabled(false);
					bStop.setEnabled(true);
				}
			}
		});

	}// end of onCreate
}// end of class
