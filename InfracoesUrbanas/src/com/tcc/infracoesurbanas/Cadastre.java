package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastre extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Create the Objects
		final EditText authenticationLogin = (EditText)
				findViewById(R.id.authenticationLogin);
		
		final EditText authenticationPassword = (EditText)
				findViewById(R.id.authenticationPassword);
		
		Button loginButton = (Button) findViewById(R.id.enterButton);
		Button cleanButton = (Button) findViewById(R.id.cleanButtonCadastre);
		/*
		loginButton.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) {
				String validatedPassword = "1234";
				
				Intent intent = new Intent(v.getContext(), Cadastre.class);
				Bundle params = new Bundle();
				
				String user = authenticationLogin.getText().toString();
				String password = authenticationPassword.getText().toString();
			
				intent.putExtras(params);
				startActivity(intent);
			}
		}); */
	}
	
}
