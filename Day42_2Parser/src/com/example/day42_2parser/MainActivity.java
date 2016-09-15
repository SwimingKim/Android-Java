package com.example.day42_2parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// xml 태그에서 정보를 손쉽게 추출할 수 있도록 여러가지 parser들이 존재한다
		// Dom Parser, SAX Parser, XMLPullParser, ...
		// Dom Parser : 빠르게 할 수 있지만, 데이터 소모량이 많다
		// XMLPullParser : 안드로이드에서 사용하기 적합하도록 만든 클래스

		tv = (TextView)findViewById(R.id.textView1);
		Button b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				goXmlPullParser();
			}

		});








	}//end of onCreate

	void goXmlPullParser() {
		try {
//		String result = "";//문자열의 연산량이 많아지면 속도가 느려진다
			StringBuffer result = new StringBuffer();

// res/raw/student.xml 자원을 가져오기
			InputStream is = getResources().openRawResource(R.raw.student);

			XmlPullParserFactory xxpf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xxpf.newPullParser();
			xpp.setInput(new InputStreamReader(is));
//			xpp.setInput(new InputStreamReader(is, "utf-8"));//한글 인코딩타입이 다를때
			
			while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) { // 문서의 끝까지 반복
				if (xpp.getEventType()==XmlPullParser.START_TAG) {
					String strName = xpp.getName(); // tag 이름 얻어오기
					if ("member".equals(strName)) {//nullPoint Exception 방지
						result.append(xpp.getAttributeValue(0)+",");
						result.append(xpp.getAttributeValue(1)+"\n");
					}
					if ("name".equals(strName)) {
						result.append(xpp.getAttributeValue(0)+",");
						result.append(xpp.nextText()+"\n");
					} 
					if ("address".equals(strName)) {
						result.append(xpp.nextText()+"\n");
					} 
					if ("age".equals(strName)) {
						result.append(xpp.nextText()+"\n");
					}
				}
				xpp.next(); // 다음 태크(다음 줄)로 넘어가기
			}
			tv.setText(result.toString());
			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}//end of class
