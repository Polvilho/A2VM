package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tcc.model.Usuario;
import com.tcc.webservice.UsuarioREST;

public class MainActivity extends Activity {
	
	private ProgressDialog progressDialog;
	
	private String user;
	private boolean sucesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button loginButton = (Button) findViewById(R.id.enterButton);
        
        loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new GetUsuario().execute();
				
			}
		});
    }
    
    private class GetUsuario extends AsyncTask<Void, Void, Void> {
    	
    	@Override
    	protected void onPreExecute() {
    		super.onPreExecute();
    		
    		progressDialog = new ProgressDialog(MainActivity.this);
    		progressDialog.setMessage("Entrando...");
    		progressDialog.setCancelable(false);
    		progressDialog.show();
    	}
    	
    	@Override
    	protected Void doInBackground(Void... arg0) {
    		
    		final EditText editTextUsuario = (EditText) findViewById(R.id.authenticationLogin);
    		
    		user = editTextUsuario.getText().toString();
    		UsuarioREST usuarioREST = new UsuarioREST();
    		
    		try {
    			Usuario usuario = usuarioREST.getUsuario(user);
    			
    			if(editTextUsuario.getText().toString() != usuario.getUsuario()) {
    				sucesso = true;
    			}
    		} catch(Exception e) {
    			sucesso = false;
    			e.printStackTrace();
    		}
    		
    		return null;
    		
    	}
    	
    	@Override
    	protected void onPostExecute(Void result) {
    		super.onPostExecute(result);
    		
    		final TextView textMessage = (TextView) findViewById(R.id.textViewMessageLogin);
    		
    		if (progressDialog.isShowing())
    			progressDialog.dismiss();
    		
    		if (sucesso == true) {
    			openMenu();
    		}
    		else {
    			textMessage.setText("Usuário e(ou) Senha Incorreto(s)");
    		}
    	}
    }
    
    public void openMenu() {
    	Intent i = new Intent();
    	i.setClass(this, com.tcc.infracoesurbanas.Menu.class);
    	startActivity(i);
    }
    
}
