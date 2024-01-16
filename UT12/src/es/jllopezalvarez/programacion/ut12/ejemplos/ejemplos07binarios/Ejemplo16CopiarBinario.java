package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos07binarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

// Este ejemplo permite copiar un fichero binario (imagen jpg) en otro fichero jpg.
public class Ejemplo16CopiarBinario {
	private static final Path IMG_ORIGINAL_1 = Path.of("FicherosPrueba", "1.jpg");
	private static final Path IMG_COPIA_1 = Path.of("FicherosPrueba", "1-copia.jpg");

	private static final Path IMG_ORIGINAL_2 = Path.of("FicherosPrueba", "2.png");
	private static final Path IMG_COPIA_2 = Path.of("FicherosPrueba", "2-copia.png");

	public static void main(String[] args) throws FileNotFoundException, IOException {
		copyByteAByte();
		copyPorBloques();
	}

	private static void copyByteAByte() throws IOException, FileNotFoundException {
		System.out.println("Vamos a copiar un fichero byte a byte.");

		// Como siempre que podamos, usamos try-with-resources para
		// garantizar el cierre del fichero.
		try (FileInputStream fi = new FileInputStream(IMG_ORIGINAL_1.toFile());
				FileOutputStream fo = new FileOutputStream(IMG_COPIA_1.toFile())) {
			int byteLeido;
			while ((byteLeido = fi.read()) != -1) {
				fo.write(byteLeido);
			}
		}
		System.out.println("Fichero copiado byte a byte.");
	}

	private static void copyPorBloques() throws FileNotFoundException, IOException {
		System.out.println("Vamos a copiar un fichero por bloques.");

		// Creamos un array de bytes para copiar por bloques
		final int MAX_BYTES = 40000;
		byte[] bytesLeidos = new byte[MAX_BYTES];

		// Usamos try-with-resources para garantizar el cierre del fichero.
		try (FileInputStream fi = new FileInputStream(IMG_ORIGINAL_2.toFile());
				FileOutputStream fo = new FileOutputStream(IMG_COPIA_2.toFile())) {
			int numBytesLeidos = fi.read(bytesLeidos);
			while (numBytesLeidos != -1) {
				fo.write(bytesLeidos, 0, numBytesLeidos);
				// fo.write(bytesLeidos, 0, 256);
				numBytesLeidos = fi.read(bytesLeidos);
				if (numBytesLeidos < 256) {
					System.out.println("La última lectura han sido " + numBytesLeidos);
				}
			}
		}

		System.out.println("Fichero copiado por bloques.");
	}
}
