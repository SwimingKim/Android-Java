package com.example.day32_1sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.TextView;

public class ReadSettingActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.readset);
		
		TextView tv1 = (TextView)findViewById(R.id.textView1);
		TextView tv2 = (TextView)findViewById(R.id.textView2);
		TextView tv3 = (TextView)findViewById(R.id.textView3);
		
// 사용자가 설정했던 값들을 보여주기
		SharedPreferences sp = getSharedPreferences("myset.dat", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		
		tv1.setText("체크박스 : "+(sp.getBoolean("cb", false)?"체크됨":"체크안함"));
		tv2.setText("스위치 : "+(sp.getBoolean("sw", false)?"On":"Off"));
		tv3.setText("에디트텍스트 : "+sp.getString("et", ""));
		
		
		
		
	}//end of onCreate
	
	protected void onPause() {
		super.onPause();
	}

}//end of class

