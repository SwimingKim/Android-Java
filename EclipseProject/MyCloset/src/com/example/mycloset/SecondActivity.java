package com.example.mycloset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.second);
		
		ImageView iv = (ImageView)findViewById(R.id.imageView1);
		TextView tType = (TextView)findViewById(R.id.textView1);
		TextView tColor = (TextView)findViewById(R.id.textView2);
		TextView tWeather = (TextView)findViewById(R.id.textView3);
		
		Intent intent = getIntent();
		
		iv.setImageResource(intent.getIntExtra("img", 0));
		tType.setText(intent.getStringExtra("type"));
		tColor.setText(intent.getStringExtra("color"));
		tWeather.setText(intent.getStringExtra("weather"));
		
		
	}
}

