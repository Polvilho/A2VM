package com.tcc.infracoesurbanas;

import com.tcc.model.Autuacao;
import com.tcc.webservice.AutuacaoREST;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.EditText;
//import android.widget.Spinner;
import android.widget.Toast;

public class Cadastre extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastre);
		
		//EditText editTextIDInfracao = (EditText) findViewById(R.id.infractionNumberTextCadastre);
		//EditText editTextPlaca = (EditText) findViewById(R.id.boardTextCadastre);
		//EditText editTextName = (EditText) findViewById(R.id.textNameCadastre);
		//EditText editTextData = (EditText) findViewById(R.id.dateTextCadastre);
		//EditText editTextHora = (EditText) findViewById(R.id.hourTextCadastre);
		//Spinner spinnerOrgao = (Spinner) findViewById(R.id.orgaoSpinner);
		//Spinner spinnerMarca = (Spinner) findViewById(R.id.companySpinner);
		//Spinner spinnerAno = (Spinner) findViewById(R.id.yearSpinner);
		Button buttonCadastrar = (Button) findViewById(R.id.cadastreButton);
		final TextView textMessage = (TextView) findViewById(R.id.textView1);
		
		buttonCadastrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Autuacao autuacao = new Autuacao();
				autuacao.setId(2);
				autuacao.setOrgaoAutuador("SP");
				autuacao.setPlaca("FHB-8080");
				autuacao.setMarca("KIA");
				autuacao.setModelo("Ceratto");
				autuacao.setAno("2014");
				autuacao.setAutuacao("Celular ao Volante");
				autuacao.setProprietario("Ronaldo da Silva");
				autuacao.setData("2014/08/19");
				autuacao.setHora("18:00:00");
				
				AutuacaoREST autuacaoREST = new AutuacaoREST();
				
				try {
					String resposta = autuacaoREST.inserirAutuacao(autuacao);
					textMessage.setText(resposta);
				} catch (Exception e) {
					e.printStackTrace();
					gerarToast(e.getMessage());
				}
			}
		});	
	}
	
	private void gerarToast(CharSequence message) {
		int duration = Toast.LENGTH_LONG;
		Toast toast = Toast
				.makeText(getApplicationContext(), message, duration);
		toast.show();
	}
	
	public void onBackToMenuButtonCadastreClick(View v) {
		Intent i = new Intent();
		i.setClass(this, Menu.class);
		startActivity(i);
	}
	
}