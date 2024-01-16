package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

public class Ejemplo10CatchVacio {
	public static void main(String[] args) {
		System.out.println("Entrando en main");
		try {
			int i = Integer.parseInt("Hola");
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Saliendo de main");
	}
}
