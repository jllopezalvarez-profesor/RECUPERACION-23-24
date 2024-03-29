package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos07binarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Scanner;

// Este ejemplo permite copiar un fichero binario (imagen jpg) en otro fichero jpg.
public class Ejemplo15GuardarEnteros {

	private static final String PATH_PRUEBAS = "FicherosPrueba";
	private static final Path FICHERO_NUMEROS = Path.of(PATH_PRUEBAS, "numeros.dat");

	private static Scanner sc = new Scanner(System.in);

	// Ejemplo que lee números enteros

	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println("Introduce números de 1 a 255 (uno por línea). ");
		System.out.println("Introduce 0 para terminar.");

		try (OutputStream fo = new FileOutputStream(FICHERO_NUMEROS.toFile())) {
			int numero = Byte.MAX_VALUE;
			do {
				try {
					numero = Integer.parseInt(sc.nextLine());
					if (numero != 0) {
						if (numero < 1 || numero > 255) {
							System.out.println("Error. El número debe " + "pertenecer al intervalo [1, 255].");
						} else {
							fo.write(numero);
						}
					}
				} catch (NumberFormatException e) {
					System.out.println("Error. El número introducido no es válido.");
				}
			} while (numero != 0);
		}

		// Leemos el fichero
		System.out.println("\n\nMostrando contenido del fichero.");

		// Ahora leemos el fichero y mostramos los números por pantalla.
		try (FileInputStream fi = new FileInputStream(FICHERO_NUMEROS.toFile())) {
			int posicion = 1;
			int numero;
			while ((numero = fi.read()) != -1) {
				System.out.printf("Número en posición %d: %d\n", posicion, numero);
				posicion++;
			}
		}
	}
}
