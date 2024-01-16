package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos05scanner;

import java.util.Scanner;

/**
 * 
 * Ejemplo de Scanner usado para "tokenizar" una cadena de caracteres, un
 * string. Usamos la forma más "básica" de recorrer los elementos, usando los
 * métodos de Iterator<String>
 *
 */
public class Ejemplo11ScannerString {

	private static final String CADENA_TEXTO = """
			Yo he visto cosas que vosotros no creeríais.
			Naves de ataque en llamas más allá del hombro de Orión.
			Ví rayos-C brillar en la oscuridad cerca de la Puerta de Tannhäuser.
			Todos esos momentos se perderán en el tiempo, como lágrimas en la lluvia.
			Hora de morir.
			""";

	public static void main(String[] args) {

		System.out.println("Recorrido sin problemas con Scanner");
		
		// Creamos un Scanner para procesar la cadena.
		// Cuando usamos cadenas como fuente para el Scanner no es necesario usar
		// try-with-resources, pero usarlo no hace daño y así nos acostrumbramos.
		try (Scanner scanner = new Scanner(CADENA_TEXTO)) {
			// Usamos hasNext y next, que son métodos de Iterable<String>
			// implementado por Scanner.
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		}

		System.out.println("\n\nPruebas errores en Scanner");

		
		// Un Scanner no permite volver hachasNextia atrás. Si queremos volver a procesarlo, lo
		// volvemos a crear. Vamos a intentar leer un token que cumpla cierta expresión
		// regular, y también vamos a intentar leer más allá del final del texto
		try (Scanner scanner = new Scanner(CADENA_TEXTO)) {

			// Intentamos leer la primera palabra ("Yo"), pero con la expresión regular
			// incorrecta. "Y" como expresión regular sólo serviría para la palabra exacata
			// "Y", en mayúscula.
			try {
				// Esto lanza InputMismatchException"Y"
				System.out.printf("Resultado de intentar leer siguente token con expresión regular 'Y': %s\n",
						scanner.next("Y"));
			} catch (Exception e) {
				System.out.println("Error al intentar leer con la expresión regular 'Y'");
				e.printStackTrace();
			}

			// La siguiente palabra en el Scanner sigue siendo "Yo", porque al fallar el
			// anterior "next" no avanzó a la siguiente.
			// Ahora vamos a leer la primera palabra con una expresión regular correcta
			// "Y\\w*" significa "Empieza por Y y siguen 0 o más caracteres de palabra".
			try {
				System.out.printf("Resultado de intentar leer siguente token con expresión regular 'Y\\w*': %s\n",
						scanner.next("Y\\w*"));
			} catch (Exception e) {
				System.out.println("Error al intentar leer con la expresión regular 'Y\\w*'");
				e.printStackTrace();
			}

			while (scanner.hasNext()) {
				// Leemos sin usar, simplemente para llegar al final.
				scanner.next();
			}
			
			// Intentamos leer más allá del final
			try {
				String texto = scanner.next();
				// La siguiente línea no se ejecuta porque hemos alcanzado el final del texto
				System.out.println(texto);
			} catch (Exception e) {
				System.out.println("Error al intentar leer una vez alcanzado el final");
				e.printStackTrace();
			}
		}

	}
}
