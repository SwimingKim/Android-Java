package com.example.study;

import java.util.HashMap;
import java.util.Locale;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.speech.tts.TextToSpeech.OnInitListener;

public class TTSActivity extends Activity{
	private TextToSpeech myTTS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		// TextToSpeech
		// 1. 가장 쉬운 방법
		myTTS = new TextToSpeech(this, new OnInitListener() {
			public void onInit(int status) {
				if(status != TextToSpeech.ERROR) {  
					myTTS.setLanguage(Locale.ENGLISH);  
				}  
			}
		});
		myTTS.setLanguage(Locale.US);
		String utteranceId=this.hashCode() + "";  
		myTTS.speak("", TextToSpeech.QUEUE_FLUSH, null, utteranceId);  
		
		// 2. tts종료 확인
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"stringId");

		myTTS.speak("아", TextToSpeech.QUEUE_FLUSH, params);
		myTTS.setOnUtteranceProgressListener(new UtteranceProgressListener() {
			public void onStart(String utteranceId) {

			}

			public void onError(String utteranceId) {
			}

			public void onDone(String utteranceId) {
				//tts 종료 후 실행
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (myTTS != null) {
			myTTS.stop();
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if (myTTS != null) {
			myTTS.stop();
		}
	}
}
