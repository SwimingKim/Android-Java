package com.example.day12_1lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 안드로이드 화면 하나를 그려주기위한 컴포넌트 : Activity Activity 의 라이프 사이클 (생명주기) on****()의 이름이다
 * super.부모의 메서드를 호출하는 실행문이 들어가야 한다. 지우면 에러
 */
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// 화면이 그려질때 가장먼저 호출되는 콜백메서드
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.d("myAndroid", "로그 테스트 d ^^");
		Log.e("myAndroid", "로그 테스트 e ^^");
		Log.i("myAndroid", "로그 테스트 i ^^");
		Log.v("myAndroid", "로그 테스트 v ^^");
		Log.w("myAndroid", "로그 테스트 w ^^");
		// 모바일에서는 콘솔창이 없으므로 디버깅을 위한 클래스 Log 제공됨
		// 메서드가 레벨에 따라 e d i w v a 가 있다
		// 개발할 때 코드의 진행상황을 알기쉽게하기위해 출력할 용도로 사용한다
	} // end of onCreate

	@Override
	protected void onStart() {
		super.onStart();
		Log.d("myAndroid", "onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("myAndroid", "onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("myAndroid", "onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("myAndroid", "onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("myAndroid", "onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("myAndroid", "onDestroy");
	}
} // end of class
