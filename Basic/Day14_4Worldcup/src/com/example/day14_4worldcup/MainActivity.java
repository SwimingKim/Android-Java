package com.example.day14_4worldcup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int man[] = { R.drawable.eric, R.drawable.jae, R.drawable.jin, R.drawable.seo, R.drawable.kae, R.drawable.kang,
			R.drawable.lee, R.drawable.park };
	String name[] = { "에릭", "재희", "진구", "서인국", "개리", "강지환", "이현", "박기웅" };
	int indexL = 0;
	int indexR = 1;
	int index = 1;// 현재 인덱스

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView ivL = (ImageView) findViewById(R.id.imageView1);
		final ImageView ivR = (ImageView) findViewById(R.id.imageView2);

		ivL.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				index++;
				if (index == man.length) {// 최종승리
					ivR.setImageResource(R.drawable.ic_launcher);
					// 토스트뛰우기"최종승리"
					Toast.makeText(getApplicationContext(), "최종승리", 1).show();
					// 더이상 진행되지 않게 - 클릭막기
					ivR.setClickable(false);
					ivL.setClickable(false);
				} else {
					indexR = index;
					ivR.setImageResource(man[indexR]);
				}
			}
		});

		ivR.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				index++;
				if (index == man.length) {
					ivL.setImageResource(R.drawable.ic_launcher);
					// 토스트뛰우기"최종승리"
					Toast.makeText(getApplicationContext(), "최종승리", 1).show();
					// 더이상 진행되지 않게 - 클릭막기
					ivR.setClickable(false);
					ivL.setClickable(false);
				} else {
					indexL = index;
					ivL.setImageResource(man[indexL]);
				}

			}
		});

	}// end of onCreate
}// end of class
