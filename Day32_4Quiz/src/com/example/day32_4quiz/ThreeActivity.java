package com.example.day32_4quiz;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ThreeActivity extends PreferenceActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.ss);
	}
	
}