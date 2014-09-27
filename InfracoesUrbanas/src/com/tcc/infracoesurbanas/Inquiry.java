package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tcc.model.Autuacao;
import com.tcc.webservice.AutuacaoREST;

public class Inquiry extends Activity{
	
	private String placa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inquiry);
        
        Intent i = getIntent();
        placa = i.getStringExtra("recognizedBoard");
        
        final EditText editTextPlaca = (EditText) findViewById(R.id.boardTextInquiry);
    	final EditText editTextAutuacao = (EditText) findViewById(R.id.autuationTextInquiry);
    	final EditText editTextMarca = (EditText) findViewById(R.id.companyTextInquiry);
    	final EditText editTextModelo = (EditText) findViewById(R.id.modelTextInquiry);
    	final EditText editTextAno = (EditText) findViewById(R.id.yearTextInquiry);
    	final EditText editTextOrgaoAutuador = (EditText) findViewById(R.id.orgaoTextInquiry);
    	final EditText editTextProprietario = (EditText) findViewById(R.id.textNameInquiry);
    	final EditText editTextData = (EditText) findViewById(R.id.textDateInquiry);
    	final EditText editTextHora = (EditText) findViewById(R.id.textHourInquiry);
    	Button buttonConsultar = (Button) findViewById(R.id.consultButton);
    	//Button buttonCapturar = (Button) findViewById(R.id.captureButton);
    	
    	editTextPlaca.setText(placa);
    	
    	buttonConsultar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				placa = editTextPlaca.getText().toString();
				AutuacaoREST autuacaoREST = new AutuacaoREST();
				
				try {
					Autuacao autuacao = autuacaoREST.getAutuacao(placa);
					editTextAutuacao.setText(autuacao.getAutuacao().toString());
					editTextMarca.setText(autuacao.getMarca().toString());
					editTextModelo.setText(autuacao.getModelo().toString());
					editTextAno.setText(autuacao.getAno().toString());
					editTextOrgaoAutuador.setText(autuacao.getOrgaoAutuador().toString());
					editTextProprietario.setText(autuacao.getProprietario().toString());
					editTextData.setText(autuacao.getData().toString());
					editTextHora.setText(autuacao.getHora().toString());
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					gerarToast("Digitar uma placa valida !");
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
	
	public void onBackToMenuButtonInquiryClick(View v) {
		Intent i = new Intent();
		i.setClass(this, Menu.class);
		startActivity(i);
	}
	
	public void onCaptureButtonInquiryClick(View v) {
		Intent i = new Intent();
		i.setClass(this, SimpleAndroidOCRActivity.class);
		startActivity(i);
	}
	
}
