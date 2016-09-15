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

		final SoundPool sp = new SoundPool(255, // �ִ�ε��� �� �ִ� �������� ����
				AudioManager.STREAM_MUSIC// ��Ʈ��Ÿ��
				, 0);// ����(�⺻��0)
		final int soundID1 = sp.load(this, // ���� ȭ�� �������
				R.raw.s1, // �뷡����
				1);// ����켱����
		final int soundID2 = sp.load(this, R.raw.s2, 1);
		final int soundID3 = sp.load(this, R.raw.s3, 1);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				sp.play(soundID1, // �뷡�������
						1, // ���� ���� float �����Ҹ� 0.0~1.0ū�Ҹ�
						1, // ������ ���� float �����Ҹ� 0.0~1.0ū�Ҹ�
						0, // ����켱���� int
						0, // �ݺ�Ƚ��(loop) int 0:���ݺ�, -1:���ѹݺ�, ���:�ݺ�Ƚ��
						1);// ����ӵ�(rate) float ���ݼӵ�0.5~2.0�ι�ӵ�

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
