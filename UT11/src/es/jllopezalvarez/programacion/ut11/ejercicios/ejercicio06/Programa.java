package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06;

import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.Color;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.ConsumoEnergetico;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.Electrodomestico;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.Lavadora;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.Television;

public class Programa {
	private static final int NUM_ELECTRODOMESTICOS = 10;

	public static void main(String[] args) {

		Electrodomestico[] electrodomesticos = new Electrodomestico[NUM_ELECTRODOMESTICOS];

		electrodomesticos[0] = new Lavadora();
		electrodomesticos[1] = new Television();
		electrodomesticos[2] = new Electrodomestico();
		electrodomesticos[3] = new Lavadora(200, 63);
		//electrodomesticos[4] = new Television(200, 14);
		electrodomesticos[5] = new Electrodomestico(200, 40);
		electrodomesticos[6] = new Lavadora(300, Color.ROJO, ConsumoEnergetico.D, 60, 10);
		electrodomesticos[7] = new Television(300, Color.GRIS, ConsumoEnergetico.B, 30, 65, false);
		electrodomesticos[8] = new Electrodomestico(300, Color.AZUL, ConsumoEnergetico.C, 90);
		//electrodomesticos[9] = new Electrodomestico();

		
		mostrarTodos(electrodomesticos);

		System.out.println("-".repeat(100));
		
		mostrarPreciosLavadora(electrodomesticos);

		System.out.println("-".repeat(100));
		
		mostrarPreciosTelevisiones(electrodomesticos);

	}

	private static void mostrarTodos(Electrodomestico[] electrodomesticos) {
		double sumaPrecios = 0;
		int numElectrodomesticos = 0;
		for (int i = 0; i < electrodomesticos.length; i++) {
			if (electrodomesticos[i]!= null) {
				System.out.printf("Precio final del electrodoméstico en la posición %d: %.2f\n", i,
						electrodomesticos[i].getPrecioFinal());
				sumaPrecios += electrodomesticos[i].getPrecioFinal();
				numElectrodomesticos++;
			}
		}
		System.out.printf("Precio medio de todos los electrodomésticos: %.2f\n",
				(sumaPrecios / numElectrodomesticos));
	}

	private static void mostrarPreciosLavadora(Electrodomestico[] electrodomesticos) {
		double sumaPrecios = 0;
		int numLavadoras = 0;
		for (int i = 0; i < electrodomesticos.length; i++) {
			if (electrodomesticos[i] instanceof Lavadora) {
				System.out.printf("Precio final de la lavadora en la posición %d: %.2f\n", i,
						electrodomesticos[i].getPrecioFinal());
				numLavadoras++;
				sumaPrecios += electrodomesticos[i].getPrecioFinal();
			}
		}
		if (numLavadoras == 0) {
			System.out.println("No se puede calcular el precio medio de las lavadoras porque no hay lavadoras.");
		} else {
			System.out.printf("Precio medio de todas las lavadoras: %.2f\n", (sumaPrecios / numLavadoras));
		}
	}

	private static void mostrarPreciosTelevisiones(Electrodomestico[] electrodomesticos) {
		double sumaPrecios = 0;
		int numTelevisiones = 0;
		for (int i = 0; i < electrodomesticos.length; i++) {
			if (electrodomesticos[i] instanceof Television) {
				System.out.printf("Precio final de la televisión en la posición %d: %.2f\n", i,
						electrodomesticos[i].getPrecioFinal());
				numTelevisiones++;
				sumaPrecios += electrodomesticos[i].getPrecioFinal();
			}
		}
		if (numTelevisiones == 0) {
			System.out.println("No se puede calcular el precio medio de las televisiones porque no hay televisiones.");
		} else {
			System.out.printf("Precio medio de todas las televisiones: %.2f\n", (sumaPrecios / numTelevisiones));
		}
	}
}
