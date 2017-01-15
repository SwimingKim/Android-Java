package com.example.day32_3tab;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

// TabHost: 탭의 전체 구조
// TabWedget : 탭의 끄트머리
// FrameLayout : 각 탭을 선택핼을 때 보여줄 뷰
		
		TabHost host = getTabHost();
		
		TabSpec tab1 = host.newTabSpec("1");
		tab1.setIndicator("ONE");
		tab1.setContent(new Intent(getApplicationContext(),OneActivity.class));// 탭 끄트머리 선택시 보여줄 화면 등록
		host.addTab(tab1);//탭을 탭호스트에 등록
		
		TabSpec tab2 = host.newTabSpec("2");
		tab2.setIndicator("TWO");
		tab2.setContent(new Intent(getApplicationContext(),TwoActivity.class));
		host.addTab(tab2);
		
		TabSpec tab3 = host.newTabSpec("3");
		tab3.setIndicator("THREE");
		tab3.setContent(new Intent(getApplicationContext(),ThreeActivity.class));
		host.addTab(tab3);
		
		
		
	}//end of onCreate
}//end of class
