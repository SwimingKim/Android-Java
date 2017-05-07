package com.example.day11_0helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {// 하나의 화면을 구성
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// 부모의 onCreate를 실행
		setContentView(R.layout.activity_main);// 레이아웃과 연결

	}// end of onCreate
}// end of class

// android acitivity 한 화면의 구성방법
// service 백그라운드 서비스
// content provider 응답하는 프로그램
// brodecast 공유
