package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class Ejercicio02 {
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

		listarDirectorio(directorio);
	}

	private static void listarDirectorio(File directorio) {
		FileFilter filtro = new FileFilter() {
			@Override
			public boolean accept(File fichero) {
				//return (fichero.getName().indexOf("a") >= 0);
				return !fichero.isHidden();
			}
		};
		// Si queremos filtrar con el filtro creado previamente:
		// var contenido = directorio.listFiles(filtro);
		var contenido = directorio.listFiles();
		for (File file : contenido) {
			String esDirectorio = file.isDirectory() ? "D" : "F";
			long tamanio = file.isDirectory() ? 0 : file.length();
			System.out.printf("%s %s %d\n", esDirectorio, file.getName(), tamanio);
		}
	}

}
