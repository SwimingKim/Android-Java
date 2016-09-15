package com.su.project03;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntroActivity extends Activity{
	
	final int DIALOG_START = 0;
	final int DIALOG_WAY = 1;
	private Intent intent;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		
		Button b = (Button)findViewById(R.id.button1);
		Button b2 = (Button)findViewById(R.id.button2);
		
		intent = new Intent(getApplicationContext(),MainActivity.class);		
		
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_START);
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_WAY);
			}
		});
		
	}//end of onCreate
	
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_START:
			AlertDialog.Builder dialog1 = new Builder(this);
			dialog1.setTitle("게임시작");
			dialog1.setMessage("게임모드를 선택해주세요");
			dialog1.setPositiveButton("센서모드", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					intent.putExtra("모드", "센서");
					startActivity(intent);
					finish();
				}
			});
			dialog1.setNegativeButton("터치모드", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					intent.putExtra("모드", "터치");
					startActivity(intent);
					finish();
				}
			});
			return dialog1.create();
		case DIALOG_WAY:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("게임방법");
			dialog2.setMessage("상어가 자랄 수 있도록\n"
					+ "물고기를 많이 잡아주세요.\n"
					+ "30마리 파란 물고기를 잡으면\n상어가 이기고,\n"
					+ "3마리 빨간 물고기를 잡으면\n상어가 패배합니다.\n"
					+ "상어가 이기게 도와주세요!!");
			dialog2.setPositiveButton("확인", null);
			return dialog2.create();
		default:
			break;
		}
		return super.onCreateDialog(id);
	}

}//end of class
