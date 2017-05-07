package com.example.pr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		TextView tv2 = (TextView) findViewById(R.id.textView2);

		Intent intent = getIntent();

		Act a = (Act) intent.getSerializableExtra("Act");
		tv1.setText(a.text);
		tv2.setText(a.name);
		iv.setImageResource(a.img);

	}
}
