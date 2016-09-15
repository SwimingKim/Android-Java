package com.su.project05_puzzle;

import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class OneActivity extends Activity{
	int allNum[] = new int[64];// 1~50
	int num[] = new int[16];
	TextView arrTv[] = new TextView[16];
	int count = 1; // ���� �������� ����
	private Chronometer chro;
	private TextView tvMoveCount;
	private Vibrator vib;
	private Random ran;
	private MyClickListener mcl;
	private int moveCount;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);

		tvMoveCount = (TextView)findViewById(R.id.tv);
		chro = (Chronometer)findViewById(R.id.chronometer1);
		chro.setBase(SystemClock.elapsedRealtime()); // �ð��ʱ�ȭ 
		chro.start();

		vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

		arrTv[0] = (TextView) findViewById(R.id.textView1);
		arrTv[1] = (TextView) findViewById(R.id.textView2);
		arrTv[2] = (TextView) findViewById(R.id.textView3);
		arrTv[3] = (TextView) findViewById(R.id.textView4);
		arrTv[4] = (TextView) findViewById(R.id.textView5);
		arrTv[5] = (TextView) findViewById(R.id.textView6);
		arrTv[6] = (TextView) findViewById(R.id.textView7);
		arrTv[7] = (TextView) findViewById(R.id.textView8);
		arrTv[8] = (TextView) findViewById(R.id.textView9);
		arrTv[9] = (TextView) findViewById(R.id.textView10);
		arrTv[10] = (TextView) findViewById(R.id.textView11);
		arrTv[11] = (TextView) findViewById(R.id.textView12);
		arrTv[12] = (TextView) findViewById(R.id.textView13);
		arrTv[13] = (TextView) findViewById(R.id.textView14);
		arrTv[14] = (TextView) findViewById(R.id.textView15);
		arrTv[15] = (TextView) findViewById(R.id.textView16);

		for (int i = 0; i < allNum.length; i++) {
			allNum[i] = i + 1;
		}
		// ���� ����(Shuffle)
		ran = new Random();
		for (int j = 0; j < allNum.length; j += 16) {// �������� ���� ����
			for (int i = 0; i < 16 * 2; i++) {// 0~15
				int n1 = ran.nextInt(16) + j;
				int n2 = ran.nextInt(16) + j;

				int temp = allNum[n1];
				allNum[n1] = allNum[n2];
				allNum[n2] = temp;

			}
		}


		mcl = new MyClickListener();

		// ���߿� 16���� TextView�� �����ֱ�
		for (int i = 0; i < arrTv.length; i++) {
			arrTv[i].setText(allNum[i] + "");
			// �̺�Ʈ ó�� - ������ �´� ���ڸ� ������ ���� �����ϱ�
			arrTv[i].setOnClickListener(mcl);
		}
		
		
		final Button b_all = (Button)findViewById(R.id.button1);
		final Button b_colum = (Button)findViewById(R.id.button2);
		final Button b_row = (Button)findViewById(R.id.button3);



		Log.d("1to50", Arrays.toString(allNum));
		b_all.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				for (int i = 0; i < allNum.length; i++) {
					allNum[i] = i + 1;
				}
				
				for (int j = 0; j < allNum.length; j += 16) {// �������� ���� ����
					for (int i = 0; i < 16 * 2; i++) {// 0~15
						int n1 = ran.nextInt(16) + j;
						int n2 = ran.nextInt(16) + j;

						int temp = allNum[n1];
						allNum[n1] = allNum[n2];
						allNum[n2] = temp;

					}
				}
				for (int i = 0; i < arrTv.length; i++) {
					arrTv[i].setText(allNum[i] + "");
					// �̺�Ʈ ó�� - ������ �´� ���ڸ� ������ ���� �����ϱ�
					arrTv[i].setOnClickListener(mcl);
				}
				count=1; moveCount=0;
				tvMoveCount.setText("Ŭ��Ƚ�� : "+moveCount);
			}

		});
		b_colum.setOnTouchListener(new OnTouchListener() {
			int temp[] = new int[16];
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {// ��ư�� ������ �� 
					for (int i = 0; i < arrTv.length; i++) {
						if (arrTv[i].getText().toString().equals(count+"")) {
							arrTv[i].setBackgroundColor(Color.WHITE);
						}
					}
//					gv.setAdapter(mg);

				} else if (MotionEvent.ACTION_UP == event.getAction()) { // ��ư�� ��������
//					for (int i = 0; i < index.length; i++) {
//						index[i] = temp[i];
//					}
//					gv.setAdapter(mg);// �ٽ� ����ȭ������ ���ư��� 
					for (int i = 0; i < arrTv.length; i++) {
						if (arrTv[i].getText().toString().equals(count+"")) {
							arrTv[i].setBackgroundColor(Color.rgb(188, 86, 81));
						}
					}
				}
				return true;
			}
		});
		b_row.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();
			}
		});




	}// end of onCreate
	
	class MyClickListener implements OnClickListener {
		

		public void onClick(View v) {
			TextView tv = (TextView) v;
			int userNum = 0;
			try {
				userNum = Integer.valueOf(tv.getText().toString());
			} catch (Exception e) {
				return;// 50 �Ѵ�(���ڰ� �������� ����)��ư�� ���� ���
			}
			// ���� TextView ���� count(�̹��� ������ �� ����) ������ üũ
			if (userNum == count) {
				moveCount++;
				if (userNum>=49) {
					tv.setText("");
					tv.setEnabled(false);
				} else if (userNum + 15 <= allNum.length && allNum[userNum + 15] <= 50) {
					// ������ ���� ���ڸ� �����ش�,
					tv.setText(allNum[userNum + 15] + "");
				} else {// 50���� ū ���ڴ� �������� �ʰ�, Ŭ���� ����
					tv.setText("");
					tv.setEnabled(false);
				}
				count++;

				if (count > 50) {// 50�� ������ ��������
					chro.stop();
					showDialog(0);
				}

			} else {// �ٸ��� �׳� ��������
				Toast.makeText(getApplicationContext(), "��!! " + count + "�� ��������", 0).show();
				moveCount++;
				tvMoveCount.setText("Ŭ��Ƚ�� : "+moveCount);
				vib.vibrate(300);
				return;
			}
			tvMoveCount.setText("Ŭ��Ƚ�� : "+moveCount);
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id==0) {
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("����");
			dialog.setMessage("������ �ٽ� �����ϰڽ��ϱ�?");
			dialog.setPositiveButton("��", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
					finish();					
				}
			});
			dialog.setNegativeButton("�ƴϿ�", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			dialog.setCancelable(false);
			return dialog.create();
		}
		return super.onCreateDialog(id);
	}
}// end of class
