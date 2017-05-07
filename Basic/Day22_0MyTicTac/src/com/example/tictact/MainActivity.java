package com.example.tictact;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView arrTv[] = new TextView[9];
	int count = 1;
	int dap[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
			{ 2, 4, 6 }, };

	final int DIALOG_O = 1;
	final int DIALOG_X = 2;
	final int DIALOG_END = 3;

	@Override
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

		class MyClickListener implements android.view.View.OnClickListener {
			public void onClick(View v) {
				TextView tv = (TextView) v;
				if (tv.getText().toString().equals("")) {
					if (count == 9) {
						showDialog(DIALOG_END);
					}
					if (count % 2 == 0) {
						tv.setText("O");
						count++;
					} else if (count % 2 != 0) {
						tv.setText("X");
						count++;
					}
				}

				for (int i = 0; i < dap.length; i++) {
					if (arrTv[dap[i][0]].getText().equals("O") && arrTv[dap[i][1]].getText().equals("O")
							&& arrTv[dap[i][2]].getText().equals("O")) {
						showDialog(DIALOG_O);
						for (int j = 0; j < arrTv.length; j++) {
							arrTv[j].setText("O");
						}
					} else if (arrTv[dap[i][0]].getText().equals("X") && arrTv[dap[i][1]].getText().equals("X")
							&& arrTv[dap[i][2]].getText().equals("X")) {
						showDialog(DIALOG_X);
						for (int j = 0; j < arrTv.length; j++) {
							arrTv[j].setText("X");
						}
					}
				}

			}
		}

		MyClickListener mcl = new MyClickListener();

		for (int i = 0; i < arrTv.length; i++) {
			arrTv[i].setOnClickListener(mcl);
		}

	}// end of onCreate

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_O:
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("종료");
			dialog.setMessage("O가 승리했습니다.");
			return dialog.create();
		case DIALOG_X:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("종료");
			dialog2.setMessage("X가 승리했습니다.");
			return dialog2.create();
		case DIALOG_END:
			AlertDialog.Builder dialog3 = new Builder(this);
			dialog3.setTitle("종료");
			dialog3.setMessage("횟수를 초과했습니다.");
			return dialog3.create();

		default:
			return null;
		}

	}

}// end of class
