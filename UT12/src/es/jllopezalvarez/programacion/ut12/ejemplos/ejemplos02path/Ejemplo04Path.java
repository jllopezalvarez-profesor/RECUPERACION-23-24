package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos02path;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

public class Ejemplo04Path {

	public static void main(String[] args) throws IOException {
		// Montar una ruta usando File.separator o File.separatorChar
		// Si no empieza por "/" se asume que parte del directorio donde se ejecuta la
		// aplicación
		// En el caso de eclipse es la carpeta del proyecto.
		String rutaFicheroA = "FicherosPrueba" + File.separator + "Fichero.txt";
		// Creamos objeto file para gestionar el fichero y el directorio.
		File ficheroA = new File(rutaFicheroA);
		// Creamos el directorio padre. Si no existe este directorio la creación del
		// fichero falla.
		ficheroA.getParentFile().mkdirs();
		// Creamos el fichero
		ficheroA.createNewFile();

		// Con el paquete java.nio se añade una clase Path, que permite construir paths
		// de forma más fácil, e independiente de la plataforma. Admite un número
		// indefinido de parámetros.
		Path rutaFicheroB = Path.of("FicherosPrueba", "SubDirA", "SubDirB", "SubDirC", "Fichero.txt");
		// Path rutaFicheroB =
		// Path.of(URI.create("file:///home/jllopezalvarez/repos/22-23/DM1E-22-23-PROGRAMACION/Java/UT12/FicherosPrueba/SubDirA/SubDirB/SubDirC/Fichero.txt"));
		// Obtenemos un objeto File para poder gestionar la creación del fichero
		File ficheroB = rutaFicheroB.toFile();
		// Creamos el directorio padre del fichero
		ficheroB.getParentFile().mkdirs();
		// Creamos el fichero
		ficheroB.createNewFile();

	}

}
