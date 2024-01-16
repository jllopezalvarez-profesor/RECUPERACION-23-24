package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio21;

import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio21.figuras.Imagen;

public class Programa {

	public static void main(String[] args) {
		Imagen imagen = new Imagen(3,3);
		System.out.println(imagen);
		imagen.escalar(2);
		System.out.println(imagen);
	}
}
