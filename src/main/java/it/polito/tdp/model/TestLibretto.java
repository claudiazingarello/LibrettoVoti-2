package it.polito.tdp.model;

import java.time.LocalDate;

public class TestLibretto {
	
	Libretto lib;
	
	private void run() {
		//Creo dei voti e li metto nel libretto
		this.lib = new Libretto();
		
		Voto v1 = new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("Analisi II", 28, LocalDate.of(2020, 06, 28));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib);
		
		System.out.println(this.lib.stampaVotiUguali(28)); //e' solo una stampa, si perde subito dopo
		System.out.println(this.lib.estraiVotiUguali(30));
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

