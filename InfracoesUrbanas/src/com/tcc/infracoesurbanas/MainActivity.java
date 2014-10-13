package com.tcc.infracoesurbanas;

import com.tcc.model.Usuario;
import com.tcc.webservice.UsuarioREST;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
        	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        	
        	StrictMode.setThreadPolicy(policy);
        }
    }
    
    public void onEnterButtonClick(View v){
    	
    	final EditText editTextUsuario = (EditText) findViewById(R.id.authenticationLogin);
        final TextView textMessage = (TextView) findViewById(R.id.textViewMessageLogin);
        
        user = editTextUsuario.getText().toString();
		UsuarioREST usuarioREST = new UsuarioREST();
		
		try {
			Usuario usuario = usuarioREST.getUsuario(user);
			if(editTextUsuario.getText().toString() != usuario.getUsuario()){
				Intent i = new Intent();
		    	i.setClass(this, com.tcc.infracoesurbanas.Menu.class);
		    	startActivity(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
			textMessage.setText("Usuário ou Senha Incorreto");
		}
    }
    
}
