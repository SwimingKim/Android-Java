package com.su.project05_puzzle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class FiveActivity extends Activity{
	private TextView tvMoveCount;
	private Chronometer chro;
	int count = 1;
	TextView tv[] = new TextView[9];

	final int DIALOG_ID_WIN_X = 1;
	final int DIALOG_ID_WIN_O = 2;
	final int DIALOG_ID_GAMEOVER = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five);
		
		tvMoveCount = (TextView)findViewById(R.id.tv);

		Button b1 = (Button)findViewById(R.id.button1);
		Button b2 = (Button)findViewById(R.id.button2);
		Button b3 = (Button)findViewById(R.id.button3);
		chro = (Chronometer)findViewById(R.id.chronometer1);
		chro.setBase(SystemClock.elapsedRealtime()); // �ð��ʱ�ȭ 
		chro.start(); // �ð� ���� 
		
		tv[0] = (TextView) findViewById(R.id.textView1);
		tv[1] = (TextView) findViewById(R.id.textView2);
		tv[2] = (TextView) findViewById(R.id.textView3);
		tv[3] = (TextView) findViewById(R.id.textView4);
		tv[4] = (TextView) findViewById(R.id.textView5);
		tv[5] = (TextView) findViewById(R.id.textView6);
		tv[6] = (TextView) findViewById(R.id.textView7);
		tv[7] = (TextView) findViewById(R.id.textView8);
		tv[8] = (TextView) findViewById(R.id.textView9);
		
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				count = 1; 
				for (int i = 0; i < tv.length; i++) {
					tv[i].setText("");
					tv[i].setBackgroundColor(Color.WHITE);
				}
//				count = 0; 
				tvMoveCount.setText("Ŭ��Ƚ�� : 0");
			}

		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				count++;
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		class MyEvent implements android.view.View.OnClickListener {
			/** ���� �ϼ��Ǿ����� Ȯ�� �� ����� �����ϴ� �޼��� */
			boolean isLine(TextView t1, TextView t2, TextView t3, String ox) {
				String s1 = t1.getText().toString();
				String s2 = t2.getText().toString();
				String s3 = t3.getText().toString();
				if (s1.equals(s2) && s2.equals(s3) && s3.equals(ox)) {
					return true;
				} else {
					return false;
				}
			}

			public void onClick(View v) {
				// ���� Ŭ���� ��ư�� ���� ���� �ִ��� Ȯ��
				TextView tt = (TextView) v;
				
				if (tt.getText().toString().equals("")) {
					// Ȧ¦ �����ؼ� OX ����
					tvMoveCount.setText("Ŭ��Ƚ�� : "+((count/2)+(count%2)));
					tt.setText(count % 2 == 0 ? "X" : "O");
					tt.setBackgroundColor(count % 2 == 0 ? Color.rgb(202,28,41) : Color.rgb(0,113,189));
				} else { // �̹� Ŭ���� ��ư�̶��
					return; // �׳� ���� ������
				}
				count++;

				// �� �� �ϼ��Ǿ����� Ȯ��
				if (isLine(tv[0], tv[1], tv[2], "X") || isLine(tv[3], tv[4], tv[5], "X")
						|| isLine(tv[6], tv[7], tv[8], "X")

						|| isLine(tv[0], tv[3], tv[6], "X") || isLine(tv[1], tv[4], tv[7], "X")
						|| isLine(tv[2], tv[5], tv[8], "X")

						|| isLine(tv[0], tv[4], tv[8], "X") || isLine(tv[2], tv[4], tv[6], "X")) {
					showDialog(DIALOG_ID_WIN_X);
				} else if (isLine(tv[0], tv[1], tv[2], "O") || isLine(tv[3], tv[4], tv[5], "O")
						|| isLine(tv[6], tv[7], tv[8], "O")

						|| isLine(tv[0], tv[3], tv[6], "O") || isLine(tv[1], tv[4], tv[7], "O")
						|| isLine(tv[2], tv[5], tv[8], "O")

						|| isLine(tv[0], tv[4], tv[8], "O") || isLine(tv[2], tv[4], tv[6], "O")) {
					showDialog(DIALOG_ID_WIN_O);
				} else if (count >= 10) {
					// ������ ���̻� ����Ұ�
					showDialog(DIALOG_ID_GAMEOVER);
				}
				

				// ī��Ʈ �÷��ֱ�
				// ī��Ʈ�� 9���� Ȯ��

			}
		}

		MyEvent me = new MyEvent();

		for (int i = 0; i < tv.length; i++) {
			tv[i].setText("");
			tv[i].setOnClickListener(me);
		}

		
	}//end of onCreate
	
	protected Dialog onCreateDialog(int id) {
		final SoundPool sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
//		final int soundID1 = sp.load(this, R.raw.clear, 1);// ����켱����
//		final int soundID2 = sp.load(this, R.raw.wrong, 1);
		switch (id) {
		case DIALOG_ID_WIN_X:
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("�й�");
			dialog.setMessage("���ӿ��� �й��ϼ̽��ϴ�.\n������ �ٽ� �����Ͻðڽ��ϱ�?");

//			sp.play(soundID1, 1, 1, 0, 0, 1);
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
			return dialog.create();
		case DIALOG_ID_WIN_O:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("�¸�");
			dialog2.setMessage("���ӿ��� �¸��ϼ̽��ϴ�.\n������ �ٽ� �����Ͻðڽ��ϱ�?");
//			sp.play(soundID1, 1, 1, 0, 0, 1);
			dialog2.setPositiveButton("��", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
					finish();					
				}
			});
			dialog2.setNegativeButton("�ƴϿ�", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			return dialog2.create();
		case DIALOG_ID_GAMEOVER:
			AlertDialog.Builder dialog3 = new Builder(this);
			dialog3.setTitle("����!");
			dialog3.setMessage("Ƚ���� �ʰ��Ͽ����ϴ�.\n������ �ٽ� �����Ͻðڽ��ϱ�?");
//			sp.play(soundID2, 1, 1, 0, 0, 1);
			dialog3.setPositiveButton("��", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
					finish();					
				}
			});
			dialog3.setNegativeButton("�ƴϿ�", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			return dialog3.create();
		default:
			return null;
		}

	}

}//end of class