package com.tcc.infracoesurbanas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tcc.model.Autuacao;
import com.tcc.webservice.AutuacaoREST;

public class Inquiry extends Activity {

	private ProgressDialog progressDialog;

	protected EditText editTextPlaca;
	private String placa;
	private boolean sucesso;

	private String autuacaoConsultada;
	private String marcaConsultada;
	private String modeloConsultado;
	private String anoConsultado;
	private String corConsultada;
	private String proprietarioConsultado;
	private String municipioConsultado;
	private String estadoConsultado;
	private String dataConsultada;
	private String horaConsultada;
	
	Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inquiry);

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				updateUI(msg);
			}
		};

		Intent i = getIntent();
		placa = i.getStringExtra("recognizedBoard");

		editTextPlaca = (EditText) findViewById(R.id.boardTextInquiry);

		// final EditText editTextPlaca = (EditText)
		// findViewById(R.id.boardTextInquiry);
		Button buttonConsultar = (Button) findViewById(R.id.consultButton);

		editTextPlaca.setText(placa);

		buttonConsultar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				placa = editTextPlaca.getText().toString();
				new GetAutuacao().execute();
			}
		});

	}

	private class GetAutuacao extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			progressDialog = new ProgressDialog(Inquiry.this);
			progressDialog.setMessage("Aguarde...");
			progressDialog.setCancelable(false);
			progressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... arg0) {

			AutuacaoREST autuacaoREST = new AutuacaoREST(handler);

			try {
				Autuacao autuacao = autuacaoREST.getAutuacao(placa);

				autuacaoConsultada = autuacao.getAutuacao().toString();
				marcaConsultada = autuacao.getMarca().toString();
				modeloConsultado = autuacao.getModelo().toString();
				anoConsultado = autuacao.getAno().toString();
				corConsultada = autuacao.getCor().toString();
				estadoConsultado = autuacao.getEstado().toString();
				municipioConsultado = autuacao.getMunicipio().toString();
				proprietarioConsultado = autuacao.getProprietario().toString();
				dataConsultada = autuacao.getData().toString();
				horaConsultada = autuacao.getHora().toString();
				
				sucesso = true;
				
			} catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace();
			} catch (Exception e) {
				sucesso = false;
				e.printStackTrace();
				e.getMessage();
			}
			return null;

		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			if (progressDialog.isShowing())
				progressDialog.dismiss();

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
			
			editTextAutuacao.setEnabled(false);
			editTextEstado.setEnabled(false);
			editTextMunicipio.setEnabled(false);
			editTextMarca.setEnabled(false);
			editTextModelo.setEnabled(false);
			editTextAno.setEnabled(false);
			editTextCor.setEnabled(false);
			editTextProprietario.setEnabled(false);
			editTextData.setEnabled(false);
			editTextHora.setEnabled(false);
			
			if (sucesso == true) {
				editTextAutuacao.setText(autuacaoConsultada);
				editTextEstado.setText(estadoConsultado);
				editTextMunicipio.setText(municipioConsultado);
				editTextMarca.setText(marcaConsultada);
				editTextModelo.setText(modeloConsultado);
				editTextAno.setText(anoConsultado);
				editTextCor.setText(corConsultada);
				editTextProprietario.setText(proprietarioConsultado);
				editTextData.setText(dataConsultada);
				editTextHora.setText(horaConsultada);
			}
			else {
				editTextAutuacao.setText("");
				editTextEstado.setText("");
				editTextMunicipio.setText("");
				editTextMarca.setText("");
				editTextModelo.setText("");
				editTextAno.setText("");
				editTextCor.setText("");
				editTextProprietario.setText("");
				editTextData.setText("");
				editTextHora.setText("");
			}

		}

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

	private void updateUI(Message msg) {
		if (msg.what == 1) {
			String result = (String) msg.obj;
			Toast.makeText(Inquiry.this, result, Toast.LENGTH_LONG).show();
		}
	}

}
