package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos02finally;

import java.util.Scanner;

public class Ejemplo04ReturnEnFinally {

	public static void main(String[] args) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);

			System.out.println("Introduce un número entero");
			
			String datosLeidos = scanner.nextLine();

			System.out.printf("Número leído: %d\n", convertirAEntero(datosLeidos));

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private static int convertirAEntero(String numeroComoCadena) {
		try {
			System.out.println("Vamos a intentar convertir el número");
			int numero = Integer.parseInt(numeroComoCadena);
			return numero;
		} catch (NumberFormatException e) {
			System.out.println("Estamos en el catch, pero no hacemos nada,");
			System.out.println("porque devolvemos el valor por defecto en finally.");
		} finally {
			// Error: devolver algo en finally. Si hacemos esto, siempre se devolverá este
			// valor. Java nos avisa con un warning
			return 100;
		}
	}

}
