package com.tcc.model;

import java.io.Serializable;

public class Autuacao implements Serializable{
	
	private String orgaoAutuador;
	private String placa;
	private String marca;
	private String modelo;
	private String ano;
	private String autuacao;
	private String proprietario;
	private String data;
	private String hora;
	
	
	public String getOrgaoAutuador() {
		return orgaoAutuador;
	}
	public void setOrgaoAutuador(String orgaoAutuador) {
		this.orgaoAutuador = orgaoAutuador;
	}
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	public String getAutuacao() {
		return autuacao;
	}
	public void setAutuacao(String autuacao) {
		this.autuacao = autuacao;
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
	
	@Override
	public String toString() {
		return "\nOrgao Autuador: " + this.orgaoAutuador +
				"\nPlaca: " + this.placa +
				"\nMarca: " + this.marca +
				"\nModelo: " + this.modelo +
				"\nAno: " + this.ano +
				"\nAutuacao: " + this.autuacao +
				"\nProprietario: " + this.proprietario +
				"\nData da Autuacao: " + this.data +
				"\nHora da Autuacao: " + this.hora;
	}
	
}
