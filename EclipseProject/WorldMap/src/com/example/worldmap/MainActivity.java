package com.example.worldmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	int img[] = { R.drawable.japan2, R.drawable.china3, R.drawable.daeman, R.drawable.hong, R.drawable.be,
			R.drawable.sing2, R.drawable.indonesia2, R.drawable.england, R.drawable.france2, R.drawable.germany,
			R.drawable.italia2, R.drawable.swiss, R.drawable.usa };

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView iv = (ImageView) findViewById(R.id.imageView1);
		final TextView tv1 = (TextView) findViewById(R.id.textView1);
		final TextView tv2 = (TextView) findViewById(R.id.textView2);
		final TextView tv3 = (TextView) findViewById(R.id.textView3);
		final TextView tv4 = (TextView) findViewById(R.id.textView4);
		final TextView tv5 = (TextView) findViewById(R.id.textView5);
		final TextView tv6 = (TextView) findViewById(R.id.textView6);
		final TextView tv7 = (TextView) findViewById(R.id.textView7);
		final TextView tv8 = (TextView) findViewById(R.id.textView8);
		final TextView tv9 = (TextView) findViewById(R.id.textView9);
		final TextView tv10 = (TextView) findViewById(R.id.textView10);
		final TextView tv11 = (TextView) findViewById(R.id.textView11);
		final TextView tv12 = (TextView) findViewById(R.id.textView12);
		final TextView tv13 = (TextView) findViewById(R.id.textView13);

		ImageView b = (ImageView) findViewById(R.id.imageView2);

		// ButtonEvent be = new ButtonEvent();

		tv1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[0]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[1]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[2]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[3]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv5.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[4]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv6.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[5]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv7.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[6]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv8.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[7]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv9.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[8]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv10.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[9]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv11.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[10]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv12.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[11]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});
		tv13.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(img[12]);
				tv1.setVisibility(View.INVISIBLE);
				tv2.setVisibility(View.INVISIBLE);
				tv3.setVisibility(View.INVISIBLE);
				tv4.setVisibility(View.INVISIBLE);
				tv5.setVisibility(View.INVISIBLE);
				tv6.setVisibility(View.INVISIBLE);
				tv7.setVisibility(View.INVISIBLE);
				tv8.setVisibility(View.INVISIBLE);
				tv9.setVisibility(View.INVISIBLE);
				tv10.setVisibility(View.INVISIBLE);
				tv11.setVisibility(View.INVISIBLE);
				tv12.setVisibility(View.INVISIBLE);
				tv13.setVisibility(View.INVISIBLE);
			}
		});

		// tv1.setOnClickListener(be);
		// tv2.setOnClickListener(be);
		// tv3.setOnClickListener(be);
		// tv4.setOnClickListener(be);
		// tv5.setOnClickListener(be);
		// tv6.setOnClickListener(be);
		// tv7.setOnClickListener(be);
		// tv8.setOnClickListener(be);
		// tv9.setOnClickListener(be);
		// tv10.setOnClickListener(be);
		// tv11.setOnClickListener(be);
		// tv12.setOnClickListener(be);
		// tv13.setOnClickListener(be);

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				iv.setImageResource(R.drawable.dottep);
				tv1.setVisibility(View.VISIBLE);
				tv2.setVisibility(View.VISIBLE);
				tv3.setVisibility(View.VISIBLE);
				tv4.setVisibility(View.VISIBLE);
				tv5.setVisibility(View.VISIBLE);
				tv6.setVisibility(View.VISIBLE);
				tv7.setVisibility(View.VISIBLE);
				tv8.setVisibility(View.VISIBLE);
				tv9.setVisibility(View.VISIBLE);
				tv10.setVisibility(View.VISIBLE);
				tv11.setVisibility(View.VISIBLE);
				tv12.setVisibility(View.VISIBLE);
				tv13.setVisibility(View.VISIBLE);

			}
		});

	}// end of onCreate

	// class ButtonEvent implements OnClickListener{
	// public void onClick(View v) {
	// TextView bt = (TextView)v;
	// iv.setImageResource(img[index]);
	// tv1.setVisibility(View.INVISIBLE);
	// tv2.setVisibility(View.INVISIBLE);
	// tv3.setVisibility(View.INVISIBLE);
	// tv4.setVisibility(View.INVISIBLE);
	// tv5.setVisibility(View.INVISIBLE);
	// tv6.setVisibility(View.INVISIBLE);
	// tv7.setVisibility(View.INVISIBLE);
	// tv8.setVisibility(View.INVISIBLE);
	// tv9.setVisibility(View.INVISIBLE);
	// tv10.setVisibility(View.INVISIBLE);
	// tv11.setVisibility(View.INVISIBLE);
	// tv12.setVisibility(View.INVISIBLE);
	// tv13.setVisibility(View.INVISIBLE);
	// }
	// };

}// end of class
