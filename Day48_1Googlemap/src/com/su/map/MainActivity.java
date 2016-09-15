package com.su.map;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * <���� �� ����ϱ�>
 * 
 * 1. ������Ʈ ������ google service�� ����� �� �ִ� API�� ���Ե� ������ ���� �� �����Ѵ�.
 * 2. SDK Manager���� Google Play services ��ġ �ؾ� �Ѵ�.(29����)
 * 3. ��Ŭ������ google-play-services_lib ������Ʈ�� import �ؾ� �Ѵ�.(lib Google API 6.0����)
 * 4. ����Ʈ�� google-play-services_lib�� �츮 ������Ʈ�� ���̺귯���� ����Ѵ�.(������ Google API 6.0����)
 * 5. ���� �α���, ������ ����Ʈ API key �߱� (SHA1 ���� ����ؾ� �Ѵ�)
 * 6. AndroidManifest.xml ���Ѽ��� (���� ����, ������ Ű)
 * 7. FragmentActivity�� ��ӹ޾Ƽ� ����(jar->support)
 * 
 * */
public class MainActivity extends FragmentActivity {
	GoogleMap map;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);

		SupportMapFragment smf = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);
		map = smf.getMap();

		// ������ ��ġ�� �� ������ ����
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.6344024,126.9309813), 15));
		// ���� �浵 ���� �������� ���´�
		// zoom ���� 0 �̻��� float ���� �Է�, ���ڰ� Ŭ���� Ȯ���

		// ���� ���ϴ� Ȯ��/��� ��ư �ޱ�
		map.getUiSettings().setZoomControlsEnabled(true);

		Button bC = (Button)findViewById(R.id.button1);
		Button bH = (Button)findViewById(R.id.button2);
		Button bS = (Button)findViewById(R.id.button3);		
		Button b = (Button)findViewById(R.id.button4);
		
		// ��Ŀ �ޱ�
		MarkerOptions mo1 = new MarkerOptions();
		mo1.position(new LatLng(37.504411, 126.956965));
		mo1.title("�߾Ӵ�");
		mo1.snippet("����� ���۱�");
		map.addMarker(mo1).showInfoWindow(); // ��Ŀ�� ������ �ޱ�

		MarkerOptions mo2 = new MarkerOptions();
		mo2.position(new LatLng(37.2978042,126.834793));
		mo2.title("�Ѿ��");
		mo2.snippet("��⵵ �Ȼ��");
		map.addMarker(mo2).showInfoWindow(); // ��Ŀ�� ������ �ޱ�
		
		MarkerOptions mo3 = new MarkerOptions();
		mo3.position(new LatLng(37.602638,126.9530687));
		mo3.title("����");
		mo3.snippet("����� ���α�");
		map.addMarker(mo3).showInfoWindow(); // ��Ŀ�� ������ �ޱ�

		MarkerOptions mo4 = new MarkerOptions();
		mo4.position(new LatLng(37.6344024,126.9309813));
		mo4.title("�츮��");
		mo4.snippet("����� ����");
		map.addMarker(mo4).showInfoWindow(); // ��Ŀ�� ������ �ޱ�
		
		
		
		bC.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.504411, 126.956965), 15));
			}
		});
		bH.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.2978042,126.834793), 15));
			}
		});
		bS.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.602638,126.9530687), 15));
			}
		});
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.6344024,126.9309813), 15));
			}
		});
		
		findViewById(R.id.imageView1).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				openOptionsMenu();
			}
		});
		
		
		
		
		
		
		
		

		// �������� �ޱ�
		GroundOverlayOptions goo1 = new GroundOverlayOptions();
		goo1.image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
		goo1.position(new LatLng(37.504414, 126.956965), 100, 100);
//		map.addGroundOverlay(goo1);

//		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // ����
//		map.setMapType(GoogleMap.MAP_TYPE_TERRAIN); // ������
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL); // �Ϲ����� 
		
		map.setOnMapClickListener(new OnMapClickListener() {
			public void onMapClick(LatLng arg0) {
				// ���� Ŭ������ �� ȣ��Ǵ� �ݹ� �޼���

				// ��Ŀ �ޱ�
				MarkerOptions mo1 = new MarkerOptions();
				mo1.position(arg0);
				mo1.title("�αԿ��� ¯");
				mo1.snippet("����! ¯~!");
				map.addMarker(mo1).showInfoWindow(); // ��Ŀ�� ������ �ޱ�

				// �������� �ޱ�
				GroundOverlayOptions goo1 = new GroundOverlayOptions();
				goo1.image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
				goo1.position(arg0, 100, 100);

				map.addGroundOverlay(goo1);
			}
		});





	}//end of onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.one:
			map.setMapType(GoogleMap.MAP_TYPE_SATELLITE); 
			break;
		case R.id.two:
			map.setMapType(GoogleMap.MAP_TYPE_TERRAIN); 
			break;
		case R.id.three:
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL); 
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	

}//end of class
