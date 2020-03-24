package it.polito.tdp.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		//1. Creo dei voti e li metto nel libretto
		this.lib = new Libretto();
		
		//Inserire alcuni voti
		Voto v1 = new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib);
		
		//2. Stampa tutti i voti uguali a 28
		System.out.println(this.lib.stampaVotiUguali(28)); //e' solo una stampa, si perde subito dopo
		System.out.println(this.lib.estraiVotiUguali(28));
		
		
		//3. Carca un esame superato, conoscendo il nome del corso 
		String nomeCorso = "Analisi II";
		
			// int voto = lib.cercaNomeCorso(nomeCorso); // 28
		
			//Conviene restituire direttamente l'oggetto voto
			Voto votoAnalisi = lib.cercaNomeCorso(nomeCorso);
			System.out.println("Il voto di "+nomeCorso + " è "+votoAnalisi.getVoto());
			
			Voto votoMancante = lib.cercaNomeCorso("Fisica I");
			System.out.println("Il voto di Fisica I è "+ votoMancante) ;
			
			//4. Verificare se la valutazione di un nuovo oggetto Voto
			//	 esiste già nel libretto (stesso esame con stesso voto)
			
			//5. Vedere se c'è conflitto
			
			Voto economia2 = new Voto ("Economia", 24, LocalDate.now());
			Voto economia3 = new Voto ("Economia", 21, LocalDate.now());
			
			System.out.println("Economia con 24 è duplicato:" + lib.isDuplicato(economia2)+ "/ conflitto:"+ lib.isConflitto(economia2));
			System.out.println("Economia con 21 è duplicato:" + lib.isDuplicato(economia3)+ "/ conflitto:"+ lib.isConflitto(economia3));
			
			// 6. Migliora il libretto
			
			Libretto migliorato = lib.creaLibrettoMigliorato();
			System.out.println("Miglioramento del libretto");
			System.out.println(lib);
			System.out.println(migliorato);
			
			// 7. Stampa in ordine alfabetico
			Libretto alfabetico = new Libretto (lib);
			alfabetico.ordinaPerCorso();
			System.out.println(alfabetico);
			
			// 7. Stampa in ordine di voto
			Libretto votidecrescenti = new Libretto (lib);
			votidecrescenti.ordinaPerVoto();
			System.out.println(votidecrescenti);
			
			// 8. Elimina voti
			
			lib.add(new Voto("Chimica", 19, LocalDate.now()));
			System.out.println(lib);
			lib.ordinaPerCorso();
			lib.cancellaVotiScarsi();
			System.out.println(lib);
	}
	
	
	/** 
	 * non si lavora dentro il main, ma sul metodo di un oggetto creato
	 * @param args
	 */

	public static void main(String[] args) {
		TestLibretto test = new TestLibretto();
		test.run();
		}
	}

