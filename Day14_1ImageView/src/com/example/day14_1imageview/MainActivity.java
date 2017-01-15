package com.example.day14_1imageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView iv1, iv2, iv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 버튼, 이미지뷰, 이미지를 연결
		Button b1 = (Button) findViewById(R.id.button1);
		final ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
		final ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
		final ImageView iv3 = (ImageView) findViewById(R.id.imageView3);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 이미지 바꾸는 방법
				iv1.setImageResource(R.drawable.poongsun);
				iv2.setImageResource(R.drawable.sky);
				iv3.setImageResource(R.drawable.travel);
			}
		});

	}// end of onCreate
}// end of class
