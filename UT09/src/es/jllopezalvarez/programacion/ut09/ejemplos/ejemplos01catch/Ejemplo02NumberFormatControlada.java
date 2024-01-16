package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.Scanner;

public class Ejemplo02NumberFormatControlada {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Pedimos un número al usuario
		System.out.println("Introduce un número entero. ");
		System.out.println("Si se introduce algo que no pueda convertirse a número se mostrará un mensaje.");

		// Leemos el número, usando nextLine()
		// Convertimos el número. Si la cadena introducida no puede convertirse a
		// entero, se produce un error, pero esta vez:
		// - Estamos ejecutando la conversión dentro de un bloque try.
		// - Si se produce la excepción, el programa salta al bloque "catch".
		String cadena = scanner.nextLine();
		int numero;
		try {
			numero = Integer.parseInt(cadena);
			// Mostramos el número en pantalla. Esto no se llega a ejecutar si se produce un
			// error (excepción) en la conversión, porque se salta al bloque catch.
			System.out.printf("Número convertido: %d\n", numero);
		} catch (NumberFormatException e) {
			System.out.printf("El valor introducido (%s) no se puede convertir a número entero.\n", cadena);
			// Para mostrar los detalles del error, como si no se hubiera controlado
			// e.printStackTrace();
		}

		scanner.close();
	}
}
