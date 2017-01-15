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

	private GoogleMap map;

	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);

		// 지도 객체를 xml에서 가져오기
		SupportMapFragment smf = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1);
		map = smf.getMap();

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.6341681, 126.9326195), 15));
		// 위도 경도 값은 지도에서 얻어온다
		// zoom 값은 0 이상의 float 값을 입력, 숫자가 클 수록 확대됨

		// 지도 우하단 확대/축소 버튼 달기
		map.getUiSettings().setZoomControlsEnabled(true);

		// 마커 달기
		MarkerOptions mo1 = new MarkerOptions();
//		mo1.position(new LatLng(37.6341681,126.932619)).title("우리집").snippet("정말! 짱!");
		mo1.position(new LatLng(37.6341681,126.932619));
		mo1.title("우리집");
		mo1.snippet("정말! 짱!");
//		map.addMarker(mo1).showInfoWindow();
		map.addMarker(mo1);

		MarkerOptions mo2 = new MarkerOptions();
		mo2.position(new LatLng(37.6026422,126.953058)).title("우리학교").snippet("언덕ㅠㅠ");
		map.addMarker(mo2);

		// 오버레이 달기
		GroundOverlayOptions goo1 = new GroundOverlayOptions();
		goo1.image(BitmapDescriptorFactory.fromResource(R.drawable.haha));
		goo1.position(new LatLng(37.6026422,126.953058), 100, 100);

		map.addGroundOverlay(goo1);
		
		// 마커는 일정한 크기가 없고, 오버레이는 일정한 크기가 있다.
		
		map.setOnMapClickListener(new OnMapClickListener() {
			public void onMapClick(LatLng arg0) {
				// 맵을 클릭했을 때 호출되는 콜백메서드
				GroundOverlayOptions goo1 = new GroundOverlayOptions();
				goo1.image(BitmapDescriptorFactory.fromResource(R.drawable.haha));
				goo1.position(arg0, 100, 100);
				map.addGroundOverlay(goo1);
			}
		});
		
	}//end of onCreate
}//end of class


