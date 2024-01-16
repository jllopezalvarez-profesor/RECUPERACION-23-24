package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejercicio11 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Pedimos fichero al usuario
		System.out.print("¿Qué fichero quieres procesar? ");
		String pathFicheroUsuario = scanner.nextLine();

		// Creamos objeto file y comprobamos si exite
		File ficheroEntrada = new File(pathFicheroUsuario);
		if (!ficheroEntrada.exists()) {
			System.out.printf("El fichero %s no existe\n", pathFicheroUsuario);
			return;
		}

		// Creamos una lista de Strings para almacenar las líneas del fichero.
		List<String> lineas = new ArrayList<>();
		// Abrimos el fichero
		try (Scanner scannerFichero = new Scanner(new BufferedReader(new FileReader(ficheroEntrada)))) {
			// Leemos las líneas del fichero y las vamos incluyendo en la lista
			while (scannerFichero.hasNextLine()) {
				lineas.add(scannerFichero.nextLine());
			}
		} catch (FileNotFoundException e) {
			// No debería saltar el error, porque lo hemos comprobado antes, pero, por si
			// acaso, mostamos error y salimos si se produce.
			System.out.printf("Error al abri el fichero %s\n", pathFicheroUsuario);
			e.printStackTrace();
			return;
		}

		// Ordenamos las líneas. Yo lo hago con una clase anónima que implementa la
		// interfaz Comparator<String>, pero se puede crear la clase aparte e
		// instanciarla para hacer la ordenación. No llamo directamente a sort(null)
		// porque esto ordenaría alfabéticamente, y nosotros queremos por tamaño.
		lineas.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		}.reversed());

		// Creamos el stream para sobrescribir. Primero creamos un File con el nombre de
		// fichero adecuado
		File directorioPadre = ficheroEntrada.getParentFile();
		File ficheroSalida = new File(directorioPadre, ficheroEntrada.getName() + ".ordenado");
		try (PrintWriter pwSalida = new PrintWriter(new FileWriter(ficheroSalida, true))) {
			// Escribimos las líneas
			for (String linea : lineas) {
				pwSalida.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.printf("Error al crear el fichero %s\n", ficheroSalida.getAbsolutePath());
			e.printStackTrace();
			return;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
