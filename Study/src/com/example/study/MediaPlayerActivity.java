package com.example.study;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;

public class MediaPlayerActivity extends Activity{
	private MediaPlayer mediaPlayer;
	private String soundPath;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mediaPlayer = new MediaPlayer();
		File files = new File(soundPath);
		if (files.exists() == true) { // ����/�Ϻ��� ���� ������ �ִ� ���
			try {
				mediaPlayer = new MediaPlayer();
				FileInputStream fis = new FileInputStream(soundPath);
				FileDescriptor fd = fis.getFD();
				mediaPlayer.setDataSource(fd);
				mediaPlayer.prepare();
				// mediaPlayer.setLooping(true); // �������
				mediaPlayer.start();
				/* mediaPlayer�� ������ ȣ��Ǵ� �޼ҵ� */
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mediaPlayer) {

					}
				});
			} catch (Exception e) {
			}
		}
	}
}