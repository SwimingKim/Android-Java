package com.example.project04_weather;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private EditText tv;
	private Button b;
	Handler handler = new Handler();
	private StringBuilder weather;
	String xml = "";
	ArrayList<Clothes> ct = new ArrayList<Clothes>();
	Clothes[] clo = {new Clothes("Ƽ����", R.drawable.clo1, false, true, false, false),
			new Clothes("�����", R.drawable.clo2, false, false, true, false),
			new Clothes("����", R.drawable.clo3, true, false, true, false),
			new Clothes("������", R.drawable.clo4, false, false, true, false),
			new Clothes("��Ʈ", R.drawable.clo5, false, false, false, true),
			new Clothes("ī��Ƽ", R.drawable.clo6, true, true, false, false),
			new Clothes("�ĵ�Ƽ", R.drawable.clo7, false, false, true, true),
			new Clothes("�е�", R.drawable.clo8, false, false, false, true),
			new Clothes("û����", R.drawable.clo9, true, true, true, true),
			new Clothes("�ݹ���", R.drawable.clo10, true, false, false, false),
			new Clothes("ġ��", R.drawable.clo11, true, false, true, false),
			new Clothes("���ǽ�", R.drawable.clo12, true, true, false, false)};
	private String aa;
	int num;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (EditText)findViewById(R.id.editText1);
		b = (Button)findViewById(R.id.bweather);		
		
		tv.setText("������ ������ Ȯ�����ּ���");

		final MyGrid mg = new MyGrid(getApplicationContext(),R.layout.clo_row,ct);
		final GridView gv = (GridView)findViewById(R.id.gridView1);

		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				downloadHtml();
				goXmlPullParser();

				ct.clear();
				String str = tv.getText().toString();
				if (!"������ ������ Ȯ�����ּ���".equals(str)) {
					String arr[] = str.split(",");
					float temp = Float.parseFloat(arr[1].substring(8));
					if (temp>10&&temp<=20) {
						for (int i = 0; i < clo.length; i++) {
							if (clo[i].spring) {
								ct.add(clo[i]);
							}
						}
					} else if (temp>20) {
						for (int i = 0; i < clo.length; i++) {
							if (clo[i].summer) {
								ct.add(clo[i]);
							}
						}
					} else if (temp>5&&temp<=10) {
						for (int i = 0; i < clo.length; i++) {
							if (clo[i].fall) {
								ct.add(clo[i]);
							}
						}
					} else if (temp<=5) {
						for (int i = 0; i < clo.length; i++) {
							if (clo[i].winter) {
								ct.add(clo[i]);
							}
						}
					}
					gv.setAdapter(mg);
					Log.e("gallery", temp+"");
				}

			}

		});


		final Button b_start = (Button)findViewById(R.id.button1);		
		final Button b_way = (Button)findViewById(R.id.button2);		

		b_start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
				startActivity(intent);
				finish();
			}
		});

		b_way.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), CloActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		gv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				num = position;
				showDialog(0);
			}
		});




	}//end of onCreate
	
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case 0:

			final ImageView iv = (ImageView)dialog.findViewById(R.id.imageView1);
			final EditText et_site = (EditText)dialog.findViewById(R.id.editText1);
			final EditText et_id = (EditText)dialog.findViewById(R.id.editText2);

			iv.setImageResource(ct.get(num).img);
			et_site.setText(ct.get(num).name);
			String str = "";
			if (ct.get(num).spring) str += "�� "; 
			if (ct.get(num).summer) str += "���� "; 
			if (ct.get(num).fall) str += "���� "; 
			if (ct.get(num).winter) str += "�ܿ� "; 
			et_id.setText(str);


			et_site.setEnabled(false);
			et_id.setEnabled(false);

			break;

		default:
			break;
		}


		super.onPrepareDialog(id, dialog);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 0:
			AlertDialog.Builder dialog = new Builder(this);
			LayoutInflater lif2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View MyView2 = lif2.inflate(R.layout.look, null);
			dialog = new Builder(this);
			dialog.setTitle("�˻� ���");
			dialog.setView(MyView2);

			dialog.setNegativeButton("Ȯ��",null);

			return dialog.create();

		default:
			break;
		}
		return super.onCreateDialog(id);
	}
	class Clothes{
		String name;
		int img;
		boolean spring;
		boolean summer;
		boolean fall;
		boolean winter;
		public Clothes(String name, int img, boolean spring, boolean summer, boolean fall, boolean winter) {
			super();
			this.name = name;
			this.img = img;
			this.spring = spring;
			this.summer = summer;
			this.fall = fall;
			this.winter = winter;
		}

	}

	class MyGrid extends BaseAdapter{
		int row;
		ArrayList<Clothes> ct;
		LayoutInflater lif;		

		public MyGrid(Context context, int row,ArrayList<Clothes> ct) {
			this.row = row;
			this.ct = ct;
			this.lif = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		}


		@Override
		public int getCount() {
			return ct.size();
		}

		@Override
		public Object getItem(int position) {
			return ct.get(position).img;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int pos, View convertView, ViewGroup parent) {
			if (convertView==null) {
				convertView = lif.inflate(R.layout.clo_row, null);
			}
			ImageView ima = (ImageView)convertView.findViewById(R.id.imageView1);
			ima.setImageResource(ct.get(pos).img);

			return convertView;
		}

	}

	void goXmlPullParser() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();

			InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
			Document doc = documentBuilder.parse(is);

			Element element = doc.getDocumentElement();
			NodeList items0 = element.getElementsByTagName("pubDate");
			NodeList items1 = element.getElementsByTagName("temp");
			NodeList items3 = element.getElementsByTagName("wfKor");

			final StringBuffer result = new StringBuffer();

			String itemValue0 = items0.item(0).getFirstChild().getNodeValue();
			String itemValue1 = items1.item(0).getFirstChild().getNodeValue();
			String itemValue3 = items3.item(0).getFirstChild().getNodeValue();

			result.append(itemValue0+" ����,\n");
			result.append("���� �µ� : "+itemValue1+",\n");
			result.append("���� : "+itemValue3+",\n");

			tv.setText(result.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}

	void downloadHtml() {
		Thread t = new Thread(new Runnable() {


			public void run() {
				weather = new StringBuilder();

				try {
					URL url = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1138069000");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setConnectTimeout(1000); 
					conn.setUseCaches(false);
					if (conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
						BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));//�ѱ����ڵ�ó��
						while (true) {
							String str = br.readLine();
							if (str==null) break;
							weather.append(str+"\n");
							Log.d("web", str);
						}
						br.close();
						conn.disconnect();
					}
					xml = weather.toString();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		t.start();// ������ ���۽�Ű��		

	}

}//end of class
