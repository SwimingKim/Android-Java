package com.example.day21_03dialog2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	final int DIALOG_ID_SUBMIT = 1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView tv = (TextView) findViewById(R.id.textView1);
		Button b = (Button) findViewById(R.id.button1);

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_ID_SUBMIT);
			}
		});

	}// end of onCreate

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ID_SUBMIT:
			// this를 생성자에 넣어야 한다.
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("완료된 설문조사를 제출하겠습니까?");
			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setMessage("확인해주십시오");
			dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "제출되었습니다", 0).show();
				}
			});
			dialog.setNegativeButton("아니오", null);
			dialog.setNeutralButton("글쎄요", null);

			return dialog.create();
		default:
			return null;
		}
	}

	protected void onPrepareDialog(int id, Dialog dialog) {
		super.onPrepareDialog(id, dialog);
	}

}// end of class
