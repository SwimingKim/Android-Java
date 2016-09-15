package com.example.day31_travel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText et = (EditText)findViewById(R.id.et);
		Button b = (Button)findViewById(R.id.button1);
		
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				if (et.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(), "금액을 입력해주세요", 0).show();
				} else {
					int num = Integer.valueOf(et.getText().toString());
					Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
					intent.putExtra("num", num);					
					startActivity(intent);
					finish();	
					
				}
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
	}//end of onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}//end of class
