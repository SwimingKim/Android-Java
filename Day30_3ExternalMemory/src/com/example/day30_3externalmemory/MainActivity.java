package com.example.day30_3externalmemory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �ܺθ޸� ����� ���� �غ�ܰ�
		// 1. ����� ������ ����ؾ� �Ѵ� (AndroidManifest.xml -> usePermission)
		// 2. OS���� �޸� ī�带 ����� �ν��ߴ����� Ȯ���ϱ�

		String state =Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			Log.d("file", "�ܺθ޸� �б�/���� ����");
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			Log.d("file", "�ܺθ޸� �б� ����");
			Toast.makeText(getApplicationContext(), "�ܺθ޸� �б� ����", 0).show();
			finish();//������
		} else {
			Log.d("file", "�ܺθ޸� ��� �Ұ�");
			Toast.makeText(getApplicationContext(), "�ܺθ޸� ��� �Ұ�", 0).show();
			finish();//������
		}


		final EditText et = (EditText)findViewById(R.id.editText1);
		Button bWrite = (Button)findViewById(R.id.button1);
		Button bRead = (Button)findViewById(R.id.button2);
		final TextView tv = (TextView)findViewById(R.id.textView1);

		bWrite.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String str = et.getText().toString();
				try {
					File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
							"external3.txt");
					PrintWriter out = new PrintWriter(new FileWriter(file, true));
					out.println(str);
					out.close();
					Log.d("file", "���� ���� �Ϸ�");

				} catch (IOException e) {
					e.printStackTrace();
				}



			}
		});


		bRead.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				try {
					File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
							"external3.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					String result = "";
					
					String name = "";
					int step = 0;
					int point = 0;
					while (true) {
//						String str = br.readLine();
//						if (str==null) break;//������ ���� ������ �ݺ� Ż��
//						result += str +"\n";
						String str = br.readLine();
						if (str==null) break;//������ ���� ������ �ݺ� Ż��						
						if (str.substring(0,3).equals("�̸�:")) {
//							name = str.substring(3, str.length());
							name = str.substring(3);
						} else if (str.substring(0,3).equals("�ܰ�:")) {
//							step = Integer.valueOf(str.substring(3, str.length()));
							step = Integer.valueOf(str.substring(3));
						} else if (str.substring(0,3).equals("����:")) {
//							point =  Integer.valueOf(str.substring(3, str.length()));
							point =  Integer.valueOf(str.substring(3));
						}
					}
					result = name +"," + step + "," + point;
					tv.setText(result);
					Log.d("file", "���� �б� �Ϸ�");

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});



	}//end of onCreate
}//end of class
