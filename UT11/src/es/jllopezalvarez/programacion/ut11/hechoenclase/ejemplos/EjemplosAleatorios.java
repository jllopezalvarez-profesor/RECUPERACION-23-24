package es.jllopezalvarez.programacion.ut11.hechoenclase.ejemplos;

import java.util.Random;

public class EjemplosAleatorios {
	public static void main(String[] args) {
		System.out.println(generarAleatorioRandom(10, 20));

		for (int i = 0; i < 100; i++)
			System.out.println(generarAleatorioMath(5, 10));
	}

	private static int generarAleatorioRandom(int minIncluido, int maxIncluido) {
		Random rnd = new Random();
		return rnd.nextInt(minIncluido, maxIncluido + 1);

	}

	private static int generarAleatorioMath(int minIncluido, int maxIncluido) {

		return (int) (Math.random() * (maxIncluido - minIncluido + 1)) + minIncluido;
	}
}
