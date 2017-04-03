
package com.example.day15_4listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	String str[] = { "사과", "딸기", "배", "수박", "바나나", "파인애플", "방울토마토", "사과", "딸기", "배", "수박", "바나나", "파인애플", "방울토마토", "사과",
			"딸기", "배", "수박", "바나나", "파인애플", "방울토마토", "사과", "딸기", "배", "수박", "바나나", "파인애플", "방울토마토", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 고급위젯 : ListView 만들기
		// 1. 다량의 데이터
		// 2. 아답타를 구성한다(하나의 행에 해당하는 layout 준비, 아답타 구현)
		// 3. 아답타뷰(ListView, GridView, Gallery, Spinner)에 아답타를 등록한다

		ListView lv = (ListView) findViewById(R.id.listView1);

		// 2. 아답타를 구성한다
		MyAdapter ma = new MyAdapter(getApplicationContext(), // 현재화면의 제어권자
				R.layout.row, // ListView에 보여줄 한 행 layout
				str);// 다량의데이터
		lv.setAdapter(ma);// 3.아답타뷰에 아답타등록

	}// end of onCreate
}// end of class

// 내가 만든 아답타 - 데이터를 row레이아웃의 어디에 어떻게 배치할지 연결
class MyAdapter extends BaseAdapter {
	// Context context;
	int layout;
	String[] str;
	LayoutInflater lif; // 한행을 담당하는 레이아웃의 자원을 연결하기 위해

	public MyAdapter() {
	}// 기본 생성자

	public MyAdapter(Context context, int layout, String[] str) {// 생성자
		// this.context = context;
		this.layout = layout;
		this.str = str;
		lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// C,c여도
																							// 상관없다
																							// 그러나
																							// 대문자
																							// 권장
	}

	public int getCount() {// 필수 : 리스트의 총 목록의 개수
		return str.length;
	}

	public Object getItem(int position) {// 선택 : 리스트 항목의 해당 데이터
		return str[position];
	}

	public long getItemId(int position) {// 선택 : 리스트 항목의 해당 데이터의 고유id
		return position;
	}

	// getView 필수 : 데이터를 row 레이아웃의 어디에 어떻게 배치할지 연결
	public View getView(int position, View convertView, ViewGroup parent) {
		// 가장 중요한 메서드 ★★★★★
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.textView1);
		tv.setText(str[position]);
		return convertView;// 한 행의 데이터를 연결해서 리턴
	}
}
