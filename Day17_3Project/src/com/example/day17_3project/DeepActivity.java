package com.example.day17_3project;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DeepActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deep);

		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		TextView tv3 = (TextView) findViewById(R.id.textView3);
		TextView tv4 = (TextView) findViewById(R.id.textView4);

		Intent intent = getIntent();

		Rest r = (Rest) intent.getSerializableExtra("Rest");
		tv1.setText(r.name);
		tv2.setText(r.address);
		tv3.setText(r.menu);
		tv4.setText(r.number);
		iv.setImageResource(r.img);

	}
}
