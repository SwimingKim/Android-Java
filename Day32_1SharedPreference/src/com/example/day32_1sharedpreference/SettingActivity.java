package com.example.day32_1sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

public class SettingActivity extends Activity{
	CheckBox cb;
	Switch sw;
	EditText et;
	SharedPreferences sp;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.set);
		
		cb = (CheckBox)findViewById(R.id.checkBox1);
		sw = (Switch)findViewById(R.id.switch1);
		et = (EditText)findViewById(R.id.editText1);
		
		//myset.dat파일에 저장
		sp = getSharedPreferences("myset.dat",Context.MODE_PRIVATE);
////읽기
//		sp.getBoolean("cb", true);
////쓰기		
//		Editor editor = sp.edit();// SharedPreference에서 Editor객체 얻음
//		editor.putBoolean("cd", false);// 키, 값
//		
//		editor.commit();
		
		
		
		
		
		
		
	}//end of onCreate
	
	protected void onPause() {
		// 우리 앱이 다른 팝업에 의해 화면의 일부가 가려졌을 떄 호출되는 콜백 메서드
		super.onPause();
// 사용자가 변경한 작업을 파일에 저장하기
//		SharedPreferences sp = getSharedPreferences("myset.dat", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean("cb", cb.isChecked());//체크박스값저장
		editor.putBoolean("sw", sw.isChecked());//스위치값저장
		editor.putString("et", et.getText().toString());//에디트텍스트값저장
		editor.commit();//우리 변경한 작업을 파일에 작성하기

	
	
	}
	
	protected void onResume() {
		super.onResume();
	// 우리 앱이 화면에 그려질 때 호출되는 콜백 메서드
// 사용자가 설정한 내용일 저장된 파일에서 정보를 읽어서 화면에 표시하기		
	
		if (sp==null) return;
		
		cb.setChecked(sp.getBoolean("cb", false));
		sw.setChecked(sp.getBoolean("sw", false));
		et.setText(sp.getString("et", ""));
		
		
	}

}//end of class
