package com.tcc.model;

import java.io.Serializable;

public class Autuacao implements Serializable{
	
	private int id;
	private int idOrgaoAutuador;
	private String placa;
	private int idMarca;
	private int idModelo;
	private int ano;
	private String proprietario;
	private String data;
	private String hora;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdOrgaoAutuador() {
		return idOrgaoAutuador;
	}
	public void setIdOrgaoAutuador(int idOrgaoAutuador) {
		this.idOrgaoAutuador = idOrgaoAutuador;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public int getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

}
