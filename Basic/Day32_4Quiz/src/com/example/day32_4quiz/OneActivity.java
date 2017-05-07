package com.example.day32_4quiz;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class OneActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		
		AnimationDrawable ad = (AnimationDrawable)findViewById(R.id.imageView1).getBackground();
		ad.start();
		

	}

}
