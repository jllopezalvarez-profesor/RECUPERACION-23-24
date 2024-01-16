package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos05scanner;

import java.util.Scanner;

/**
 * 
 * Ejemplo de Scanner usado para "tokenizar" una cadena de caracteres, y leer
 * cada token usando el método adecuado en función del tipo de datos.
 *
 */
public class Ejemplo12ScannerMetodosHasYNext {

	private static final String CADENA_TEXTO = """
			Hola, soy José Luis
			2342
			1000000000000
			3423,23
			1123123123123123121323.2312312312312312312335165546546465465465465465465462131685465135165415645464316516513216515641654654132135454456412153465465465465432154654643131654
			1123123123123123121323,2312312312312312312335165546546465465465465465465462131685465135165415645464316516513216515641654654132135454456412153465465465465432154654643131654
			true
			false
			""";

	public static void main(String[] args) {

		// Creamos un Scanner para procesar la cadena.
		try (Scanner scanner = new Scanner(CADENA_TEXTO)) {
			// Usamos hasNext para el bucle, y dentro usamos varios hasXxxx para saber qué
			// tipo de dato tenemos que leer. El orden de los hasXxxx es importante.
			while (scanner.hasNext()) {
				if (scanner.hasNextBoolean()) {
					boolean boolLeido = scanner.nextBoolean();
					System.out.printf("Valor boolean leído: %b\n", boolLeido);
				} else if (scanner.hasNextInt()) {
					int intLeido = scanner.nextInt();
					System.out.printf("Valor int leído: %d\n", intLeido);
				} else if (scanner.hasNextLong()) {
					long longLeido = scanner.nextLong();
					System.out.printf("Valor long leído: %d\n", longLeido);
				} else if (scanner.hasNextFloat()) {
					float floatLeido = scanner.nextFloat();
					System.out.printf("Valor float leído: %f\n", floatLeido);
				} else if (scanner.hasNextDouble()) {
					double doubleLeido = scanner.nextDouble();
					System.out.printf("Valor double leído: %f\n", doubleLeido);
				} else if (scanner.hasNext()) {
					String palabraLeida = scanner.next();
					System.out.printf("Valor String leído: %s\n", palabraLeida);
				}
			}
		}
	}
}
