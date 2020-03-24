package it.polito.tdp.model;

import java.util.Comparator;

class ConfrontaVotiPerValutazione implements Comparator<Voto> {

	@Override
	public int compare(Voto o1, Voto o2) {
		//ordine decrescente di voto
		return o2.getVoto() - o1.getVoto();
	}

}
