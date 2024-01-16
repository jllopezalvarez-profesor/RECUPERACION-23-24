package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18A;

import java.util.Locale;
import java.util.Random;

import net.datafaker.Faker;

public class Programa {
	private static final int NUM_INSTRUMENTOS = 20;
	private static final int NUM_INSTRUMENTOS_DISTINTOS = 12;

	private static Faker faker = new Faker(new Locale("es"));
	private static Random rnd = new Random();

	public static void main(String[] args) {
		Instrumento[] instrumentos = crearInstrumentos(NUM_INSTRUMENTOS);

		mostrarInstrumentos(instrumentos);

		System.out.println("-".repeat(100));

		afinarInstrumentos(instrumentos);

		System.out.println("-".repeat(100));

		tocarInstrumentos(instrumentos);

		System.out.println("-".repeat(100));

		System.out.println(buscarMasDificil(instrumentos));

		System.out.println("-".repeat(100));

		dejarDeTocarInstrumentos(instrumentos);

	}

	private static Instrumento[] crearInstrumentos(int numInstrumentos) {
		Instrumento[] instrumentos = new Instrumento[numInstrumentos];

		for (int i = 0; i < instrumentos.length; i++) {
			instrumentos[i] = crearInstrumentoAleatorio();
		}

		return instrumentos;
	}

	private static Instrumento crearInstrumentoAleatorio() {
		switch (rnd.nextInt(NUM_INSTRUMENTOS_DISTINTOS)) {
		case 0:
			return new Violin(faker.name().firstName());
		case 1:
			return new Violonchelo(faker.name().firstName());
		case 2:
			return new Piano(faker.name().firstName());
		case 3:
			return new Arpa(faker.name().firstName());
		case 4:
			return new Guitarra(faker.name().firstName());
		case 5:
			return new Flauta(faker.name().firstName());
		case 6:
			return new Clarinete(faker.name().firstName());
		case 7:
			return new Trompeta(faker.name().firstName());
		case 8:
			return new Tuba(faker.name().firstName());
		case 9:
			return new Xilofono(faker.name().firstName());
		case 10:
			return new Timbales(faker.name().firstName());
		case 11:
			return new Pandereta(faker.name().firstName());
		default:
			throw new RuntimeException("El valor generado aleatoriamente no es válido.");
		}
	}

	private static void mostrarInstrumentos(Instrumento[] instrumentos) {
		for (Instrumento instrumento : instrumentos) {
			System.out.println(instrumento);
		}
	}

	private static void tocarInstrumentos(Instrumento[] instrumentos) {
		for (Instrumento instrumento : instrumentos) {
			instrumento.tocar();
		}
	}

	private static Instrumento buscarMasDificil(Instrumento[] instrumentos) {
		if (instrumentos == null || instrumentos.length == 0) {
			throw new IllegalArgumentException("El array de instrumentos no puede ser nulo ni estar vacío.");
		}
		Instrumento masDificil = instrumentos[0];
		for (Instrumento instrumento : instrumentos) {
			if (instrumento.esMasDificil(masDificil)) {
				masDificil = instrumento;
			}
		}
		return masDificil;
	}

	private static void dejarDeTocarInstrumentos(Instrumento[] instrumentos) {
		for (Instrumento instrumento : instrumentos) {
			instrumento.parar();
		}
	}

	private static void afinarInstrumentos(Instrumento[] instrumentos) {
		for (Instrumento instrumento : instrumentos) {
			if (instrumento instanceof Afinable) {
				((Afinable) instrumento).afinar();
			}
		}
	}
}
