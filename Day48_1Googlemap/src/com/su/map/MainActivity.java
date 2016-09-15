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
 * <구글 맵 사용하기>
 * 
 * 1. 프로젝트 생성시 google service를 사용할 수 있는 API가 포함된 버전을 선택 후 생성한다.
 * 2. SDK Manager에서 Google Play services 설치 해야 한다.(29버전)
 * 3. 이클립스에 google-play-services_lib 프로젝트를 import 해야 한다.(lib Google API 6.0버전)
 * 4. 임포트한 google-play-services_lib를 우리 프로젝트의 라이브러리로 등록한다.(내파일 Google API 6.0버전)
 * 5. 구글 로그인, 개발자 사이트 API key 발급 (SHA1 값을 등록해야 한다)
 * 6. AndroidManifest.xml 권한설정 (각종 권한, 개발자 키)
 * 7. FragmentActivity를 상속받아서 구현(jar->support)
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

		// 지도의 위치와 줌 레벨을 설정
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.6344024,126.9309813), 15));
		// 위도 경도 값은 지도에서 얻어온다
		// zoom 값은 0 이상의 float 값을 입력, 숫자가 클수록 확대됨

		// 지도 우하단 확대/축소 버튼 달기
		map.getUiSettings().setZoomControlsEnabled(true);

		Button bC = (Button)findViewById(R.id.button1);
		Button bH = (Button)findViewById(R.id.button2);
		Button bS = (Button)findViewById(R.id.button3);		
		Button b = (Button)findViewById(R.id.button4);
		
		// 마커 달기
		MarkerOptions mo1 = new MarkerOptions();
		mo1.position(new LatLng(37.504411, 126.956965));
		mo1.title("중앙대");
		mo1.snippet("서울시 동작구");
		map.addMarker(mo1).showInfoWindow(); // 마커를 지도에 달기

		MarkerOptions mo2 = new MarkerOptions();
		mo2.position(new LatLng(37.2978042,126.834793));
		mo2.title("한양대");
		mo2.snippet("경기도 안산시");
		map.addMarker(mo2).showInfoWindow(); // 마커를 지도에 달기
		
		MarkerOptions mo3 = new MarkerOptions();
		mo3.position(new LatLng(37.602638,126.9530687));
		mo3.title("상명대");
		mo3.snippet("서울시 종로구");
		map.addMarker(mo3).showInfoWindow(); // 마커를 지도에 달기

		MarkerOptions mo4 = new MarkerOptions();
		mo4.position(new LatLng(37.6344024,126.9309813));
		mo4.title("우리집");
		mo4.snippet("서울시 은평구");
		map.addMarker(mo4).showInfoWindow(); // 마커를 지도에 달기
		
		
		
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
		
		
		
		
		
		
		
		

		// 오버레이 달기
		GroundOverlayOptions goo1 = new GroundOverlayOptions();
		goo1.image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
		goo1.position(new LatLng(37.504414, 126.956965), 100, 100);
//		map.addGroundOverlay(goo1);

//		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE); // 위성
//		map.setMapType(GoogleMap.MAP_TYPE_TERRAIN); // 지형도
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL); // 일반지도 
		
		map.setOnMapClickListener(new OnMapClickListener() {
			public void onMapClick(LatLng arg0) {
				// 맵을 클릭했을 때 호출되는 콜백 메서드

				// 마커 달기
				MarkerOptions mo1 = new MarkerOptions();
				mo1.position(arg0);
				mo1.title("민규오빠 짱");
				mo1.snippet("정말! 짱~!");
				map.addMarker(mo1).showInfoWindow(); // 마커를 지도에 달기

				// 오버레이 달기
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
