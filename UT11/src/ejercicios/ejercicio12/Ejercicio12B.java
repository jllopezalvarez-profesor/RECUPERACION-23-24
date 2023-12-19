package ejercicios.ejercicio12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio12B {
	private static Random rnd = new Random();

	public static void main(String[] args) {
		List<Vehiculo> vehiculos = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			if (rnd.nextBoolean()) {
				// Coche
				int numPlazas = rnd.nextInt(4, 8);
				vehiculos.add(new Coche(numPlazas));
			} else {
				// Moto
				vehiculos.add(new Moto());
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < vehiculos.size(); j++) {
				Vehiculo vehiculo = vehiculos.get(j);
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
