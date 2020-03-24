package it.polito.tdp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Memorizza e gestisce un insieme di voti superati
 * @author claud
 *
 */
public class Libretto {

	private List <Voto> voti = new ArrayList<>();

	
	/**
	 * Crea un libretto nuovo (e vuoto)
	 */
	public Libretto() {
		super();
	}
	
	/**
	 * Copy Constructor
	 * "Shallow" (copia superficiale)
	 * @param lib
	 */
	public Libretto(Libretto lib) {
		super();
		this.voti.addAll(lib.voti);
	}
	
	/**
	 * Aggiunge un nuovo voto al libretto, evitando le 
	 * aggiunte duplicate
	 * @param v
	 * @return {@code true} se ha inserito il voto, {@code false} se non l'ha inserito perhè era
	 * in conflitto oppure era duplicato
	 */
	public boolean add(Voto v) {
		if(this.isConflitto(v) || this.isDuplicato(v))
			//non inserire il voto
			return false; //segnala in chiamante che non ha avuto successo
		else {
			//inserisci il voto perchè non è in conflitto ne' duplicato
			this.voti.add(v);
			return true;
		}
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


	/** 
	 * Dato il nome di un corso,
	 * verifica se esiste nel libretto, ed in 
	 * caso affermativo restituisce l'oggetto {@link Voto}
	 * corrispondente, altrimenti restituisce null
	 * 
	 * @param nomeCorso nome esame da cercare
	 * @return {@link Voto} corrispondente oppure null
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		/*for(Voto v : this.voti) {
			if(v.getCorso().equals(nomeCorso))
				return v;
		}
		return null;
		*/
		
		/**
		 * ho creato un oggetto di tipo voto di cui
		 * conosco solo il NOME, poichè voto e data 
		 * vengono lasciate null
		 * Il metodo indexOf va a verificare all'interno del 
		 * libretto qual è l'oggetto voto che soddisfa il metodo
		 * equals con il voto che gli passo d parametro
		 */
		int pos = this.voti.indexOf(new Voto(nomeCorso, 0, null));
		if (pos != -1) {
			return this.voti.get(pos);
		} else
			return null;
		
		//indexof quando va a cercare un Voto, per confrontarne due uguali:
		//dobbiamo specificare in Voto un metodo equals apposito solo per il nome del Corso
				
	}
		
		/**
		 * Ritorna {@code true} se il voto {@code v} esiste nel libretto,
		 * con la stessa valutazione.
		 * Se non esiste, o se la valutazione è diversa, ritorna {@code false}
		 * @param v il {@link Voto} da ricercare
		 * @return l'esistenza di un duplicato
		 */
		public boolean isDuplicato (Voto v) {
			Voto esiste = this.cercaNomeCorso(v.getCorso());
			if (esiste == null) //non esiste => non è duplicato
				return false;
			
			/*if(esiste.getVoto()==v.getVoto())
				return true;
			else
				return false;
			*/
			
			return (esiste.getVoto() == v.getVoto());
		}
	
	public boolean isConflitto (Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if (esiste == null) //non esiste => non è duplicato
			return false;
		
		return (esiste.getVoto() != v.getVoto());
	}
	
	/**
	 * Restituisce un NUOVO libretto, migliorando
	 * i voti del libretto attuale.
	 * @return
	 */
	public Libretto creaLibrettoMigliorato () {
		Libretto nuovo = new Libretto();
		
		for (Voto v : this.voti) {
//			Voto v2 = new Voto (v);
			Voto v2 = v.clone();
			// NON CI PIACE Voto v3 = new Voto(v.getCorso(), v.getVoto(), v.getData());
			
			if(v2.getVoto() >= 24) {
				v2.setVoto(v2.getVoto()+2);
				if(v2.getVoto() > 30)
					v2.setVoto(30);
			}
			else if (v2.getVoto() >= 18) {
				v2.setVoto(v2.getVoto()+1);
			}
			nuovo.add(v2);
		}
		return nuovo;
	}
	
	
	/**
	 * riordina i voti presenti
	 * nel libretto corrente alfabeticamente per corso
	 */
	public void ordinaPerCorso() {
		Collections.sort(this.voti);
	}
	
	public void ordinaPerVoto() {
		Collections.sort(this.voti, new ConfrontaVotiPerValutazione());;
	}
	
	
	/**
	 * Elimina dal libretto tutti i voti <24
	 */
	public void cancellaVotiScarsi () {
		List<Voto> daRimuovere = new ArrayList<>();
	
		for (Voto v : this.voti) {
			if(v.getVoto()<24)
				daRimuovere.add(v);
		}
		this.voti.removeAll(daRimuovere);
		
//		for(Voto v : daRimuovere) {
//			this.voti.remove(v);
//		}
	}
}
