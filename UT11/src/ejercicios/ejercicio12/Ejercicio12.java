package ejercicios.ejercicio12;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio12 {
	private static Random rnd = new Random();

	public static void main(String[] args) {
		Vehiculo[] vehiculos = new Vehiculo[10];

		for (int i = 0; i < vehiculos.length; i++) {
			if (rnd.nextBoolean()) {
				// Coche
				int numPlazas = rnd.nextInt(4, 8);
				vehiculos[i] = new Coche(numPlazas);
			} else {
				// Moto
				vehiculos[i] = new Moto();
			}
		}
		
		Arrays.sort(vehiculos);
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < vehiculos.length; j++) {
				Vehiculo vehiculo = vehiculos[j];
				System.out.printf("Vehículo en la posición %d\n", j);
				System.out.printf("\tEs de tipo %s y tiene %d asientos\n", vehiculo.getClass().getName(), vehiculo.getNumPlazas());
				System.out.print("\t");
				vehiculo.acelerar(rnd.nextInt(21));
				System.out.print("\t");
				vehiculo.frenar(rnd.nextInt(21));
				
//				if (vehiculo instanceof Coche) {
//					
//				}
				
				
			}
		}

	}

}
