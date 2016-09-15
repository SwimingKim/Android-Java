package com.example.day21_04dialog3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final int DIALOG_ID_LIST = 1;
	final int DIALOG_ID_RADIO = 2;
	final int DIALOG_ID_CHECKBOX = 3;
	final int DIALOG_ID_CUSTOM = 4;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView tv = (TextView) findViewById(R.id.textView1);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);

		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_ID_LIST);
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_ID_RADIO);
			}
		});
		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_ID_CHECKBOX);
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(DIALOG_ID_CUSTOM);
			}
		});

	}// end of onCreate

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ID_LIST:
			AlertDialog.Builder dialog = new Builder(this);
			final String str1[] = { "���", "������", "�ڵ�", "�ٳ���", "���ξ���", "����" };
			dialog.setTitle("�̰��� ����Ʈ ���̾�α� ��?");
			// �޼��� �ڸ��� ����Ʈ�� ���δ�
			// dialog.setMessage("������ �����Ͻðڽ��ϱ�?");
			dialog.setItems(str1, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), str1[which] + "", 1).show();
				}
			});
			return dialog.create();
		case DIALOG_ID_RADIO:
			AlertDialog.Builder dialog2 = new Builder(this);
			final String str2[] = { "���", "������", "�ڵ�", "�ٳ���", "���ξ���", "����" };
			dialog2.setTitle("�̰��� ���� ���̾�α� ��?");
			// dialog2.setMessage("������ �����Ͻðڽ��ϱ�?");
			dialog2.setSingleChoiceItems(str2, 0, // ���� �����׸�
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getApplicationContext(), str2[which] + "", 0).show();
							dialog.dismiss();
						}
					});
			return dialog2.create();
		case DIALOG_ID_CHECKBOX:
			AlertDialog.Builder dialog3 = new Builder(this);
			final String str3[] = { "���", "������", "�ڵ�", "�ٳ���", "���ξ���", "����" };
			final boolean isCheck[] = { true, false, true, false, false, false };
			dialog3.setTitle("�̰��� üũ�ڽ��Դϴ�");
			dialog3.setMultiChoiceItems(str3, // �迭
					isCheck, // �ʱ�üũ����
					new DialogInterface.OnMultiChoiceClickListener() {// �̺�Ʈ
						public void onClick(DialogInterface dialog, int which, boolean isChecked) {
							Toast.makeText(getApplicationContext(), str3[which] + "", 0).show();
						}
					});
			dialog3.setPositiveButton("���ÿϷ�", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					String result = "";
					for (int i = 0; i < isCheck.length; i++) {
						if (isCheck[i]) {
							result += str3[i] + ", ";
						}
					}
					Toast.makeText(getApplicationContext(), result + " ����", 1).show();
				}
			});
			dialog3.setNegativeButton("���", null);
			return dialog3.create();
		case DIALOG_ID_CUSTOM:
			// Ŀ���� ���̾�α�
			// ȭ�鿡 ����� ������ �������Ѵ�. (xml)
			final String str4[] = { "���", "������", "�ڵ�", "�ٳ���", "���ξ���", "����" };
			LayoutInflater lif = (LayoutInflater) getApplicationContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View myView = lif.inflate(R.layout.custom_design, null);
			AlertDialog.Builder dialog4 = new Builder(this);
			dialog4.setTitle("�̰��� Ŀ�����Դϴ�");
			dialog4.setView(myView);
			dialog4.setPositiveButton("��", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getApplicationContext(), "��뼺��", 1).show();
				}
			});
			dialog4.setNegativeButton("�ƴϿ�", null);

			return dialog4.create();

		default:
			return null;
		}

	}

}// end of class
