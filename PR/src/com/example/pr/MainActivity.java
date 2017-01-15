package com.example.pr;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	Act ac[] = { new Act("홍보단", R.drawable.h, "2014.04.07~2014.12.31\n" + "고양시 자원봉사센터 홍보단 및 기자단활동\n" + "고양 시장 표창장 수여"),
			new Act("해외봉사", R.drawable.c, "2016.01.12~2016.01.25\n" + "캄보디아 초등학생 1000명 대상\n교육봉사, 노력봉사, 문화교류활동"),
			new Act("서브웨이", R.drawable.s, "2013.08.24~2014.12.28\n" + "고객 응대 및 매장 관리, 재료 발주,\n샌드위치 제조 및 판매"),
			new Act("봉사활동", R.drawable.b, "500시간 봉사활동 수행\n" + "벤츠 모바일키즈 교육봉사단, 쉴가 지역아동센터, 백송 노인주간센터, YMCA"),
			new Act("R", R.drawable.wom, "통계학술동아리 1년간 활동\n" + "Twitter API로 돈과 관련한 사람의 인식을\n분석하여 wordcloud 생성"),
			new Act("SPSS", R.drawable.wom, "사회조사분석사 2급 취득\n" + "정형 데이터에 연관분석, 상관분석 등 통계적 기법 적용"),
			new Act("Excel", R.drawable.wom, "컴퓨터활용능력 2급 취득\n" + "고급 함수 및 매크로 활용 가능"),
			new Act("Java", R.drawable.m, "프로그래밍의 기초 이해\n" + "자판기 프로그램 구현") };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView lv = (ListView) findViewById(R.id.listView1);
		MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, ac);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

				intent.putExtra("act", ac[position]);

				startActivity(intent);
			}
		});

	}// end of onCreate
}// end of class

class Act implements Serializable {
	String name;
	int img;
	String text;

	public Act() {

	}

	public Act(String name, int img, String text) {
		this.name = name;
		this.img = img;
		this.text = text;
	}
}

class MyAdapter extends BaseAdapter {
	int layout;
	Act[] ac;
	LayoutInflater lif;

	public MyAdapter() {
	}

	public MyAdapter(Context context, int layout, Act[] ac) {
		this.layout = layout;
		this.ac = ac;
		this.lif = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return ac.length;
	}

	public Object getItem(int position) {
		return ac[position];
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = lif.inflate(layout, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.textView1);

		tv.setText(ac[position].name);

		return convertView;
	}

}
