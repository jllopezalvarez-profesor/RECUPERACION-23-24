package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.Scanner;

public class Ejemplo07ValidarEntradaUsuario {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numero = 0;
		boolean ok = false;

		System.out.println("Introduzca un número entero.");

		while (!ok) {
			try {
				numero = Integer.parseInt(scanner.nextLine());
				// Si hemos llegado aquí es que no hay error.
				ok = true;
			} catch (NumberFormatException e) {
				// Mensaje indicando que no está bien la entrada
				System.out.println("El valor introducido no es un número válido.");
				System.out.println("Introduzca un número entero.");
			}
		}
		
		System.out.printf("El número introducido es %d.\n", numero);

		scanner.close();
	}
}
