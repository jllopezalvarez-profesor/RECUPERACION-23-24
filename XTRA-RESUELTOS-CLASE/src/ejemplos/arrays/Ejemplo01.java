package ejemplos.arrays;

import java.util.Arrays;
import java.util.Random;

public class Ejemplo01 {
	public static void main(String[] args) {

		Random rnd = new Random();
		
		int[] arrayNumeros = new int[10];
		
		for (int num : arrayNumeros) {
			num = rnd.nextInt(10);
		}
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			arrayNumeros[i] = rnd.nextInt(100);
		}
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			int num = arrayNumeros[i];
			System.out.printf("%d ", num);
		}
		
		System.out.println("\n");
		
		for (int num : arrayNumeros) {
			System.out.printf("%d ", num);
			
		}
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			arrayNumeros[i]++;
			
		}
		System.out.println("\n");
		for (int num : arrayNumeros) {
			System.out.printf("%d ", num);
			
		}
		
		Arrays.sort(arrayNumeros);
		
		
		
		System.out.println("\n");
		
		for (int num : arrayNumeros) {
			System.out.printf("%d ", num);
			
		}
		System.out.println("\n");
			
		System.out.println(Arrays.toString(arrayNumeros));
		
		int cantidad = 10;
		
		sumarDobleAPosicion(arrayNumeros, cantidad, 4);
		System.out.println("\n");
		
		System.out.println(Arrays.toString(arrayNumeros));
		System.out.println("\n");
		System.out.println(cantidad);
		
		
	}

	private static void sumarDobleAPosicion(int[] array, int cantidad, int posicion) {
		cantidad *=2;
		array[posicion] += cantidad;
		

	}
}
