package com.example.day14_2imageview2;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int img[] = { R.drawable.mountain, R.drawable.travel, R.drawable.bicycle };
	int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView iv = (ImageView) findViewById(R.id.imageView1);

		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				index++;
				if (index == img.length)
					index = 0;
				iv.setImageResource(img[index]);
			}
		});

	}// end of onCreate
}// end of class
