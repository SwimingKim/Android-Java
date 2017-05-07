package com.su.project01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class IntroActivity extends Activity{

	private SharedPreferences sp;
	private String open;
	int count = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		open = sp.getString("open", "");
	
		ImageView iv = (ImageView)findViewById(R.id.imageView1);
		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showDialog(1);
			}
		});
	
		findViewById(R.id.textView1).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				count++;
				if (count>=10) {
					Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
					startActivity(intent);
				}
			}
		});
	
		Log.d("line", open);
	
	
	
	
	}//end of onCreate
	
	@Override
	protected Dialog onCreateDialog(int id) {
		if (id==1) {
			LayoutInflater lif = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View mv = lif.inflate(R.layout.bo, null);			
			AlertDialog.Builder dialog = new Builder(this);
			dialog.setTitle("보안");
			dialog.setMessage("비밀번호를 입력해주세요");
			dialog.setView(mv);
			
			final EditText et = (EditText)mv.findViewById(R.id.editText1);
			
			dialog.setPositiveButton("입력완료", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					if(open.equals(et.getText().toString())){
						Intent intent = new Intent(getApplicationContext(), MainActivity.class);
						startActivity(intent);
						finish();
					} else{
						et.setText("");
						Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요", 0).show();
					}
					
				}
			});
			return dialog.create();
			
			
			
		}
		
		return super.onCreateDialog(id);
	}
	
	
	
	
}//end of class
