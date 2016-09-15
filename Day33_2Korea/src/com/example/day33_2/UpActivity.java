package com.example.day33_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class UpActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.up);
		
		Intent intent = getIntent();
		ImageView iv = (ImageView)findViewById(R.id.imageView1);
		iv.setImageResource(intent.getIntExtra("±×¸²", 0));
	}

}
