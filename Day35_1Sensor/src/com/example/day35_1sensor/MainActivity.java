package com.example.day35_1sensor;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv = (TextView)findViewById(R.id.textView2);
		
// 핸드폰에 설치된 센서들의 목록을 가져오기
		SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);
		
		String str = "<핸드폰의 센서목록>/n";
		str += "\n센서의 개수 : "+sensors.size()+"개\n";
		for (int i = 0; i < sensors.size(); i++) {
			str+= "\n\nName : "+ sensors.get(i).getName();			
			str+= "\n\nVendor : "+ sensors.get(i).getVendor();
			str+= "\n\nPower : "+ sensors.get(i).getPower();
			str+= "\n\nResolution : "+ sensors.get(i).getResolution();
			str+= "\n\nMaxinumRange : "+ sensors.get(i).getMaximumRange();		
			str+= "\n\n\n";
		}
		
		tv.append(str);
		
		
		
		
		
		
		
		
		
		
	}//end of onCreat
}//end of class
