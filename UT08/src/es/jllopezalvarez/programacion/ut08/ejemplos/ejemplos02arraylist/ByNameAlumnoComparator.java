package es.jllopezalvarez.programacion.ut08.ejemplos.ejemplos02arraylist;

import java.util.Comparator;

public class ByNameAlumnoComparator implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
//		if (o1 == null && o2 == null)
//			return 0;
//		if (o1 == null) return -1;
//		if (o2 == null) return 1;

		return o1.getNombre().compareTo(o2.getNombre());
	}

}
