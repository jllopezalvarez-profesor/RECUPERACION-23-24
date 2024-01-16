package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.Scanner;

public class Ejemplo09ValidarEntradaUsuario3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numero1 = pedirEnteroPositivo(scanner);
		int numero2 = pedirEnteroPositivo(scanner);
		int numero3 = pedirEnteroPositivo(scanner);

		System.out.printf("Los números introducidos son %d - %d - %d.\n", numero1, numero2, numero3);

		scanner.close();
	}

	private static int pedirEnteroPositivo(Scanner scanner) {

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
		return numero;
	}

}
