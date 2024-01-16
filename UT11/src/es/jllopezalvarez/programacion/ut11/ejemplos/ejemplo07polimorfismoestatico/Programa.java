package es.jllopezalvarez.programacion.ut11.ejemplos.ejemplo07polimorfismoestatico;

public class Programa {
	public static void main(String[] args) {

		EjemploSobrecarga es = new EjemploSobrecarga();
		
		es.metodo();
		es.metodo(4);
		es.metodo("hola");
	}

}
