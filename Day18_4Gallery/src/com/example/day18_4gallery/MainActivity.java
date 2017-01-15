package com.example.day18_4gallery;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {
	int[] img = {R.drawable.eric, R.drawable.jae, R.drawable.jin,
			R.drawable.kae, R.drawable.kang, R.drawable.lee,
			R.drawable.park, R.drawable.seo,};
	private SensorManager sm;
	private Sensor sensor;
	private ImageView iv;
	private OL ol;
	
	int p = 0;
	private Gallery g;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//아답타뷰 (ListView, GridView, Gallery, Spinner)
		//1. 다량의 데이터
		//2. 아답타 (layout, 클래스 작성)
		//3. 아답타뷰에 아답타 연결

		iv = (ImageView)findViewById(R.id.imageView1);

		g = (Gallery)findViewById(R.id.gallery1);

		MyAdapter adapter = new MyAdapter(getApplicationContext(), 
				R.layout.row,img);
		g.setAdapter(adapter);
		
		
		g.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Log.d("gallery", "onItemSelected");
				iv.setImageResource(img[position]);
				p = position;
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				Log.d("gallery", "onNothingSelected");		
			}
		});


		sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		ol = new OL();		
		
	


		

	}//end of onCreate

	@Override
	protected void onResume() {
		super.onResume();
		sm.registerListener(ol, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sm.unregisterListener(ol, sensor);
	}

	class OL implements SensorEventListener{

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			float[] x = event.values;
			if (event.values!=null) {
				if (event.values[0]>=3) {//오른쪽으로 가기
					p++; 
//					event.values[0] = x[0];
					if (p>=img.length-1) p = img.length-1;
				} else if (event.values[0]<=-3){//왼쪽으로 가기
					p--;
//					event.values[0] = x[0];
					if (p<=0) p = 0;
				}
				
			}
			g.setSelection((int)p);
		}

	}






}//end of class

class MyAdapter extends BaseAdapter{
	int[] img;
	int row;
	LayoutInflater lif;

	public MyAdapter() {}
	public MyAdapter(Context context, int row, int[] img) {
		this.row = row;
		this.img = img;
		this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

	}




	public int getCount() {
		return img.length;
	}

	public Object getItem(int position) {
		return img[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView==null){
			convertView=lif.inflate(row, null);
		}

		ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
		iv.setImageResource(img[position]);;

		return convertView;
	}





}