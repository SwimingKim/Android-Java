package com.example.day22_3contextmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	LinearLayout ll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// ���ؽ�Ʈ �޴� : ����ڰ� ������ �������� ������ �� �߻���Ű�� �޴�
		// ���ؽ�Ʈ �޴��� ����� ������ ��������� �Ѵ�

		Button b = (Button) findViewById(R.id.button1);
		registerForContextMenu(b);

		ll = (LinearLayout) findViewById(R.id.linear);

	}// end of onCreate

	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.contextmenu, menu);// �޴��� xml�� ���
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_red:
			Toast.makeText(getApplicationContext(), "���� ����", 1).show();
			ll.setBackgroundColor(Color.RED);
			break;
		case R.id.menu_yellow:
			Toast.makeText(getApplicationContext(), "��� ����", 1).show();
			ll.setBackgroundColor(Color.YELLOW);
			break;
		case R.id.menu_blue:
			Toast.makeText(getApplicationContext(), "�Ķ� ����", 1).show();
			ll.setBackgroundColor(Color.BLUE);
			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}

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
