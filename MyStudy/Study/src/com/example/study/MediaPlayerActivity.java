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
		if (files.exists() == true) { // 영어/일본어 음성 파일이 있는 경우
			try {
				mediaPlayer = new MediaPlayer();
				FileInputStream fis = new FileInputStream(soundPath);
				FileDescriptor fd = fis.getFD();
				mediaPlayer.setDataSource(fd);
				mediaPlayer.prepare();
				// mediaPlayer.setLooping(true); // 연속재생
				mediaPlayer.start();
				/* mediaPlayer가 끝나고 호출되는 메소드 */
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					public void onCompletion(MediaPlayer mediaPlayer) {

					}
				});
			} catch (Exception e) {
			}
		}
	}
}