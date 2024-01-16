package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio15 {
	private static final Path FICHERO_BECAS = Path.of("FicherosPrueba", "datosBecas.bin");

	public static void main(String[] args) {
		try (DataInputStream dis = new DataInputStream(new FileInputStream(FICHERO_BECAS.toFile()))) {
			while (true) {
				Becario b = new Becario(dis.readUTF(), dis.readUTF(), dis.readInt(), dis.readInt(), dis.readBoolean(),
						dis.readDouble());
				System.out.printf("%s %s\n", b.getNombre(), b.getApellido());
			}

		} catch (EOFException e) {
			// No se hace nada porque es la escepción que marca fin de fichero.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
