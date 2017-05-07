package com.su.project05_puzzle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends Activity {
	int[] img = {R.drawable.one, R.drawable.two, R.drawable.five, R.drawable.zero, R.drawable.three};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Gallery g = (Gallery)findViewById(R.id.gallery1);

		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.galleryrow,img);
		g.setAdapter(adapter);

		final ImageView iv = (ImageView)findViewById(R.id.imageView1);

		g.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				Log.d("gallery", "onItemSelected");
				iv.setImageResource(img[position]);
				iv.setTag(position+"");
			}
			public void onNothingSelected(AdapterView<?> arg0) {
				Log.d("gallery", "onNothingSelected");		
			}
		});
		
		iv.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				int num = Integer.valueOf(iv.getTag().toString());
				switch (num) {
				case 0:
					Intent intent0 = new Intent(getApplicationContext(), OneActivity.class);
					startActivity(intent0);
					finish();
					break;
				case 1:
					Intent intent1 = new Intent(getApplicationContext(), TwoActivity.class);
					startActivity(intent1);
					finish();
					break;
				case 2:
					Intent intent2 = new Intent(getApplicationContext(), FiveActivity.class);
					startActivity(intent2);
					finish();
					break;
				case 3:
					Intent intent3 = new Intent(getApplicationContext(), ZeroActivity.class);
					startActivity(intent3);
					finish();
					break;
				case 4:
					Intent intent4 = new Intent(getApplicationContext(), ThreeActivity.class);
					startActivity(intent4);
					finish();
					break;

				default:
					break;
				}
			}
		});




	}//end of onCreate

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

}//end of class
