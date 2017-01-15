package com.example.day22_2optionmenu;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView tv;
	boolean isLogIn = false;// 처음은 false - 로그아웃 싱태로 시작

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.text);

	}// end of onCreate

	/** 폰에 메뉴키를 눌렀을때 최초로 한번만 실행되는 콜백 메서드 */
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);// 메뉴등록
		return true;
	}

	/** 옵션메뉴를 띄울 때마다 호출되는 콜백 메서드 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		if (isLogIn) {
			menu.getItem(0).setTitle("로그아웃");
		} else if (isLogIn) {
			menu.getItem(0).setTitle("로그인");
		}
		return super.onPrepareOptionsMenu(menu);
	}

	/** 옵션메뉴 항목을 선택했을 때 실행되는 콜백 메서드 */
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {// 로그인/로그아웃
			if (isLogIn) {// 현재 로그인 상태에서 로그아웃 버튼을 누르면
				tv.setText("로그아웃 했습니다");
				isLogIn = false;
			} else {// 현재 로그아웃 상태에서 로그인 버튼을 누르면
				tv.setText("로그인 했습니다");
				isLogIn = true;
			}
			return true;
		} else if (id == R.id.delete) {
			Toast.makeText(getApplicationContext(), "del선택", 1).show();
			return true;
		} else if (id == R.id.end) {
			tv.setText("헬로우월드");
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
