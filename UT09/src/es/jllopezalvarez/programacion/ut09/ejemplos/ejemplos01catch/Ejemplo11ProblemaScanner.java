package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * Demostración de por qué es en generar mejor usar Integer.tryParse junto a
 * Scanner.nextLine() que usar sólo Scanner.nextInt() cuando se está controlando
 * la entrada de usuario en un try/catch. Esto aplica también a otros tipos
 * numéricos, como double. En general cualquier método de Scanner que tenga que
 * convertir a otro tipo y esta conversión pueda fallar.
 *
 */
public class Ejemplo11ProblemaScanner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		//demoIntegerParseInt(scanner);

		demoScannerNextInt(scanner);

		scanner.close();
	}

	/**
	 * Método para demostrar el funcionamiento de try/catch al usar Integer.parseInt
	 * y Scanner.nextLine()
	 * 
	 * @param scanner scanner ya abierto que se usa para interactuar con el usuario
	 */
	private static void demoIntegerParseInt(Scanner scanner) {
		System.out.println("Probando Integer.parseInt(Scanner.nextLine()).");
		
		int numero = 0;
		boolean ok = false;

		do {
			System.out.print("Introduce un número entero: ");
			try {
				// Leemos una línea y la convertimos a entero.
				// La conversión puede fallar. Si lo hace salta al bloque catch.
				// Como hacemos un nextLine, el retorno de carro y salto de línea (\n) se
				// consume, no se queda en el buffer del Scanner.
				numero = Integer.parseInt(scanner.nextLine());
				// Si llegamos a este punto es que la conversión ha ido bien.
				// Cambiamos el valor de ok para que salgamos del bucle.
				ok = true;
			} catch (NumberFormatException e) {
				// La conversión ha fallado. Mostramos mensaje de error.
				System.out.println("El valor introducido no se puede convertir a un número entero.");
			}
		} while (!ok);

		System.out.printf("El número introducido es %d.\n\n\n", numero);
	}

	/**
	 * Método para demostrar el funcionamiento de try/catch al usar
	 * Scanner.nextInt()
	 * 
	 * @param scanner scanner ya abierto que se usa para interactuar con el usuario
	 */
	private static void demoScannerNextInt(Scanner scanner) {
		System.out.println("Probando Scanner.nextInt().");
				
		int cantidadFallos = 0;
		int numero = 0;
		boolean ok = false;

		do {
			System.out.print("Introduce un número entero: ");
			try {
				// Usamos directamente Scanner.nextInt() para leer un número entero.
				// En este caso pueden fallar tres cosas: que el valor introducido no se pueda
				// convertir, que no quede nada por leer en el scanner, o que el scanner esté
				// cerrado. Lo que nos interesa es el fallo en conversión.
				// Como hacemos un nextInt, independientemente de que falle o no la conversión,
				// no se consume el \n, se queda en el buffer del scanner.
				// Esto es un problema cuando falla, porque la siguiente iteración del bucle
				// hace un nextInt, pero como en el Scanner hay un salto de línea no consumudo,
				// lee una cadena vacía, que al convertirse, falla, y entramos en un bucle
				// infinito.
				numero = scanner.nextInt();
				scanner.nextLine();
				// Si llegamos a este punto es que la conversión ha ido bien.
				// Cambiamos el valor de ok para que salgamos del bucle.
				ok = true;
			} catch (InputMismatchException e) {
				// La conversión ha fallado. Mostramos mensaje de error.
				cantidadFallos++;
				System.out.printf("El valor introducido no se puede convertir a un número entero. Van %d fallos.\n",
						cantidadFallos);
			}
		} while (!ok);

		System.out.printf("El número introducido es %d.\n\n\n", numero);
	}

}
