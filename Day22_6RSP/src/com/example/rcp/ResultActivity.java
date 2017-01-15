package com.example.rcp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		final EditText et = (EditText)findViewById(R.id.editText1);
		Button b_game = (Button)findViewById(R.id.button1);
		Button b_finish = (Button)findViewById(R.id.button2);
		Button b_reset = (Button)findViewById(R.id.button3);
		

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("game.txt")));
			String result = "";
			String na = "";
			int wi = 0;
			int lo = 0;

			int i = 0;
			while (true) {
				String str = br.readLine();
				Log.e("xxx", "한줄"+i+":"+str);
				i++;
				if (str==null) break;
				if (str.substring(0, 2).equals("계:")) {
					na = str.substring(2);
				} 
				str = br.readLine();
				if (str.substring(0, 2).equals("승:")) {
					wi = Integer.valueOf(str.substring(2));
				} 
				str = br.readLine();
				if (str.substring(0, 2).equals("패:")) {
					lo = Integer.valueOf(str.substring(2));
				}
				result += "계정:"+na+"\t\t\t\t승리:"+wi+"\t\t\t\t패배:"+lo+"\n";
			}
			et.setText(result);
			br.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}







		b_game.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		b_finish.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				finish();
			}
		});
		b_reset.setOnClickListener(new OnClickListener() {			
			public void onClick(View arg0) {
				deleteFile("game.txt");
				et.setText("");
			}
		});



	}//end of onCreate

	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	

}//end of class
