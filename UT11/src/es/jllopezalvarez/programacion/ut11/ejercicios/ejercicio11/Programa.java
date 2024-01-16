package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio11;

public class Programa {
	public static void main(String[] args) {

		Agricultor a1 = new Agricultor("Juan", "pimientos");
		Agricultor a2 = new Agricultor("María", "lechugas");

		for (int i = 0; i < 10; i++) {
			System.out.println(Agricultor.getCantidadTotalProducida());
			a1.recolectar();
			a2.recolectar();
		}
		System.out.println(Agricultor.getCantidadTotalProducida());

		Agricultor.getCantidadTotalProducida();
	}

}
