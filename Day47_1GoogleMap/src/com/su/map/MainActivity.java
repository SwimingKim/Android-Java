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

	private GoogleMap map;

	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);

		// ���� ��ü�� xml���� ��������
		SupportMapFragment smf = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1);
		map = smf.getMap();

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.6341681, 126.9326195), 15));
		// ���� �浵 ���� �������� ���´�
		// zoom ���� 0 �̻��� float ���� �Է�, ���ڰ� Ŭ ���� Ȯ���

		// ���� ���ϴ� Ȯ��/��� ��ư �ޱ�
		map.getUiSettings().setZoomControlsEnabled(true);

		// ��Ŀ �ޱ�
		MarkerOptions mo1 = new MarkerOptions();
//		mo1.position(new LatLng(37.6341681,126.932619)).title("�츮��").snippet("����! ¯!");
		mo1.position(new LatLng(37.6341681,126.932619));
		mo1.title("�츮��");
		mo1.snippet("����! ¯!");
//		map.addMarker(mo1).showInfoWindow();
		map.addMarker(mo1);

		MarkerOptions mo2 = new MarkerOptions();
		mo2.position(new LatLng(37.6026422,126.953058)).title("�츮�б�").snippet("����Ф�");
		map.addMarker(mo2);

		// �������� �ޱ�
		GroundOverlayOptions goo1 = new GroundOverlayOptions();
		goo1.image(BitmapDescriptorFactory.fromResource(R.drawable.haha));
		goo1.position(new LatLng(37.6026422,126.953058), 100, 100);

		map.addGroundOverlay(goo1);
		
		// ��Ŀ�� ������ ũ�Ⱑ ����, �������̴� ������ ũ�Ⱑ �ִ�.
		
		map.setOnMapClickListener(new OnMapClickListener() {
			public void onMapClick(LatLng arg0) {
				// ���� Ŭ������ �� ȣ��Ǵ� �ݹ�޼���
				GroundOverlayOptions goo1 = new GroundOverlayOptions();
				goo1.image(BitmapDescriptorFactory.fromResource(R.drawable.haha));
				goo1.position(arg0, 100, 100);
				map.addGroundOverlay(goo1);
			}
		});
		
	}//end of onCreate
}//end of class


