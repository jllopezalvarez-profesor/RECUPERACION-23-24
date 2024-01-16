package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos02finally;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejemplo01Finally {
	public static void main(String[] args) {

		// Creamos el scanner
		Scanner scanner = new Scanner("Esta es la cadena que vamos a procesar");
		try {
			// Esta sentencia puede lanzar distintas excepciones
			// Con el valor que se inicializa el scanner, lanzará una del tipo
			// InputMismatchException, porque "Esta" no se puede convertir a entero.
			int numero = scanner.nextInt();
			System.out.println("El número introducido es " + numero);
		} catch (InputMismatchException e) {
			System.out.println("El valor introducido no es un número.");
		} catch (NoSuchElementException e) {
			System.out.println("No queda nada por leer del scanner.");
		} finally {
			// Este código se ejecuta SIEMPRE que se haya llegado al try.
			// Cerramos el scanner si es != null
			System.out.println("Dentro del finally.");
			if (scanner != null)
				scanner.close();
		}
	}
}
