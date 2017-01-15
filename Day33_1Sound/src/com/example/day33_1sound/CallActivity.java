package com.example.day33_1sound;


import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class CallActivity extends Activity{
	SoundPool sp1;
	SoundPool sp2;
	SoundPool sp3;
	int soundID1;
	int soundID2;
	int soundID3;
	MediaPlayer mp;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.call);
		
		sp1 = new SoundPool(3,AudioManager.STREAM_MUSIC, 0);
		sp2 = new SoundPool(3,AudioManager.STREAM_MUSIC, 0);
		sp3 = new SoundPool(3,AudioManager.STREAM_MUSIC, 0);
		soundID1 = sp1.load(this,R.raw.cry, soundID1);
		soundID2 = sp2.load(this,R.raw.smile,soundID2);
		soundID3 = sp3.load(this,R.raw.good,soundID3);
		
		Intent intent = getIntent();
		if (intent.getStringExtra("상").equals("cry")) {
			
			mp = MediaPlayer.create(getApplicationContext(), //현재 화면 제어권자
					R.raw.cry);
			mp.start();
//			sp1.play(soundID1, 1, 1, 0, 0, 1);
		} 
		if (intent.getStringExtra("상").equals("smile")) {
//			if(mp!=null&&mp.isPlaying()) mp.stop();
			mp = MediaPlayer.create(getApplicationContext(), //현재 화면 제어권자
					R.raw.smile);
			mp.start();
//			sp2.play(soundID2, 1, 1, 0, 0, 1);
		} 
		if (intent.getStringExtra("상").equals("good")) {
//			if(mp!=null&&mp.isPlaying()) mp.stop();
			mp = MediaPlayer.create(getApplicationContext(), //현재 화면 제어권자
					R.raw.good);
			mp.start();
//			sp3.play(soundID3, 1, 1, 0, 0, 1);
		}

		
		

		findViewById(R.id.imageView2).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "통화종료", 0).show();
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				if(mp!=null&&mp.isPlaying()) mp.stop();
				startActivity(intent);
				finish();
			}
		});



	}//end of onCreate
}//end of class

