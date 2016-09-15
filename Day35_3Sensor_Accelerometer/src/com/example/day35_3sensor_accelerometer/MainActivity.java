package com.example.day35_3sensor_accelerometer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SensorManager sm;
	private Sensor sensor;
	private OL ol;
	private TextView tx;
	private TextView ty;
	private ImageView iv;
	private int h;
	private int w;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

// �ڵ��� ȭ���� ũ�⸦ �˾ƿ���
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display ds = wm.getDefaultDisplay();
		Point p = new Point();//2���� ��ǥ�� �߻�ȭ�� Ŭ����, x, y
		ds.getSize(p); // ȭ���� ũ�⸦ Point Ŭ������ ����ش�
		h = p.x;
		w = p.y;
		
		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		ol = new OL();

		tx = (TextView)findViewById(R.id.textView1);
		ty = (TextView)findViewById(R.id.textView2);
		iv = (ImageView)findViewById(R.id.imageView1);

	}//end of onCreate

	@Override
	protected void onResume() {
		super.onResume();
		sm.registerListener(ol, sensor, SensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sm.unregisterListener(ol, sensor);
	}

	class OL implements SensorEventListener {

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			tx.setText("X�� : "+event.values[0]);
			ty.setText("Y�� : "+event.values[1]);
			
			
			float px = iv.getX()-event.values[0]; //event.values[0]*-500+400
			float py = iv.getY()+event.values[1]; //event.values[1]*100+100

// �����ϰ��� �ϴ� ���� ȭ��������� ����� �ʴ��� üũ����
			if (px<0) px = 0;// �������� ����� ���ϰ�
			if (px>w-iv.getWidth()) px = w-iv.getWidth();// ���������� ����� ���ϰ�
		
			if (py<0) py = 0;// �������� ����� ���ϰ�
			if (py>h-iv.getHeight()*2) py = h-iv.getHeight()*2;// �Ʒ������� ����� ���ϰ�
																// Ÿ��Ʋ���� ������ ���̸� ���
			
			iv.setX(px);
			iv.setY(py);
		}

	}

}//end of class
