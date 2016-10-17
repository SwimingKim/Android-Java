package com.seoul.culture;

import com.navdrawer.SimpleSideDrawer;
import com.seoul.culture.map.MapActivity;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class IntroActivity extends TabActivity {

	private SimpleSideDrawer mSlidingMenu;
	private SharedPreferences sp;
	private TextView tvOne;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Menu
		mSlidingMenu = new SimpleSideDrawer(this);
		mSlidingMenu.setRightBehindContentView(R.layout.left_menu);
		tvOne = (TextView) findViewById(R.id.txtOne);

		// 액션바 색, 아이콘 안보이게
		ActionBar ab = getActionBar();
		ab.setBackgroundDrawable(new ColorDrawable(Color.rgb(32, 111, 185)));
		ab.setDisplayShowHomeEnabled(false);
		setContentView(R.layout.intro);

		TabHost host = getTabHost();
		TabSpec tab1 = host.newTabSpec("1");
		tab1.setIndicator("CATEGORY");
		Intent intent1 = new Intent(getApplicationContext(), com.seoul.culture.CategoryActivity.class);
		tab1.setContent(intent1);
		host.addTab(tab1);
		TabSpec tab2 = host.newTabSpec("2");
		tab2.setIndicator("MAP");
		Intent intent2 = new Intent(getApplicationContext(), MapActivity.class);
		tab2.setContent(intent2);
		host.addTab(tab2);

		TextView Bookmark = (TextView) findViewById(R.id.textView1);
		Bookmark.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), BookmarkActivity.class);
				startActivity(intent);
			}
		});

		TextView appinfo = (TextView) findViewById(R.id.textView6);
		appinfo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentAppInfo = new Intent(getApplicationContext(), AppInfo.class);
				startActivity(intentAppInfo);
			}
		});

	}// end of onCreate
}
