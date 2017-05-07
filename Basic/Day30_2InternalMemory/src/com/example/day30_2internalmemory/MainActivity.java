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

		// internal Memory에 쓰기		
		final EditText et = (EditText)findViewById(R.id.editText1);
		Button bWrite = (Button)findViewById(R.id.button1);
		Button bRead = (Button)findViewById(R.id.button2);
		final TextView tv = (TextView)findViewById(R.id.textView1);

		bWrite.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String str = et.getText().toString();

				try {
					FileOutputStream fos = openFileOutput("myInternel.txt",//저장할 파일명
							Context.MODE_APPEND);
					//MODE_APPEND : 추가. MODE_PRIVATE : 덮여쓰기
					PrintWriter out = new PrintWriter(fos);
					out.println(str);
					out.close();//파일작성 종료
					et.setText("");
					Log.d("file", "내부파일쓰기완료");

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				//저장모드
			}
		});


		bRead.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("myInternel.txt")));
					String result = "";

					while (true) {
						String str = br.readLine();
						if (str==null) break;//파일의 끝이면 반복 탈출
						result += str+"\n";
					}

				tv.setText(result);
				br.close();
				Log.d("file", "내부파일읽기 완료");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	});




}//end of onCreate
}//end of class
