package com.tcc.webservice;

import java.util.ArrayList;
import java.util.List;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.tcc.model.Autuacao;

public class AutuacaoREST {
	
	private static final String URL_WS = "http://192.168.1.104:8080/A2VMWebservice/autuacao/";
	
	private Handler handler;
	Message msg = new Message();
	
	public AutuacaoREST() {
		
	}
	
	public AutuacaoREST(Handler handler) {
		this.handler = handler;
	}
	
	public Autuacao getAutuacao (String placa) throws Exception {
		
		String[] resposta = new WebServiceAutuacaoGet().doInBackground(URL_WS + placa);
		
		if (resposta[0].equals("200")) {
			Gson gson = new Gson();
			Autuacao autuacao = gson.fromJson(resposta[1], Autuacao.class);
			return autuacao;
		}
		else {
			msg.what = 1;
			msg.obj = resposta[1];
			handler.sendMessage(msg);
		
			throw new Exception(resposta[1]);
		}
	}
	
	public List<Autuacao> getListaAutuacoes() throws Exception {
		
		String[] resposta = new WebServiceAutuacaoGet().doInBackground(URL_WS + "buscarTodosGSON");
		
		if (resposta[0].equals("200")) {
			Gson gson = new Gson();
			ArrayList<Autuacao> listaAutuacao = new ArrayList<Autuacao>();
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(resposta[1]).getAsJsonArray();
			
			for (int i = 0; i < array.size(); i++) {
				listaAutuacao.add(gson.fromJson(array.get(i), Autuacao.class));
			}
			return listaAutuacao;
		} else {
			throw new Exception(resposta[1]);
		}
	}
	
	public String inserirAutuacao(Autuacao autuacao) throws Exception {
		
		Gson gson = new Gson();
		String autuacaoJSON = gson.toJson(autuacao);
		
		String[] resposta = new WebServiceAutuacaoPost().doInBackground(URL_WS + "inserir", autuacaoJSON);
		
		if (resposta[0].equals("200")) {
			return resposta[1];
		} else {
			throw new Exception(resposta[1]);
		}
	}
	
}
