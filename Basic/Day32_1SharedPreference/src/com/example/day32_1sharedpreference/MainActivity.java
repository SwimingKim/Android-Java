package com.example.day32_1sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b1 = (Button)findViewById(R.id.button1);
		Button b2 = (Button)findViewById(R.id.button2);
		
// 설정값저장 방법 : SharedPreferences 파일을 다른 앱과 공유할 수 있다		
		
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
				startActivity(intent);
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), ReadSettingActivity.class);
				startActivity(intent);
			}
		});
		
		
		
		
		
	}//end of onCreate
}//end of class
