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
	
	protected EditText editTextPlaca;
	private String placa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inquiry);
        
        Intent i = getIntent();
        placa = i.getStringExtra("recognizedBoard");
        
        editTextPlaca = (EditText) findViewById(R.id.boardTextInquiry);
        
        //final EditText editTextPlaca = (EditText) findViewById(R.id.boardTextInquiry);
    	final EditText editTextAutuacao = (EditText) findViewById(R.id.autuationTextInquiry);
    	final EditText editTextMarca = (EditText) findViewById(R.id.companyTextInquiry);
    	final EditText editTextModelo = (EditText) findViewById(R.id.modelTextInquiry);
    	final EditText editTextAno = (EditText) findViewById(R.id.yearTextInquiry);
    	final EditText editTextCor = (EditText) findViewById(R.id.colorTextInquiry);
    	final EditText editTextEstado = (EditText) findViewById(R.id.stateTextInquiry);
    	final EditText editTextMunicipio = (EditText) findViewById(R.id.cityTextInquiry);
    	final EditText editTextProprietario = (EditText) findViewById(R.id.textNameInquiry);
    	final EditText editTextData = (EditText) findViewById(R.id.textDateInquiry);
    	final EditText editTextHora = (EditText) findViewById(R.id.textHourInquiry);
    	Button buttonConsultar = (Button) findViewById(R.id.consultButton);
    	
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
					editTextCor.setText(autuacao.getCor().toString());
					editTextEstado.setText(autuacao.getEstado().toString());
					editTextMunicipio.setText(autuacao.getMunicipio().toString());
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
	
	public void goToCadastreClick(View v) {
		Intent i = new Intent();
		i.setClass(this, Cadastre.class);
		i.putExtra("recognizedBoard", editTextPlaca.getText().toString());
		startActivity(i);
	}

}
