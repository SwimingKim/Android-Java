package com.example.day38_game;

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
			dialog1.setTitle("���ӽ���");
			dialog1.setMessage("���Ӹ�带 �������ּ���");
			dialog1.setPositiveButton("�������", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					intent.putExtra("���", "����");
					startActivity(intent);
					finish();
				}
			});
			dialog1.setNegativeButton("��ġ���", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					intent.putExtra("���", "��ġ");
					startActivity(intent);
					finish();
				}
			});
			return dialog1.create();
		case DIALOG_WAY:
			AlertDialog.Builder dialog2 = new Builder(this);
			dialog2.setTitle("���ӹ��");
			dialog2.setMessage("���� VS īī����\nīī���� VS ����\n"
					+ "������ ��� ���� �¸��� ���ΰ�?\n"
					+ "30���� ������� ������ ������,\n"
					+ "3���� �ΰ� ������ īī������\n"
					+ "�¸��ϰ� �˴ϴ�!!");
			dialog2.setPositiveButton("Ȯ��", null);
			return dialog2.create();
		default:
			break;
		}
		return super.onCreateDialog(id);
	}

}//end of class
