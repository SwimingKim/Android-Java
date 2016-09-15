package com.example.day40_piglet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntroActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		
		Button b_new = (Button)findViewById(R.id.button1);
		Button b_load = (Button)findViewById(R.id.button2);
		final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		
		b_new.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent.putExtra("모드", "NEW");
				startActivity(intent);
				finish();
			}
		});
		
		b_load.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent.putExtra("모드", "LOAD");
				startActivity(intent);
				finish();
			}
		});
		
		
		
	}//end of onCreate

}//end of class
