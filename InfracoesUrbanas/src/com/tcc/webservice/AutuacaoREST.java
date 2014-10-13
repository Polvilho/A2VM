package com.tcc.webservice;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.tcc.model.Autuacao;

public class AutuacaoREST {
	
	private static final String URL_WS = "http://192.168.1.106:8080/A2VMWebservice/autuacao/";
	
	public Autuacao getAutuacao (String placa) throws Exception {
		
		String[] resposta = new WebServiceAutuacao().get(URL_WS + placa);
		
		if (resposta[0].equals("200")) {
			Gson gson = new Gson();
			Autuacao autuacao = gson.fromJson(resposta[1], Autuacao.class);
			return autuacao;
		}
		else {
			throw new Exception(resposta[1]);
		}
	}
	
	public List<Autuacao> getListaAutuacoes() throws Exception {
		
		String[] resposta = new WebServiceAutuacao().get(URL_WS + "buscarTodosGSON");
		
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
		
		String[] resposta = new WebServiceAutuacao().post(URL_WS + "inserir", autuacaoJSON);
		
		if (resposta[0].equals("200")) {
			return resposta[1];
		} else {
			throw new Exception(resposta[1]);
		}
	}
	
}
