import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * - Crear una lista de números aleatorios entre 2 y 100, con muchos elementos -
 * Calcular frecuencias de cada número y mostrarlo en orden de números -
 * Mostrarlas en orden de frecuencia.
 */
public class Ejemplo01 {
	public static void main(String[] args) {
		List<Integer> numeros = generarAleatorios(1000, 0, 100);
		System.out.println(numeros);

		Map<Integer, Integer> frecuencias = new TreeMap<>(Comparator.reverseOrder());
		for (Integer num : numeros) {
//			if (frecuencias.containsKey(num)) {
//				frecuencias.put(num, frecuencias.get(num) + 1);
//			} else {
//				frecuencias.put(num, 1);
//			}

			frecuencias.put(num, frecuencias.getOrDefault(num, 0) + 1);

		}

		System.out.println(frecuencias);

		List<Map.Entry<Integer, Integer>> parejas = new ArrayList<>();
		parejas.addAll(frecuencias.entrySet());
		System.out.println(parejas);
		parejas.sort(new KeyValuePairByValueComparator());
		System.out.println(parejas);
		
		TreeSet<Map.Entry<Integer, Integer>> conjunto = new TreeSet<Map.Entry<Integer,Integer>>(new KeyValuePairByValueComparator());;
		conjunto.addAll(frecuencias.entrySet());
		
		System.out.println(conjunto);

	

		
	}

	private static List<Integer> generarAleatorios(int cuantos, int min, int max) {
		Random rnd = new Random();
		List<Integer> numeros = new ArrayList<Integer>(cuantos);
		while (cuantos > 0) {
			numeros.add(rnd.nextInt(min, max));
			cuantos--;
		}

		return numeros;

	}
	
	private static  class KeyValuePairByValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
		@Override
		public int compare(Entry<Integer, Integer> arg0, Entry<Integer, Integer> arg1) {
			return -Integer.compare(arg0.getValue(), arg1.getValue());
		}
	}
	
}
