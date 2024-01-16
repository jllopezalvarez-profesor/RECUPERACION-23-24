package es.jllopezalvarez.programacion.ut09.ejercicios;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce un texto.");
		String texto = scanner.nextLine();

		int posicion = -1;
		do {
			System.out.printf("¿Qué posición quieres consultar? (de 1 a %d, 0 para terminar): ", texto.length());

			try {
				posicion = Integer.parseInt(scanner.nextLine());

				if (posicion != 0) {
					System.out.printf("El caracter en la posicion %d es %s\n", posicion, texto.charAt(posicion - 1));
				}
			} catch (NumberFormatException e) {
				System.out.println("El valor introducido no es un número.");
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("El valor introducido está fuera de los límites.");
			}
		} while (posicion != 0);

		scanner.close();
	}

}
