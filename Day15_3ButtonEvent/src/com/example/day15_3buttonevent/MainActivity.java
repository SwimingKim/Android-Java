package com.example.day15_3buttonevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		final TextView tv = (TextView) findViewById(R.id.textView1);

		b1.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				// event.getAction();
				tv.setText("��ġ�̺�Ʈ : ");
				Log.d("event", "��ġ �̺�Ʈ : ");
				return false;
			}
		});

		b2.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				tv.setText("��Ŭ�� �̺�Ʈ : ");
				Log.d("event", "��Ŭ�� �̺�Ʈ : ");
				return false;
			}
		});

		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tv.setText("Ŭ�� �̺�Ʈ : ");
				Log.d("event", "Ŭ�� �̺�Ʈ : ");
			}
		});
		//////////////////////////////
		b4.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {
					tv.setText("��ġ�̺�Ʈ : �ٿ�");
					Log.d("�̺�Ʈ", "��ġ�̺�Ʈ : �ٿ�");
				} else if (MotionEvent.ACTION_UP == event.getAction()) {
					tv.setText("��ġ�̺�Ʈ : ��");
					Log.d("�̺�Ʈ", "��ġ�̺�Ʈ : ��");
				} else if (MotionEvent.ACTION_MOVE == event.getAction()) {
					tv.setText("��ġ�̺�Ʈ : ����");
					Log.d("�̺�Ʈ", "��ġ�̺�Ʈ : ����");
				}
				return false;// ���ϰ��� �ǹ�
				// true : �߻��� �̺�Ʈ�� �ٸ� �����ʿ� �������� ����
			}
		});
		b4.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View v) {
				tv.setText("��Ŭ���̺�Ʈ");
				Log.d("event", "��Ŭ���̺�Ʈ");
				return false;
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tv.setText("Ŭ���̺�Ʈ");
				Log.d("event", "Ŭ���̺�Ʈ");
				// ������ �̺�Ʈ�̹Ƿ� ���޹��� �̺�Ʈ�� ��� ��ȯ���� ����
			}
		});

	}// end of onCreate
}// end of class
