package es.jllopezalvarez.programacion.ut12.ejercicios.ejercicio10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.datafaker.Faker;

public final class MediaUtilities {

	private MediaUtilities() {

	}

	private static Faker faker = new Faker(Locale.getDefault());

	public static Media newRandomMedia() {
		int id = faker.number().positive();
		String titulo = faker.chiquito().expressions();
		String artista = faker.name().fullName();
		String productora = faker.company().name();
		LocalDate fechaPublicacion = faker.date().birthday(1, 30).toLocalDateTime().toLocalDate();
		MediaType tipo = MediaType.values()[faker.random().nextInt(MediaType.values().length)];
		return new Media(id, titulo, artista, productora, fechaPublicacion, tipo);
	}

	public static List<Media> newRandomMedia(int count) {
		List<Media> list = new ArrayList<>(count);
		while (count > 0) {
			list.add(newRandomMedia());
			count--;
		}
		return list;
	}
}
