package it.polito.tdp.model;

import java.time.LocalDate;

public class Voto {
	
	private String corso ; // " Tecniche di Programmazione " 
	private int voto ;     // 28
	private LocalDate data;	   // 15/06/2020
	public Voto(String corso, int voto, LocalDate data) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}
	
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	
	public String toString() {
		return corso + ": " + voto + " (" + data + ")";
	}
	
	
	

}
