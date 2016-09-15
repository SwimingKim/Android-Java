package com.example.day30_2internalmemory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// internal Memory�� ����		
		final EditText et = (EditText)findViewById(R.id.editText1);
		Button bWrite = (Button)findViewById(R.id.button1);
		Button bRead = (Button)findViewById(R.id.button2);
		final TextView tv = (TextView)findViewById(R.id.textView1);

		bWrite.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String str = et.getText().toString();

				try {
					FileOutputStream fos = openFileOutput("myInternel.txt",//������ ���ϸ�
							Context.MODE_APPEND);
					//MODE_APPEND : �߰�. MODE_PRIVATE : ��������
					PrintWriter out = new PrintWriter(fos);
					out.println(str);
					out.close();//�����ۼ� ����
					et.setText("");
					Log.d("file", "�������Ͼ���Ϸ�");

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				//������
			}
		});


		bRead.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("myInternel.txt")));
					String result = "";

					while (true) {
						String str = br.readLine();
						if (str==null) break;//������ ���̸� �ݺ� Ż��
						result += str+"\n";
					}

				tv.setText(result);
				br.close();
				Log.d("file", "���������б� �Ϸ�");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	});




}//end of onCreate
}//end of class
