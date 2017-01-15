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
	int count = 1; // 현재 눌러야할 숫자
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
		chro.setBase(SystemClock.elapsedRealtime()); // 시간초기화 
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
		// 답을 섞기(Shuffle)
		ran = new Random();
		for (int j = 0; j < allNum.length; j += 16) {// 구간별로 섞기 위해
			for (int i = 0; i < 16 * 2; i++) {// 0~15
				int n1 = ran.nextInt(16) + j;
				int n2 = ran.nextInt(16) + j;

				int temp = allNum[n1];
				allNum[n1] = allNum[n2];
				allNum[n2] = temp;

			}
		}


		mcl = new MyClickListener();

		// 답중에 16개만 TextView에 보여주기
		for (int i = 0; i < arrTv.length; i++) {
			arrTv[i].setText(allNum[i] + "");
			// 이벤트 처리 - 순서에 맞는 숫자를 눌렀을 때만 진행하기
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
				
				for (int j = 0; j < allNum.length; j += 16) {// 구간별로 섞기 위해
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
					// 이벤트 처리 - 순서에 맞는 숫자를 눌렀을 때만 진행하기
					arrTv[i].setOnClickListener(mcl);
				}
				count=1; moveCount=0;
				tvMoveCount.setText("클릭횟수 : "+moveCount);
			}

		});
		b_colum.setOnTouchListener(new OnTouchListener() {
			int temp[] = new int[16];
			public boolean onTouch(View v, MotionEvent event) {
				if (MotionEvent.ACTION_DOWN == event.getAction()) {// 버튼을 눌렀을 때 
					for (int i = 0; i < arrTv.length; i++) {
						if (arrTv[i].getText().toString().equals(count+"")) {
							arrTv[i].setBackgroundColor(Color.WHITE);
						}
					}
//					gv.setAdapter(mg);

				} else if (MotionEvent.ACTION_UP == event.getAction()) { // 버튼을 떼었을때
//					for (int i = 0; i < index.length; i++) {
//						index[i] = temp[i];
//					}
//					gv.setAdapter(mg);// 다시 게임화면으로 돌아가기 
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
				return;// 50 넘는(숫자가 쓰여있지 않은)버튼을 누를 경우
			}
			// 누른 TextView 값과 count(이번에 눌러야 될 숫자) 같은지 체크
			if (userNum == count) {
				moveCount++;
				if (userNum>=49) {
					tv.setText("");
					tv.setEnabled(false);
				} else if (userNum + 15 <= allNum.length && allNum[userNum + 15] <= 50) {
					// 같으면 다음 숫자를 보여준다,
					tv.setText(allNum[userNum + 15] + "");
				} else {// 50보다 큰 숫자는 보여주지 않고, 클릭을 막기
					tv.setText("");
					tv.setEnabled(false);
				}
				count++;

				if (count > 50) {// 50을 누르면 게임종료
					chro.stop();
					showDialog(0);
				}

			} else {// 다르면 그냥 빠져나감
				Toast.makeText(getApplicationContext(), "땡!! " + count + "를 누르세요", 0).show();
				moveCount++;
				tvMoveCount.setText("클릭횟수 : "+moveCount);
				vib.vibrate(300);
				return;
			}
			tvMoveCount.setText("클릭횟수 : "+moveCount);
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id==0) {
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("성공");
			dialog.setMessage("게임을 다시 시작하겠습니까?");
			dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent(getApplicationContext(),MainActivity.class);
					startActivity(intent);
					finish();					
				}
			});
			dialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
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
