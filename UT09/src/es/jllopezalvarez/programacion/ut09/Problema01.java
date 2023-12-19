package es.jllopezalvarez.programacion.ut09;

import java.util.Scanner;

public class Problema01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce una frase.");
		String cadenaUsuario = scanner.nextLine();

		int posicion = -1;
		do {

			try {
				/// Lo que puede fallar

				System.out.println("Introduce una posición de la cadena: ");
				posicion = Integer.parseInt(scanner.nextLine());
				if (posicion != 0) {
					System.out.printf("El caracter en la posición %d es '%s'.\n", posicion,
							cadenaUsuario.charAt(posicion - 1));
				}

			} catch (NumberFormatException ex) {
				System.out.println("El valor introducido no es un número entero. Vuelve a intentarlo.");
			} catch (StringIndexOutOfBoundsException ex) {
				System.out.printf("El valor introducido se sale del rango admisible. Tiene que estar entre %d y %d.\n",
						1, cadenaUsuario.length());
			} catch (Exception ex) {
				System.out.println("Se ha producido un error desconocido.");
			}
		} while (posicion != 0);
	}

}
