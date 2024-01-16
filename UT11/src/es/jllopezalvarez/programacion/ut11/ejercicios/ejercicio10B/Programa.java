package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio10B;

import java.util.Random;

import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio09.figuras.Circulo;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio09.figuras.Cuadrado;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio09.figuras.Figura;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio09.figuras.Rectangulo;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio09.figuras.Romboide;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio09.figuras.Triangulo;

public class Programa {

	private static final int NUM_FIGURAS = 10;

	public static void main(String[] args) {
		
		Figura[] figuras = new Figura[NUM_FIGURAS];
		for (int i = 0; i < figuras.length; i++) {
			figuras[i] = figuraAleatoria();
		}
		
		mostrarFiguras(figuras);

	}

	private static Figura figuraAleatoria() {
		Random rnd = new Random();
		switch (rnd.nextInt(8)) {
		case 0:
			return new Circulo(rnd.nextDouble(10));
		case 1:
			return new Cuadrado(rnd.nextDouble(10));
		case 2:
			return new Rectangulo(rnd.nextDouble(10), rnd.nextDouble(10));
		case 3:
			return new Romboide(rnd.nextDouble(10), rnd.nextDouble(10), rnd.nextDouble(10));
		case 4:
			double a = rnd.nextDouble(10);
			double b = rnd.nextDouble(10);
			double c = rnd.nextDouble(10);
			while ((a >= b + c) || (b >= a + c) || (c >= a + b)) {
				c = rnd.nextDouble(10);
			}
			return new Triangulo(a, b, c);
		default:
			throw new RuntimeException("Valor en switch no válido.");
		}

	}
	
	private static String tipoFigura(Figura figura) {
		return figura.getClass().getSimpleName();
	}
	
	private static void mostrarFiguras(Figura[] figuras) {
		for (Figura figura : figuras) {
			System.out.printf("%s - P: %.2f - A: %.2f\n", tipoFigura(figura), figura.perimetro(), figura.area());
		}
	}
	
	

}
