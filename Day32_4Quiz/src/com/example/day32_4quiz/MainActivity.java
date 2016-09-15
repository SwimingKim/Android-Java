package com.example.day32_4quiz;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		TabHost host = getTabHost();
		
		TabSpec tab1 = host.newTabSpec("1");
		tab1.setIndicator("프레임");
		tab1.setContent(new Intent(getApplicationContext(), OneActivity.class));
		host.addTab(tab1);
		
		TabSpec tab2 = host.newTabSpec("2");
		tab2.setIndicator("트윈");
		tab2.setContent(new Intent(getApplicationContext(), TwoActivity.class));
		host.addTab(tab2);
		
		TabSpec tab3 = host.newTabSpec("3");
		tab3.setIndicator("속성");
		tab3.setContent(new Intent(getApplicationContext(), ThreeActivity.class));
		host.addTab(tab3);
	
	
	
	}
	
}
		
		
		
		