package com.example.day20_1to50;

import java.util.Arrays;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	int allNum[] = new int[64];// 1~50
	int num[] = new int[16];
	TextView arrTv[] = new TextView[16];
	int count = 1; // 현재 눌러야할 숫자

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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
		Random ran = new Random();
		for (int j = 0; j < allNum.length; j += 16) {// 구간별로 섞기 위해
			for (int i = 0; i < 16 * 2; i++) {// 0~15
				int n1 = ran.nextInt(16) + j;
				int n2 = ran.nextInt(16) + j;

				int temp = allNum[n1];
				allNum[n1] = allNum[n2];
				allNum[n2] = temp;

			}
		}
		Log.d("1to50", Arrays.toString(allNum));

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
					if (userNum + 15 <= allNum.length && allNum[userNum + 15] <= 50) {
						// 같으면 다음 숫자를 보여준다,
						tv.setText(allNum[userNum + 15] + "");
					} else {// 50보다 큰 숫자는 보여주지 않고, 클릭을 막기
						tv.setText("");
						tv.setEnabled(false);
					}
					count++;

					if (count > 50) {// 50을 누르면 게임종료
						Toast.makeText(getApplicationContext(), "게임성공", 0).show();
					}

				} else {// 다르면 그냥 빠져나감
					Toast.makeText(getApplicationContext(), "땡!! " + count + "를 누르세요", 0).show();
					return;
				}

			}
		}
		MyClickListener mcl = new MyClickListener();

		// 답중에 16개만 TextView에 보여주기
		for (int i = 0; i < arrTv.length; i++) {
			arrTv[i].setText(allNum[i] + "");
			// 이벤트 처리 - 순서에 맞는 숫자를 눌렀을 때만 진행하기
			arrTv[i].setOnClickListener(mcl);
		}

	}// end of onCreate
}// end of class
