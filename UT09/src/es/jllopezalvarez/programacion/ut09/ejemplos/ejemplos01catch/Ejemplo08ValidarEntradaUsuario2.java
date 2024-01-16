package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.Scanner;

public class Ejemplo08ValidarEntradaUsuario2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numero = 0;
		boolean ok = false;

		System.out.println("Introduzca un número entero mayor o igual que cero.");

		while (!ok) {
			try {
				numero = Integer.parseInt(scanner.nextLine());
				// Si hemos llegado aquí es que no hay error, pero el usuario puede haber
				// introducido un número negativo.
				if (numero < 0) {
					System.out.println("El valor introducido no es válido porque es negativo.");
					System.out.println("Introduzca un número entero mayor o igual que cero.");
				} else {
					ok = true;
				}
			} catch (NumberFormatException e) {
				// Mensaje indicando que no está bien la entrada
				System.out.println("El valor introducido no es un número válido.");
				System.out.println("Introduzca un número entero mayor o igual que cero.");
			}
		}

		System.out.printf("El número introducido es %d.\n", numero);

		scanner.close();
	}
}
