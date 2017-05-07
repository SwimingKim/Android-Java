package com.example.day14_91framelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
		final ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
		final ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
		final ImageView iv4 = (ImageView) findViewById(R.id.imageView4);
		final ImageView iv5 = (ImageView) findViewById(R.id.imageView5);

		iv1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv1.setVisibility(View.INVISIBLE);
				iv2.setVisibility(View.VISIBLE);
				iv3.setVisibility(View.INVISIBLE);
				iv4.setVisibility(View.INVISIBLE);
				iv5.setVisibility(View.INVISIBLE);
			}
		});
		iv2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv1.setVisibility(View.INVISIBLE);
				iv2.setVisibility(View.INVISIBLE);
				iv3.setVisibility(View.VISIBLE);
				iv4.setVisibility(View.INVISIBLE);
				iv5.setVisibility(View.INVISIBLE);
			}
		});
		iv3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv1.setVisibility(View.INVISIBLE);
				iv2.setVisibility(View.INVISIBLE);
				iv3.setVisibility(View.INVISIBLE);
				iv4.setVisibility(View.VISIBLE);
				iv5.setVisibility(View.INVISIBLE);
			}
		});
		iv4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv1.setVisibility(View.INVISIBLE);
				iv2.setVisibility(View.INVISIBLE);
				iv3.setVisibility(View.INVISIBLE);
				iv4.setVisibility(View.INVISIBLE);
				iv5.setVisibility(View.VISIBLE);
			}
		});
		iv5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv1.setVisibility(View.VISIBLE);
				iv2.setVisibility(View.INVISIBLE);
				iv3.setVisibility(View.INVISIBLE);
				iv4.setVisibility(View.INVISIBLE);
				iv5.setVisibility(View.INVISIBLE);
			}
		});

	}// end of onCreate
}// end of class
