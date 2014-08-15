package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;




public class Cadastre extends Activity{
	
	private String id;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastre);
	}
	
	EditText editTextIDInfracao = (EditText) findViewById(R.id.infractionNumberText);
	EditText editTextPlaca = (EditText) findViewById(R.id.boardEditTextCadastre);
	EditText editTextName = (EditText) findViewById(R.id.textName);
	EditText editTextData = (EditText) findViewById(R.id.TextDate);
	EditText editTextHora = (EditText) findViewById(R.id.TextHour);
	Spinner spinnerOrgao = (Spinner) findViewById(R.id.orgaoSpinner);
	Spinner spinnerMarca = (Spinner) findViewById(R.id.companySpinner);
	Spinner spinnerAno = (Spinner) findViewById(R.id.yearSpinner);
	Button buttonCadastrar = (Button) findViewById(R.id.cadastreButton);
	Button buttonLimpar = (Button) findViewById(R.id.cleanButton);
	Button buttonCapturar = (Button) findViewById(R.id.captureButton);
	Button buttonBackToMenu = (Button) findViewById(R.id.buttonBackToMenu);
	
	
	
}
