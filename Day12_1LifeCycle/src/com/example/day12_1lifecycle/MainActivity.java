package com.example.day12_1lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * �ȵ���̵� ȭ�� �ϳ��� �׷��ֱ����� ������Ʈ : Activity Activity �� ������ ����Ŭ (�����ֱ�) on****()�� �̸��̴�
 * super.�θ��� �޼��带 ȣ���ϴ� ���๮�� ���� �Ѵ�. ����� ����
 */
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// ȭ���� �׷����� ������� ȣ��Ǵ� �ݹ�޼���
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.d("myAndroid", "�α� �׽�Ʈ d ^^");
		Log.e("myAndroid", "�α� �׽�Ʈ e ^^");
		Log.i("myAndroid", "�α� �׽�Ʈ i ^^");
		Log.v("myAndroid", "�α� �׽�Ʈ v ^^");
		Log.w("myAndroid", "�α� �׽�Ʈ w ^^");
		// ����Ͽ����� �ܼ�â�� �����Ƿ� ������� ���� Ŭ���� Log ������
		// �޼��尡 ������ ���� e d i w v a �� �ִ�
		// ������ �� �ڵ��� �����Ȳ�� �˱⽱���ϱ����� ����� �뵵�� ����Ѵ�
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
