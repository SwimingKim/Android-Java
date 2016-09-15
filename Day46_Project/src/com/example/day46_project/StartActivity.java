package com.example.day46_project;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class StartActivity extends TabActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		
		TabHost host = getTabHost();
		
		TabSpec tab1 = host.newTabSpec("1");
		tab1.setIndicator("목록보기");
		tab1.setContent(new Intent(getApplicationContext(), MainActivity.class));
		host.addTab(tab1);
		
		TabSpec tab2 = host.newTabSpec("2");
		tab2.setIndicator("환경설정");
		tab2.setContent(new Intent(getApplicationContext(),SettingActivity.class));
		host.addTab(tab2);
		
	}//end of onCreate

}//end of class
