package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio23;

import java.util.Comparator;

public class ByDurezaMaderaComparator implements Comparator<Madera> {
	@Override
	public int compare(Madera madera1, Madera madera2) {
		return Double.compare(madera1.getDureza(), madera2.getDureza());
	}
}
