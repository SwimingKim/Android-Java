package com.example.day28_2preference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),Setting.class);
				startActivity(intent);
				
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), ReadSetting.class);
				startActivity(intent);
			}
		});
		
		
	}//end of onCreate
}//end of class