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

		// xml �±׿��� ������ �ս��� ������ �� �ֵ��� �������� parser���� �����Ѵ�
		// Dom Parser, SAX Parser, XMLPullParser, ...
		// Dom Parser : ������ �� �� ������, ������ �Ҹ��� ����
		// XMLPullParser : �ȵ���̵忡�� ����ϱ� �����ϵ��� ���� Ŭ����

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
//		String result = "";//���ڿ��� ���귮�� �������� �ӵ��� ��������
			StringBuffer result = new StringBuffer();

// res/raw/student.xml �ڿ��� ��������
			InputStream is = getResources().openRawResource(R.raw.student);

			XmlPullParserFactory xxpf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xxpf.newPullParser();
			xpp.setInput(new InputStreamReader(is));
//			xpp.setInput(new InputStreamReader(is, "utf-8"));//�ѱ� ���ڵ�Ÿ���� �ٸ���
			
			while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) { // ������ ������ �ݺ�
				if (xpp.getEventType()==XmlPullParser.START_TAG) {
					String strName = xpp.getName(); // tag �̸� ������
					if ("member".equals(strName)) {//nullPoint Exception ����
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
				xpp.next(); // ���� ��ũ(���� ��)�� �Ѿ��
			}
			tv.setText(result.toString());
			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}//end of class
