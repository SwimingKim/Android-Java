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
		
		//myset.dat���Ͽ� ����
		sp = getSharedPreferences("myset.dat",Context.MODE_PRIVATE);
////�б�
//		sp.getBoolean("cb", true);
////����		
//		Editor editor = sp.edit();// SharedPreference���� Editor��ü ����
//		editor.putBoolean("cd", false);// Ű, ��
//		
//		editor.commit();
		
		
		
		
		
		
		
	}//end of onCreate
	
	protected void onPause() {
		// �츮 ���� �ٸ� �˾��� ���� ȭ���� �Ϻΰ� �������� �� ȣ��Ǵ� �ݹ� �޼���
		super.onPause();
// ����ڰ� ������ �۾��� ���Ͽ� �����ϱ�
//		SharedPreferences sp = getSharedPreferences("myset.dat", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean("cb", cb.isChecked());//üũ�ڽ�������
		editor.putBoolean("sw", sw.isChecked());//����ġ������
		editor.putString("et", et.getText().toString());//����Ʈ�ؽ�Ʈ������
		editor.commit();//�츮 ������ �۾��� ���Ͽ� �ۼ��ϱ�

	
	
	}
	
	protected void onResume() {
		super.onResume();
	// �츮 ���� ȭ�鿡 �׷��� �� ȣ��Ǵ� �ݹ� �޼���
// ����ڰ� ������ ������ ����� ���Ͽ��� ������ �о ȭ�鿡 ǥ���ϱ�		
	
		if (sp==null) return;
		
		cb.setChecked(sp.getBoolean("cb", false));
		sw.setChecked(sp.getBoolean("sw", false));
		et.setText(sp.getString("et", ""));
		
		
	}

}//end of class
