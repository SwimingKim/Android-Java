package com.su.map;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost host = getTabHost();
		
		TabSpec tab1 = host.newTabSpec("1");
		tab1.setIndicator("지도 보기");
		tab1.setContent(new Intent(getApplicationContext(), MapActivity.class));
		host.addTab(tab1);
		
		TabSpec tab2 = host.newTabSpec("2");
		tab2.setContent(new Intent(getApplicationContext(), TextActivity.class));
		tab2.setIndicator("목록 보기");
		host.addTab(tab2);
		
		
	}//end of onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}//end of class
