package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tcc.model.Autuacao;
import com.tcc.webservice.AutuacaoREST;

public class Cadastre extends Activity{
	
	private ProgressDialog progressDialog;
	
	protected EditText editTextPlaca;
	public String placa;
	
	Autuacao autuacao = new Autuacao();
	private String resposta;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastre);
		
		Intent i = getIntent();
        placa = i.getStringExtra("recognizedBoard");
        
        editTextPlaca = (EditText) findViewById(R.id.boardTextCadastre);
		
		//final EditText editTextPlaca = (EditText) findViewById(R.id.boardTextCadastre);
		final EditText editTextMunicipio = (EditText) findViewById(R.id.cityTextCadastre);
		final EditText editTextName = (EditText) findViewById(R.id.textNameCadastre);
		final EditText editTextModelo = (EditText) findViewById(R.id.modelText);
		final EditText editTextCor = (EditText) findViewById(R.id.colorTextCadastre);
		final Spinner spinnerEstado = (Spinner) findViewById(R.id.stateSpinner);
		final Spinner spinnerMarca = (Spinner) findViewById(R.id.companySpinner);
		final Spinner spinnerAno = (Spinner) findViewById(R.id.yearSpinner);
		final Spinner spinnerAutuacao = (Spinner) findViewById(R.id.spinnerAutuacao);
		Button buttonCadastrar = (Button) findViewById(R.id.cadastreButton);
		
		editTextPlaca.setText(placa);
		
		//ArrayAdapter para Estado  
		ArrayAdapter<CharSequence> adapterOrgaoAutuador = ArrayAdapter.createFromResource(
				this, R.array.state, android.R.layout.simple_spinner_item);
		adapterOrgaoAutuador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinnerEstado.setAdapter(adapterOrgaoAutuador);
		
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

				autuacao.setEstado(spinnerEstado.getSelectedItem().toString());
				autuacao.setMunicipio(editTextMunicipio.getText().toString());
				autuacao.setPlaca(editTextPlaca.getText().toString());
				autuacao.setMarca(spinnerMarca.getSelectedItem().toString());
				autuacao.setModelo(editTextModelo.getText().toString());
				autuacao.setAno(spinnerAno.getSelectedItem().toString());
				autuacao.setCor(editTextCor.getText().toString());
				autuacao.setAutuacao(spinnerAutuacao.getSelectedItem().toString());
				autuacao.setProprietario(editTextName.getText().toString());
				
				new SetAutuacao().execute();
				
			}
		});
	}
	
	private class SetAutuacao extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			progressDialog = new ProgressDialog(Cadastre.this);
			progressDialog.setMessage("Aguarde...");
			progressDialog.setCancelable(false);
			progressDialog.show();
		}
		
		@Override
		protected Void doInBackground(Void... arg0){
			
			AutuacaoREST autuacaoREST = new AutuacaoREST();
			
			try {
				resposta = autuacaoREST.inserirAutuacao(autuacao);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			if (progressDialog.isShowing())
					progressDialog.dismiss();
			
			final TextView textMessage = (TextView) findViewById(R.id.textView12);
			textMessage.setText(resposta);
		}
	}
	
	public void onBackToMenuButtonCadastreClick(View v) {
		Intent i = new Intent();
		i.setClass(this, Menu.class);
		startActivity(i);
	}
	
	public void goToInquiryClick(View v) {
		Intent i = new Intent();
		i.setClass(this, Inquiry.class);
		startActivity(i);
	}
	
}