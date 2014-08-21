package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
	}
	
	public void onToCadastreButtonClick(View v){
		Intent i = new Intent();
		i.setClass(this, Cadastre.class);
		startActivity(i);
	}
	
	public void onToInquiryButtonClick(View v){
		Intent i = new Intent();
		i.setClass(this, Inquiry.class);
		startActivity(i);
	}
	
	public void onToLogoutButtonClick(View v) {
		Intent i = new Intent();
		i.setClass(this, MainActivity.class);
		startActivity(i);
	}
	
}
