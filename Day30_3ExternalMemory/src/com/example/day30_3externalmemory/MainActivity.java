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

		// 외부메모리 사용을 위한 준비단계
		// 1. 사용자 권한을 등록해야 한다 (AndroidManifest.xml -> usePermission)
		// 2. OS에서 메모리 카드를 제대로 인식했는지를 확인하기

		String state =Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			Log.d("file", "외부메모리 읽기/쓰기 가능");
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			Log.d("file", "외부메모리 읽기 전용");
			Toast.makeText(getApplicationContext(), "외부메모리 읽기 전용", 0).show();
			finish();//앱종료
		} else {
			Log.d("file", "외부메모리 사용 불가");
			Toast.makeText(getApplicationContext(), "외부메모리 사용 불가", 0).show();
			finish();//앱종료
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
					Log.d("file", "파일 쓰기 완료");

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
//						if (str==null) break;//파일의 끝을 만나면 반복 탈출
//						result += str +"\n";
						String str = br.readLine();
						if (str==null) break;//파일의 끝을 만나면 반복 탈출						
						if (str.substring(0,3).equals("이름:")) {
//							name = str.substring(3, str.length());
							name = str.substring(3);
						} else if (str.substring(0,3).equals("단계:")) {
//							step = Integer.valueOf(str.substring(3, str.length()));
							step = Integer.valueOf(str.substring(3));
						} else if (str.substring(0,3).equals("점수:")) {
//							point =  Integer.valueOf(str.substring(3, str.length()));
							point =  Integer.valueOf(str.substring(3));
						}
					}
					result = name +"," + step + "," + point;
					tv.setText(result);
					Log.d("file", "파일 읽기 완료");

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});



	}//end of onCreate
}//end of class
