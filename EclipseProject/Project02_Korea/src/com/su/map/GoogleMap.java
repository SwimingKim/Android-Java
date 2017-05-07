package com.su.map;

import java.util.ArrayList;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class GoogleMap extends FragmentActivity{
	private com.google.android.gms.maps.GoogleMap map;
	@Override
	
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.gm);
		
		Intent intent = getIntent();
		double up = intent.getDoubleExtra("up", 0);
		double down = intent.getDoubleExtra("down", 0);
		
		SupportMapFragment smf = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.fragment1);
		map = smf.getMap();
		
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(up, down), 15));
		map.getUiSettings().setZoomControlsEnabled(true);
		
		MarkerOptions mo1 = new MarkerOptions();
		mo1.position(new LatLng(37.7731182,128.9429963)).title("안목해변").snippet("강원도 명소");
		MarkerOptions mo2 = new MarkerOptions();
		mo2.position(new LatLng(37.6584131,126.7620336)).title("일산 호수공원").snippet("수도권 명소");
		MarkerOptions mo3 = new MarkerOptions();
		mo3.position(new LatLng(34.6222575,128.5459788)).title("통영 소매물도").snippet("경상남도 명소");
		MarkerOptions mo4 = new MarkerOptions();
		mo4.position(new LatLng(35.8347202,129.2247643)).title("경주 안압지").snippet("경상북도 명소");
		MarkerOptions mo5 = new MarkerOptions();
		mo5.position(new LatLng(36.3325029,127.4492084)).title("대동하늘공원").snippet("대전광역시 명소");
		MarkerOptions mo6 = new MarkerOptions();
		mo6.position(new LatLng(37.2419723,131.862681)).title("독도").snippet("울릉도독도 명소");
		MarkerOptions mo7 = new MarkerOptions();
		mo7.position(new LatLng(35.3258532,126.9841248)).title("담양 죽녹원").snippet("전라남도 명소");
		MarkerOptions mo8 = new MarkerOptions();
		mo8.position(new LatLng(35.8153767,127.1059535)).title("전주 한옥마을").snippet("전라북도 명소");
		MarkerOptions mo9 = new MarkerOptions();
		mo9.position(new LatLng(36.3056132,126.5072723)).title("보령 대천해수욕장").snippet("충청남도 명소");
		MarkerOptions mo10 = new MarkerOptions();
		mo10.position(new LatLng(36.9999664,128.3417429)).title("단양 도담삼봉").snippet("충청북도 명소");
		MarkerOptions mo11 = new MarkerOptions();
		mo11.position(new LatLng(33.3616837,126.5203904)).title("한라산").snippet("제주도 명소");
		
		map.addMarker(mo1);
		map.addMarker(mo2);
		map.addMarker(mo3);
		map.addMarker(mo4);
		map.addMarker(mo5);
		map.addMarker(mo6);
		map.addMarker(mo7);
		map.addMarker(mo8);
		map.addMarker(mo9);
		map.addMarker(mo10);
		map.addMarker(mo11);
		
		
	}

}
