package com.example.day15_2soundplayer;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SoundPool sp = new SoundPool(255, // 최대로딩할 수 있는 음악파일 개수
				AudioManager.STREAM_MUSIC// 스트림타입
				, 0);// 음질(기본값0)
		final int soundID1 = sp.load(this, // 현재 화면 제어권자
				R.raw.s1, // 노래파일
				1);// 재생우선순위
		final int soundID2 = sp.load(this, R.raw.s2, 1);
		final int soundID3 = sp.load(this, R.raw.s3, 1);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sp.play(soundID1, // 노래재생파일
						1, // 왼쪽 볼륨 float 작은소리 0.0~1.0큰소리
						1, // 오른쪽 볼륨 float 작은소리 0.0~1.0큰소리
						0, // 재생우선순위 int
						0, // 반복횟수(loop) int 0:무반복, -1:무한반복, 양수:반복횟수
						1);// 재생속도(rate) float 절반속도0.5~2.0두배속도

			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sp.play(soundID2, 1, 1, 0, 0, 1);
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sp.play(soundID3, 1, 1, 0, 0, 1);
			}
		});

	}// end of onCreate
}// end of class
