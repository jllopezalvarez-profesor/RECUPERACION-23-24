package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

/**
 * <pre>
 * Crea un programa que sirva para comprobar si los números generados con Math.random siguen una distribución uniforme, es decir, que, si generamos muchos números, todos los números se generar más o menos las mismas veces. Para ello, vamos a:
    • Generar un número importante de números aleatorios, entre 0 y 99. Podemos empezar con 10000. Usa una constante para este número, así podremos cambiarlo fácilmente, para probar con más o con menos.
    • Contar cuantas veces aparece cada uno de los números. 
    • Obtener qué número ha aparecido más veces.
    • Obtener qué número ha aparecido menos veces.
	Para contar las apariciones usa un array de enteros de 100 posiciones, inicializado a cero (todas sus posiciones tienen valor cero). Cada vez que se generar un número incrementamos la posición correspondiente del array en uno, para contar cuantas veces ha aparecido ese número. Así, en la posición 0 tendremos cuantas veces ha aparecido el cero, en la uno, cuantas veces el uno, y así sucesivamente.
	Una vez generados y contabilizados, vamos a mostrar los valores del array, y contar cuántas veces aparece el que más veces aparece, y cuantas el que menos. 
	¿Estos valores se separan mucho de lo esperado? Lo esperado sería que cada número apareciera la misma cantidad de veces, que se obtiene al dividir la cantidad total de números generados por la cantidad de números diferentes que generamos.
	Ejemplo: generamos 50000 números aleatorios. Cada número está entre 0 y 99 ambos incluidos. En total tenemos 100 números distintos. Si todos aparecen la misma cantidad de veces cada uno debería aparecer 50000/100 veces = 500 veces.
 * </pre>
 */
public class Ejercicio13 {

	private static final int CANTIDAD_GENERADOS = 100_000_000;
	private static final int LIMITE_RANDOM = 100;

	public static void main(String[] args) {

		int[] contadores = calcularFrecuenciasRandom(LIMITE_RANDOM, CANTIDAD_GENERADOS);

		mostrarNumeros(contadores);

	}

	private static int[] calcularFrecuenciasRandom(int limiteRandom, int cantidadGenerados) {
		int[] contadores = new int[limiteRandom];

		for (int i = 0; i < cantidadGenerados; i++) {
			int numeroAleatorio = (int) (Math.random() * limiteRandom);
			contadores[numeroAleatorio]++;
		}
		return contadores;
	}

	private static void mostrarNumeros(int[] numeros) {
		for (int c : numeros) {
			System.out.printf("%d ", c);
		}
	}

}
