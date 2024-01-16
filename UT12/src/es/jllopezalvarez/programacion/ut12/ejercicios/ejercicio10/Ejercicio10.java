package es.jllopezalvarez.programacion.ut12.ejercicios.ejercicio10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio10 {

	private static Path pathFicheroDatos = Path.of("datos", "ficheros", "media.txt");
	private static Path pathFicheroInforme = Path.of("datos", "ficheros", "media.informe.txt");

	public static void main(String[] args) {

		List<Media> lista = MediaUtilities.newRandomMedia(10);

		escribirMediaList(lista, pathFicheroDatos);

		List<Media> lista2 = leerMediaList(pathFicheroDatos);

		escribirInformeMediaList(lista2, pathFicheroInforme);
	}

	private static List<Media> leerMediaList(Path pathFichero) {
		List<Media> media = new ArrayList<>();

		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathFichero.toFile())))) {
			scanner.useDelimiter("[\\|\\n]");
			while (scanner.hasNext()) {
				int id = scanner.nextInt();
				String titulo = scanner.next();
				String artista = scanner.next();
				String productora = scanner.next();
				LocalDate fechaPublicacion = LocalDate.parse(scanner.next());
				MediaType type = MediaType.valueOf(scanner.next());
				media.add(new Media(id, titulo, artista, productora, fechaPublicacion, type));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return media;
	}

	private static void escribirMediaList(List<Media> lista, Path pathFichero) {
		try (PrintWriter pw = new PrintWriter(pathFichero.toFile())) {
			for (Media media : lista) {
				pw.printf("%s|%s|%s|%s|%s|%s\n", media.getId(), media.getTitulo(), media.getArtista(),
						media.getProductora(), media.getFechaPublicacion(), media.getType());
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Error al crear el fichero de datos", e);
		}
	}

	private static void escribirInformeMediaList(List<Media> lista, Path pathFichero) {
		try (PrintWriter pw = new PrintWriter(pathFichero.toFile())) {

			String formato = "|%15s|%-25.25s|%-25.25s|%-25.25s|%10s|%10s|\n";
			int longitudSeparador = 15 + 25 * 3 + 10 * 2 + 7;

			// Escribir cabecera
			pw.println("=".repeat(longitudSeparador));
			pw.printf(formato, "Id", "Título", "Artista", "Productora", "Publicado", "Tipo");
			pw.println("=".repeat(longitudSeparador));

			for (Media media : lista) {
				pw.printf(formato, media.getId(), media.getTitulo(), media.getArtista(), media.getProductora(),
						media.getFechaPublicacion(), media.getType());
				pw.println("-".repeat(longitudSeparador));
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException("Error al crear el fichero de informe", e);
		}
	}
}
