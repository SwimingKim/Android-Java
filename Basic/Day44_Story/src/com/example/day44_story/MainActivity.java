package com.example.day44_story;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ImageView bg = (ImageView)findViewById(R.id.imageView1);
		final ImageView heart = (ImageView)findViewById(R.id.imageView3);
		
		heart.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction()==MotionEvent.ACTION_UP) {
					Intent intent = new Intent(getApplicationContext(),One.class);
					startActivity(intent);
					finish();
				} else if (event.getAction()==MotionEvent.ACTION_DOWN) {
					bg.setImageResource(R.drawable.second);
				}
				
				
				return true;
			}
		});
		
		
		
		
		
		
	}//end of onCreate
}//end of class
