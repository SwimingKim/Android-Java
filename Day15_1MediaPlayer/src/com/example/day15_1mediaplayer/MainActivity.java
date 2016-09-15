package com.example.day15_1mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	MediaPlayer mp;// �̵�� �÷��̾� ����
	// int position;//�Ͻ�������

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
			public void onClick(View v) {// ���ǽ���
				// MediaPlayer ��ü�� �ʱ�ȭ �۾��Ѵ�
				if (mp == null || !mp.isPlaying()) {
					mp = MediaPlayer.create(getApplicationContext(), // ���� ȭ��
																		// �������
							R.raw.dontgo);// �뷡����
					mp.start();// �뷡����
					mp.setLooping(true);// �ݺ� ��� ����

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
					mp.stop();// �뷡 ���߱�

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
					mp.pause();// �뷡 �Ͻ�����

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
