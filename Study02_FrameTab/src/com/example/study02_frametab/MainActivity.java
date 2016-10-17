package com.seoul.culture;

import com.seoul.culture.map.MapActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;

public class IntroActivity  extends FragmentActivity {
	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.intro);
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

		mTabHost.addTab(
				mTabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
				FragmentTab.class, null);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
				FragmentTab.class, null);
		mTabHost.addTab(
				mTabHost.newTabSpec("tab3").setIndicator("Tab 3", null),
				FragmentTab.class, null);
	}

	@Override // 메뉴버튼과 검색버튼 적용
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menubutton, menu);

		return true;
	}

	// 메뉴버튼과 검색버튼 동작하는 구문
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_btn:
//			mSlidingMenu.toggleRightDrawer();
			break;
		case R.id.search_btn:

			Intent intentSearch = new Intent(getApplicationContext(), SearchActivity.class);
			startActivity(intentSearch);

			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
