package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio23;

public class Programa {

	private static ByDurezaMaderaComparator comparador = new ByDurezaMaderaComparator();

	public static void main(String[] args) {

		Madera[] maderas = new Madera[10];

		for (int i = 0; i < maderas.length; i++) {
			maderas[i] = Madera.generaMaderaAleatoria();
		}

		mostrarMaderas(maderas);

		System.out.println("-".repeat(30));

		compararTodasMaderas(maderas);

	}

	private static void mostrarMaderas(Madera[] maderas) {

		for (Madera madera : maderas) {
			System.out.printf("Madera: %s - Nombre: %s - Dureza: %s\n Características: %s\n\n", madera,
					madera.getNombre(), madera.getDureza(), madera.getCaracteristicas());
		}
	}

	private static void compararMaderas(Madera madera1, Madera madera2) {
		System.out.printf("Comparando %s con %s.\n", madera1.getNombre(), madera2.getNombre());
		int comparacion = comparador.compare(madera1, madera2);
		if (comparacion > 0) {
			System.out.printf("%s es más dura que %s.\n", madera1.getNombre(), madera2.getNombre());
		} else if (comparacion < 0) {
			System.out.printf("%s es más blanda que %s.\n", madera1.getNombre(), madera2.getNombre());
		} else {
			System.out.printf("%s es igual de dura que %s.\n", madera1.getNombre(), madera2.getNombre());
		}
		System.out.println();
	}

	private static void compararTodasMaderas(Madera[] maderas) {
		for (int i = 0; i < maderas.length - 1; i++) {
			compararMaderas(maderas[i], maderas[i + 1]);
		}
	}

}
