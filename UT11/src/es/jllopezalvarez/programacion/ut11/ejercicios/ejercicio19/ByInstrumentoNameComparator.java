package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio19;

import java.util.Comparator;

public class ByInstrumentoNameComparator implements Comparator<Instrumento> {

	@Override
	public int compare(Instrumento instrumento1, Instrumento instrumento2) {
		String nombreInstrumento1 = instrumento1.getClass().getSimpleName();
		String nombreInstrumento2 = instrumento2.getClass().getSimpleName();
		return nombreInstrumento1.compareTo(nombreInstrumento2);
	}

}
