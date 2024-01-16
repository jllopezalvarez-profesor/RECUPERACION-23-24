package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class Ejercicio03 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce la ruta del directorio que quieres consultar: ");
		var ruta = sc.nextLine();

		File directorio = new File(ruta);

		if (!directorio.exists()) {
			System.out.println("No existe el directorio " + ruta);
			return;
		}
		if (!directorio.isDirectory()) {
			System.out.println(ruta + "no es un directorio");
			return;
		}

		listarDirectorio(directorio, 0);
		
		System.out.printf("Espacio libre: %d\n", directorio.getFreeSpace()/1024/1024/1024);
		
	}

	private static void listarDirectorio(File directorio, int nivel) {
		var contenido = directorio.listFiles();
		if (contenido != null) {
			for (File file : contenido) {
				String esDirectorio = file.isDirectory() ? "D" : "F";
				long tamanio = file.isDirectory() ? 0 : file.length();
				System.out.printf("%s%s %s %d\n", "\t".repeat(nivel), esDirectorio, file.getName(), tamanio);
				if (file.isDirectory()) {
					listarDirectorio(file, nivel + 1);
				}
			}
		}
	}

}
