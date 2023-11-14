package ejemplos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class EjemploURL {

	public static void main(String[] args) throws IOException {

		URL urlImagen = new URL("https://img.freepik.com/vector-gratis/fondo-plano-naturaleza_1308-20252.jpg");

		Files.copy(urlImagen.openStream(), Path.of("imagen2.jpg"));
		
		try (BufferedInputStream input = new BufferedInputStream(urlImagen.openStream());
				FileOutputStream output = new FileOutputStream(new File("imagen.jpg"))) {

			byte[] buffer = new byte[1024];
			int bytesLeidos;
			while ((bytesLeidos = input.read(buffer, 0, 1024)) != -1) {
				output.write(buffer, 0, bytesLeidos);
			}
		}
	}
}
