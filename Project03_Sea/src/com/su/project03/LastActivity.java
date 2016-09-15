package com.su.project03;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LastActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.last);
		
		ImageView iv = (ImageView)findViewById(R.id.imageView1);
		TextView tv = (TextView)findViewById(R.id.textView1);
		LinearLayout ll = (LinearLayout)findViewById(R.id.mylayout);
		
		Intent intent = getIntent();
		String str = intent.getStringExtra("결과");
		tv.setText(str);
		if ("라인".equals(str)){
			iv.setImageResource(R.drawable.win);
			ll.setBackgroundColor(Color.rgb(77, 174, 207));
			tv.setText("Shark Win");
		} 
		if ("카톡".equals(str)){
			iv.setImageResource(R.drawable.loose);
			ll.setBackgroundColor(Color.rgb(223, 186, 186));
			tv.setText("Shark Lose");
		}
		
		Button b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),IntroActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
	}//end of onCreate

}//end of class
