package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

/**
 * 
 * Escribe un programa que cree un array de 100 posiciones, en el que se
 * almacenen números enteros aleatorios. Queremos procesar cada posición del
 * array según el siguiente algoritmo: • Si el valor en una posición es un
 * número par, lo dividimos entre 2, modificando el valor almacenado en el array
 * en esa posición • Si el valor en una posición es impar, lo multiplicamos por
 * 2, modificando el valor almacenado en el array. Para hacerlo, usa dos métodos
 * estáticos del programa principal: • Método procesarNumeros, que recibe el
 * array y lo procesa. No devuelve nada, modifica los valores del array. •
 * Método esPar. Recibe un número y devuelve un boolean indicando si el número
 * es par o no.
 *
 */
public class Ejercicio09 {

	public static void main(String[] args) {

		int[] numeros = generaAleatorios(100, 100);
		
		mostrarNumeros(numeros);
		int[] procesados=  procesarNumeros(numeros);
		mostrarNumeros(numeros);
		mostrarNumeros(procesados);
		
	}

	public static void mostrarNumeros(int[] numeros) {
		for (int numero : numeros) {
			System.out.printf("%d ", numero);
		}
		System.out.println();
	}
	
//	public static void procesarNumeros(int[] numeros) {
//		for (int i = 0; i < numeros.length; i++) {
//			if (esPar(numeros[i])) {
//				numeros[i] = numeros[i] / 2;
//			} else {
//				numeros[i] = numeros[i] * 2;
//			}
//		}
//	}

	public static int[] procesarNumeros(int[] numeros) {
		int[] numerosProcesados = new int[numeros.length];
		for (int i = 0; i < numeros.length; i++) {
			if (esPar(numeros[i])) {
				numerosProcesados[i] = numeros[i] / 2;
			} else {
				numerosProcesados[i] = numeros[i] * 2;
			}
		}
		return numerosProcesados;
	}
	
	public static boolean esPar(int n) {
		return n % 2 == 0;
	}

	private static int[] generaAleatorios(int cantidadNumeros, int limite) {
		// Crear un array de tamaño "cantidadNumeros"
		// Llenarlo con numeros aleatorios del 0 a limite-1 ambos incluidos
		// Devolver el array creado
		int[] numeros = new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * limite);
		}
		return numeros;
	}

}
