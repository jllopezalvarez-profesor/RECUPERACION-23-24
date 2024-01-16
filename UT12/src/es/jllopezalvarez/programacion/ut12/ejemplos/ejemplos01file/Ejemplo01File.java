package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos01file;

import java.io.File;
import java.io.IOException;

public class Ejemplo01File {

	public static void main(String[] args) {
		System.out.printf("El separador de partes de un path de fichero es '%s'.\n", File.separator);

		File carpetaEscritorio = new File("C:\\Users\\Diurno\\Desktop");

		System.out.printf("¿Existe el directorio %s?: %s\n", carpetaEscritorio.getPath(), carpetaEscritorio.exists());
		System.out.printf("¿%s es un directorio?: %s\n", carpetaEscritorio.getPath(), carpetaEscritorio.isDirectory());
		System.out.printf("¿%s es un fichero?: %s\n", carpetaEscritorio.getPath(), carpetaEscritorio.isFile());

		File carpetaDatos = new File(carpetaEscritorio, "datos\\directorio1");
		System.out.printf("¿Existe el directorio %s?: %s\n", carpetaDatos.getPath(), carpetaDatos.exists());
		System.out.printf("¿%s es un directorio?: %s\n", carpetaDatos.getPath(), carpetaDatos.isDirectory());
		System.out.printf("¿%s es un fichero?: %s\n", carpetaDatos.getPath(), carpetaDatos.isFile());

		System.out.printf("Resultado de crear la carpeta de datos: %s\n", carpetaDatos.mkdirs());

		carpetaDatos.delete();

		File fichero = new File(carpetaEscritorio.getAbsolutePath() + "\\datos\\fichero1.txt");

		try {
			fichero.createNewFile();
		} catch (IOException e) {
			System.out.println("Error al crear el fichero");
			e.printStackTrace();
		}

		for (String nombreFichero : carpetaEscritorio.list()) {
			System.out.println(nombreFichero);
		}
	}

	private static boolean esPrimo(int numero) {
		if (numero < 2)
			return false;
		if (numero == 2)
			return true;
		if (numero % 2 == 0)
			return false;
		for (int i = 3; i < numero / 2; i += 2) {
			if (numero % i == 0)
				return false;
		}
		return true;
	}

}
