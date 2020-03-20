package it.polito.tdp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Memorizza e gestisce un insieme di voti superati
 * @author claud
 *
 */
public class Libretto {

	private List <Voto> voti = new ArrayList<>();

	/**
	 * Aggiunge un nuovo voto al libretto
	 * @param v
	 */
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	public void add(String corso, int voto, LocalDate data) {
		// dipendeza tra libretto e voto
	}
	
	/**
	 * Dato un libretto, restituisce una stringa in cui ci sono solo i voti
	 * pari al valore specificato
	 * @param voto valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali (int voto) {
		String s = "";
		for(Voto v : this.voti) {
			if(v.getVoto() == voto)
				s += v.toString() + "\n";
		}
		return s;
	}
	
	//OPPURE
	
	/**
	 * Genera un nuovo libretto a partire da quello esistente,
	 * che conterrà esclusivamente i voti con votazione
	 * pari a quella specificata
	 * 
	 * @param voto pari a quello passato da parametro
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for (Voto v : this.voti) {
			if (v.getVoto() == voto) 
				nuovo.add(v);
		}
		return nuovo;
	}
	
	public String toString() {
		String s ="";
		for(Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		
		return s;
	}
	
	
}
