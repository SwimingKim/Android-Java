package com.seoul.culture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentTab extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(getActivity(), CategoryActivity.class);
//		startActivity(intent);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.category, container, false);
		Intent intent = getActivity().getIntent();
		return root;
	}

}

//Fragment fragment =  new SelectFormat();
//getActivity().getSupportFragmentManager().beginTransaction().add(getActivity().getWindow().getDecorView().findViewById(android.R.id.content).getId(),fragment).commit();
