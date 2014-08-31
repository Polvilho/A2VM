package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tcc.model.Autuacao;
import com.tcc.webservice.AutuacaoREST;
//import android.widget.EditText;
//import android.widget.Spinner;

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
		Spinner spinnerOrgao = (Spinner) findViewById(R.id.orgaoSpinner);
		Spinner spinnerMarca = (Spinner) findViewById(R.id.companySpinner);
		Spinner spinnerAno = (Spinner) findViewById(R.id.yearSpinner);
		Spinner spinnerAutuacao = (Spinner) findViewById(R.id.spinnerAutuacao);
		Button buttonCadastrar = (Button) findViewById(R.id.cadastreButton);
		final TextView textMessage = (TextView) findViewById(R.id.textView12);
		
		//ArrayAdapter para Orgao Autuador  
		ArrayAdapter<CharSequence> adapterOrgaoAutuador = ArrayAdapter.createFromResource(
				this, R.array.orgaoAutuador, android.R.layout.simple_spinner_item);
		adapterOrgaoAutuador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerOrgao.setAdapter(adapterOrgaoAutuador);
		
		//ArrayAdapter para Marca do Veiculo
		ArrayAdapter<CharSequence> adapterCompany = ArrayAdapter.createFromResource(
				this, R.array.company, android.R.layout.simple_spinner_item);
		adapterCompany.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerMarca.setAdapter(adapterCompany);
		
		//Array Adapter para Ano do Veiculo
		ArrayAdapter<CharSequence> adapterYear = ArrayAdapter.createFromResource(
				this, R.array.year, android.R.layout.simple_spinner_item);
		adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerAno.setAdapter(adapterYear);
		
		//Array Adapter para Autuacao
		ArrayAdapter<CharSequence> adapterAutuacao = ArrayAdapter.createFromResource(
				this, R.array.autuacoes, android.R.layout.simple_spinner_item);
		adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerAutuacao.setAdapter(adapterAutuacao);
		
		
		
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