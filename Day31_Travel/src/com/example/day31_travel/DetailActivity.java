package com.example.day31_travel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends Activity{

	int maneji = 0;
	int num;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		Intent intent = getIntent();
		num = intent.getIntExtra("num", 0);

		final EditText et_date = (EditText)findViewById(R.id.date);
		final EditText et_item = (EditText)findViewById(R.id.item);
		final EditText et_money = (EditText)findViewById(R.id.money);
		Button b = (Button)findViewById(R.id.button1);
		final EditText et_result = (EditText)findViewById(R.id.result);
		final TextView tv = (TextView)findViewById(R.id.extra);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("travel2.txt")));
			String result = "";
			int da = 0;
			String it = "";
			int mo = 0;

			while (true) {
				String str = br.readLine();
				if(str==null) break;
				if (str.substring(0,2).equals("��:")) {
					da = Integer.valueOf(str.substring(2));
				} else if (str.substring(0,2).equals("��:")) {
					it = str.substring(2);
				} else if (str.substring(0,2).equals("��:")) {
					mo =  Integer.valueOf(str.substring(2));
					maneji += mo;
				}
			}

			Log.d("file", result);
			int a = num - maneji;
			tv.setText("��ü ���� ���� "+ num+"�Դϴ�");
			tv.append("\n���� ���� "+ a +"�Դϴ�");
			et_result.setText(result);
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					int date = 	Integer.valueOf(et_date.getText().toString());	
					String item = et_item.getText().toString();	
					int money = Integer.valueOf(et_money.getText().toString());	
					FileOutputStream fos = openFileOutput("travel2.txt", Context.MODE_APPEND);
					PrintWriter out = new PrintWriter(fos);
					out.println("��:"+date);
					out.println("��:"+item);
					out.println("��:"+money);
					out.close();
					et_date.setText("");
					et_item.setText("");
					et_money.setText("");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("travel2.txt")));
					String result = "";
					int da = 0;
					String it = "";
					int mo = 0;

					while (true) {
						String str = br.readLine();
						if(str==null) break;
						if (str.substring(0,2).equals("��:")) {
							da = Integer.valueOf(str.substring(2));
						} else if (str.substring(0,2).equals("��:")) {
							it = str.substring(2);
						} else if (str.substring(0,2).equals("��:")) {
							mo =  Integer.valueOf(str.substring(2));
							maneji += mo;
						}
						result += da +"\t\t/\t\t"+ it +"\t\t/\t\t"+ mo +"\n";
					}

					Log.d("file", result);
					int a = num - maneji;
					tv.setText("��ü ���� ���� "+ num+"�Դϴ�");
					tv.append("\n���� ���� "+ a +"�Դϴ�");
					et_result.setText(result);
					br.close();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});













	}//end of onCreate

}//end of class
