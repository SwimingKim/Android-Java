package com.example.day11_0helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {// �ϳ��� ȭ���� ����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);// �θ��� onCreate�� ����
		setContentView(R.layout.activity_main);// ���̾ƿ��� ����

	}// end of onCreate
}// end of class

// android acitivity �� ȭ���� �������
// service ��׶��� ����
// content provider �����ϴ� ���α׷�
// brodecast ����
