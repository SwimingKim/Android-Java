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
		mo1.position(new LatLng(37.7731182,128.9429963)).title("�ȸ��غ�").snippet("������ ���");
		MarkerOptions mo2 = new MarkerOptions();
		mo2.position(new LatLng(37.6584131,126.7620336)).title("�ϻ� ȣ������").snippet("������ ���");
		MarkerOptions mo3 = new MarkerOptions();
		mo3.position(new LatLng(34.6222575,128.5459788)).title("�뿵 �ҸŹ���").snippet("��󳲵� ���");
		MarkerOptions mo4 = new MarkerOptions();
		mo4.position(new LatLng(35.8347202,129.2247643)).title("���� �Ⱦ���").snippet("���ϵ� ���");
		MarkerOptions mo5 = new MarkerOptions();
		mo5.position(new LatLng(36.3325029,127.4492084)).title("�뵿�ϴð���").snippet("���������� ���");
		MarkerOptions mo6 = new MarkerOptions();
		mo6.position(new LatLng(37.2419723,131.862681)).title("����").snippet("�︪������ ���");
		MarkerOptions mo7 = new MarkerOptions();
		mo7.position(new LatLng(35.3258532,126.9841248)).title("��� �׳��").snippet("���󳲵� ���");
		MarkerOptions mo8 = new MarkerOptions();
		mo8.position(new LatLng(35.8153767,127.1059535)).title("���� �ѿ�����").snippet("����ϵ� ���");
		MarkerOptions mo9 = new MarkerOptions();
		mo9.position(new LatLng(36.3056132,126.5072723)).title("���� ��õ�ؼ�����").snippet("��û���� ���");
		MarkerOptions mo10 = new MarkerOptions();
		mo10.position(new LatLng(36.9999664,128.3417429)).title("�ܾ� ������").snippet("��û�ϵ� ���");
		MarkerOptions mo11 = new MarkerOptions();
		mo11.position(new LatLng(33.3616837,126.5203904)).title("�Ѷ��").snippet("���ֵ� ���");
		
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
