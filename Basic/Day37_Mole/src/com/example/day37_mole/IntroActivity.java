package com.example.day37_mole;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class IntroActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		
		final Button b_start = (Button)findViewById(R.id.button1);		
		final Button b_way = (Button)findViewById(R.id.button3);		
		
		b_start.setVisibility(View.INVISIBLE);
		b_way.setVisibility(View.INVISIBLE);
		
		final LinearLayout ll = (LinearLayout)findViewById(R.id.Layout);
		ll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				b_start.setVisibility(View.VISIBLE);
				b_way.setVisibility(View.VISIBLE);
				ll.setBackground(null);
			}
		});
		
		b_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		b_way.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(0);
			}
		});
		
	}//end of onCreate
	
	@Override
	protected Dialog onCreateDialog(int id) {
		if (id==0) {
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("게임방법 설명");
			dialog.setMessage("1단계는 1마리 두더지,\n2단계는 2마리 두더지,\n3단계는 4마리 두더지가 등장합니다.\n"
					+ "두더지를 처치하여,\n마을의 평화를 되찾아주세요");
			dialog.setPositiveButton("확인", null);
			return dialog.create();
		}
		return super.onCreateDialog(id);
	}
}//end of class
