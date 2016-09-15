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
	boolean isLogIn = false;// ó���� false - �α׾ƿ� ���·� ����

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.text);

	}// end of onCreate

	/** ���� �޴�Ű�� �������� ���ʷ� �ѹ��� ����Ǵ� �ݹ� �޼��� */
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);// �޴����
		return true;
	}

	/** �ɼǸ޴��� ��� ������ ȣ��Ǵ� �ݹ� �޼��� */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		if (isLogIn) {
			menu.getItem(0).setTitle("�α׾ƿ�");
		} else if (isLogIn) {
			menu.getItem(0).setTitle("�α���");
		}
		return super.onPrepareOptionsMenu(menu);
	}

	/** �ɼǸ޴� �׸��� �������� �� ����Ǵ� �ݹ� �޼��� */
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {// �α���/�α׾ƿ�
			if (isLogIn) {// ���� �α��� ���¿��� �α׾ƿ� ��ư�� ������
				tv.setText("�α׾ƿ� �߽��ϴ�");
				isLogIn = false;
			} else {// ���� �α׾ƿ� ���¿��� �α��� ��ư�� ������
				tv.setText("�α��� �߽��ϴ�");
				isLogIn = true;
			}
			return true;
		} else if (id == R.id.delete) {
			Toast.makeText(getApplicationContext(), "del����", 1).show();
			return true;
		} else if (id == R.id.end) {
			tv.setText("��ο����");
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
