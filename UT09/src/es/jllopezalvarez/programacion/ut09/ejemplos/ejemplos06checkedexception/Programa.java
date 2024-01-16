package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos06checkedexception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Ejemplo de gestión de excepciones checked
 *
 */
public class Programa {
	public static void main(String[] args) throws IOException {
		
				
		
		
		ejemploCheckdControlada();

		ejemploCheckedDelegada();
	}

	private static void ejemploCheckedDelegada() throws IOException {
		FileReader reader = new FileReader("noExiste.txt");
		reader.close();
	}

	private static void ejemploCheckdControlada() {

		try {
			// Al intentar abrir un fichero que no existe se lanzará la excepción
			// FileNotFoundException. Esta excepción es de tipo checked, porque hereda de
			// IOException, que a su vez hereda de Exception.
			// Por tanto siempte hay que controlarla o delegarla.
			FileReader reader = new FileReader("ficheroInexistente.txt");
			// Al intentar cerrar el fichero también pueden producirse excepciones.
			reader.close();
		} catch (FileNotFoundException e) {
			// Error, no se encuentra el fichero.
			System.out.println("No se encuentra el fichero.");
		} catch (IOException e) {
			// Error de E/S
			System.out.println("Error de E/S al acceder o cerrar el fichero.");
		}

	}

}
