package com.example.day22_4popupmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.textView1);

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 팝업메뉴 띄우기
				// 1. 팝업메뉴 생성 후 show
				// 2. 이벤트 처리

				PopupMenu pm = new PopupMenu(getApplicationContext(), v);
				pm.getMenuInflater().inflate(R.menu.popup, pm.getMenu());
				pm.show();

				pm.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						case R.id.apple:
							tv.setText(item.getTitle().toString());
							return true;
						case R.id.lemon:
							tv.setText(item.getTitle().toString());
							return true;
						case R.id.banana:
							tv.setText(item.getTitle().toString());
							return true;
						default:
							break;
						}

						return false;
					}
				});

			}
		});

	}// end of onCreate

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
}
