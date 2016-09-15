package com.example.game;

import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
	TextView tv[] = new TextView[16];
	int now = 1;
	int dap1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 }; // 1에서
																			// 16까지
	int dap2[] = { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32 }; // 17에서
																						// 32까지
	int dap3[] = { 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48 }; // 33에서
																						// 48까지
	int dap4[] = { 49, 50 };// 49~50

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv[0] = (TextView) findViewById(R.id.textView1);
		tv[1] = (TextView) findViewById(R.id.textView2);
		tv[2] = (TextView) findViewById(R.id.textView3);
		tv[3] = (TextView) findViewById(R.id.textView4);
		tv[4] = (TextView) findViewById(R.id.textView5);
		tv[5] = (TextView) findViewById(R.id.textView6);
		tv[6] = (TextView) findViewById(R.id.textView7);
		tv[7] = (TextView) findViewById(R.id.textView8);
		tv[8] = (TextView) findViewById(R.id.textView9);
		tv[9] = (TextView) findViewById(R.id.textView10);
		tv[10] = (TextView) findViewById(R.id.textView11);
		tv[11] = (TextView) findViewById(R.id.textView12);
		tv[12] = (TextView) findViewById(R.id.textView13);
		tv[13] = (TextView) findViewById(R.id.textView14);
		tv[14] = (TextView) findViewById(R.id.textView15);
		tv[15] = (TextView) findViewById(R.id.textView16);

		TextView a = (TextView) findViewById(R.id.textView17);

		// 1에서 16까지의 배열
		Random ran = new Random();
		for (int i = 0; i < num.length * 2; i++) {
			int n1 = ran.nextInt(num.length);
			int n2 = ran.nextInt(num.length);

			int temp = num[n1];
			num[n1] = num[n2];
			num[n2] = temp;

			int temp1 = dap1[n1];
			dap1[n1] = dap1[n2];
			dap1[n2] = temp1;

			int temp2 = dap2[n1];
			dap2[n1] = dap2[n2];
			dap2[n2] = temp2;

			int temp3 = dap3[n1];
			dap3[n1] = dap3[n2];
			dap3[n2] = temp3;
		}
		for (int i = 0; i < num.length; i++) {
			tv[i].setText(num[i] + "");
		}

		// a.append(Arrays.toString(dap1)+"\n");
		// a.append(Arrays.toString(dap2)+"\n");
		// a.append(Arrays.toString(dap3)+"\n");
		// a.append(Arrays.toString(dap4));

		final SoundPool sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
		final int soundID1 = sp.load(this, R.raw.wow, 1);
		final int soundID2 = sp.load(this, R.raw.wrong, 1);
		final int soundID3 = sp.load(this, R.raw.clear, 1);

		class TextEvent implements OnClickListener {
			public void onClick(View v) {
				TextView tv = (TextView) v;

				if (tv.getText().toString().equals("")) {
					return;
				} else if (Integer.valueOf(tv.getText().toString()) == now) {
					if (now <= 16) {
						tv.setText(dap2[now - 1] + "");
					} else if (now > 16 && now <= 32) {
						tv.setText(dap3[now - 17] + "");
					} else if (now >= 33 && now <= 34) {
						tv.setText(dap4[now - 33] + "");
					} else if (now == 50) {
						Toast.makeText(getApplicationContext(), "성공 유휴", 0).show();
						tv.setText("");
						for (int i = 0; i < MainActivity.this.tv.length; i++) {
							MainActivity.this.tv[i].setText("굳");
							tv.setEnabled(false);
						}
						sp.play(soundID2, 1, 1, 0, 0, 1);
					} else {
						tv.setText("");
					}

					now++;

				} else {
					Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
					vib.vibrate(500);
					Toast.makeText(getApplicationContext(), now + " 땡", 0).show();
					sp.play(soundID2, 1, 1, 0, 0, 1);
				}

			}
		}

		TextEvent te = new TextEvent();
		for (int i = 0; i < tv.length; i++) {
			tv[i].setOnClickListener(te);
		}

	}// end of onCreate
}// end of class
