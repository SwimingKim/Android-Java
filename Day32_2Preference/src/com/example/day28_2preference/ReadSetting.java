package com.example.day28_2preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class ReadSetting extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readset);
		
		TextView tv1 = (TextView)findViewById(R.id.textView1);
		TextView tv2 = (TextView)findViewById(R.id.textView2);
		TextView tv3 = (TextView)findViewById(R.id.textView3);
		TextView tv4 = (TextView)findViewById(R.id.textView4);
	
// ������ Preferece�� ���Ͽ��� ���� �о����
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		tv1.setText(sp.getString("ip", ""));
		tv2.setText(sp.getBoolean("sound", false)?"����":"����");
		tv3.setText(sp.getString("time", ""));
		tv4.setText(sp.getBoolean("screen", false)?"����":"����");
		
		
		
		
	}//end of onCreate
}//end of class
