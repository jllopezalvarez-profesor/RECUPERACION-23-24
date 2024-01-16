package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio19;

import java.util.Comparator;

public class ByPropietarioNameComparator implements Comparator<Instrumento> {

	@Override
	public int compare(Instrumento instrumento1, Instrumento instrumento2) {
		return instrumento1.getPropietario().compareTo(instrumento2.getPropietario());
	}

}
