package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos04textobuffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * Copiar un fichero en bloques de bytes usando streams (Reader y Writer) con
 * buffer de Java.
 *
 */
public class Ejemplo09CopiaFicheroBuffer {
	private static final String NOMBRE_FICHERO_ENTRADA = "FicherosPrueba" + File.separator + "StarshipTroopers.txt";
	private static final String NOMBRE_FICHERO_SALIDA = "FicherosPrueba" + File.separator
			+ "StarshipTroopers.copia.txt";
	private static final int CARACTERES_POR_BLOQUE = 32;

	public static void main(String[] args) throws IOException {

		// Usamos un objeto file para comprobar que el fichero de origen existe.
		File f = new File(NOMBRE_FICHERO_ENTRADA);

		// Comprobamos dos cosas: que exista, y que sea un fichero. El objeto File puede
		// representar un directorio. Uso una guard clause para evitar el else
		if (!f.exists() || !f.isFile()) {
			System.out.println("No existe el fichero '" + f.getAbsolutePath() + "' o no es un fichero.");
			return;
		}

		// Usamos try-with-resources para garantizar el cierre de los ficheros.
		// El constructor de FileWriter tiene una sobrecarga con un parámetro para
		// poder añadir a en lugar de sobrescribir el fichero destino. No lo usamos
		// ahora, porque queremos copiar el fichero. Usamos las clases abstractas para
		// declarar las variables (polimorfismo - principio de sustitución)
		// Esto facilita que, simplemente cambiando la construcción de los streams, el
		// mismo código del ejemplo 08 funcione, pero con buffer.
		try (Reader in = new BufferedReader(new FileReader(NOMBRE_FICHERO_ENTRADA));
				Writer out = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_SALIDA))) {
			// Vamos a copiar en bloques de CARACTERES_POR_BLOQUE caracteres. Usamos sysout
			// para saber cuántos caracteres se han leído cada vez
			char[] caracteres = new char[CARACTERES_POR_BLOQUE];
			int cuantosLeidos;
			int numBloqueLeido = 1;
			// Devuelve -1 si se ha llegado al final del fichero.
			// En lugar de != -1 se puede poner > 0. Hay un caso en que read devuelve 0,
			// cuando el array destino donde vamos a guardar los caracteres leídos (en este
			// caso el array numeros) es de longitud cero. Esto es poco probable, pero hay
			// que tenerlo en cuenta.
			while ((cuantosLeidos = in.read(caracteres)) != -1) {
				System.out.printf("En la lectura nº %d se han leído %d caracteres\n", numBloqueLeido, cuantosLeidos);
				// Para escribir tenemos que usar el método en que se dice cuántos caracteres
				// escribir, porque el último paquete de texto no será todo el array, sino sólo
				// una parte. Salvo que el tamaño del fichero sea un múltiplo del tamaño del
				// bloque leído.
				out.write(caracteres, 0, cuantosLeidos);
				System.out.printf("En la escritura nº %d se han escrito %d caracteres\n", numBloqueLeido,
						cuantosLeidos);
				numBloqueLeido++;
			}
		}

	}

}