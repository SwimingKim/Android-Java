package com.example.secret;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class IntroActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(1);
			}
		});

	}// end of onCreate

	@Override
	protected Dialog onCreateDialog(int id) {
		if (id == 1) {
			LayoutInflater lif = (LayoutInflater) getApplicationContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View mv = lif.inflate(R.layout.bo, null);
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("보안");
			dialog.setMessage("비밀번호를 입력해주세요");
			dialog.setView(mv);

			final EditText et = (EditText) mv.findViewById(R.id.editText1);

			dialog.setPositiveButton("입력완료", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					if (et.getText().toString().equals("882530")) {
						Intent intent = new Intent(getApplicationContext(), MainActivity.class);
						startActivity(intent);
						finish();
					} else {
						et.setText("");
					}

				}
			});
			return dialog.create();

		}

		return super.onCreateDialog(id);
	}

}// end of class
