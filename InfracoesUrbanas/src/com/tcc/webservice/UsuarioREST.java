package com.tcc.webservice;

import com.google.gson.Gson;
import com.tcc.model.Usuario;

public class UsuarioREST {
	
	private static final String URL_WS = "http://192.168.1.106:8080/A2VMWebservice/usuario/";
	
	public Usuario getUsuario (String user) throws Exception {
		
		String[] resposta = new WebServiceUsuario().get(URL_WS + user);
		
		if (resposta[0].equals("200")) {
			Gson gson = new Gson();
			Usuario usuario = gson.fromJson(resposta[1], Usuario.class);
			return usuario;
		}
		else {
			throw new Exception(resposta[1]);
		}
		
	}

}
