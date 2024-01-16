package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos02finally;

import java.util.Scanner;

public class Ejemplo05FinallyCierreScanner {

	public static void main(String[] args) {

		// Definimos el Scanner fuera del try, y damos valor null. Si no damos valor,
		// habría errores al intentar usarlo en el finally, porque no estaría
		// inicializado.
		Scanner scanner = null;
		try {
			// Ya dentro del try, instanciamos el Scanner. Esto puede fallar, y la variable
			// scanner seguiría siendo null.
			scanner = new Scanner(System.in);

			System.out.println("Introduce un número entero");

			// Esto puede fallar con distintas excepciones.
			int numero = scanner.nextInt();

			System.out.printf("Número leído: %d\n", numero);

		} finally {
			// Si el scanner es distinto de null, es que se ha conseguido abrir sin
			// problemas, hay que cerrarlo.
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
