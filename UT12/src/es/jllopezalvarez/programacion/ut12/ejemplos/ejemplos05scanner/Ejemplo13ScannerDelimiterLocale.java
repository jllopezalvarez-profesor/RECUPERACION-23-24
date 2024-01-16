package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos05scanner;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * 
 * Ejemplo de Scanner usado para "tokenizar" una cadena de caracteres, que en
 * lugar de separarse por "whitespaces" se separa con el pipe (|), y que usa un
 * locale específico. Vamos a usar números y fechas formateados con el estándar
 * de EEUU, que no es igual que en España
 *
 */
public class Ejemplo13ScannerDelimiterLocale {

	// Estrctura: id|nombre|estatura|ingresos
	private static final String CADENA_TEXTO = """
			1|José Luis López:1.70|12,323.34
			2|María Pérez|1.65|21,323.34
			""";

	public static void main(String[] args) {
		// Vamos a mostrar los datos del locale por defecto, el que está configurado en
		// la JVM cuando arranca la aplicación
		Locale localePorDefecto = Locale.getDefault();
		System.out.printf("El locale establecido es %s / %s\n", localePorDefecto.getCountry(),
				localePorDefecto.getDisplayCountry());

		// Datos de formato de números
		DecimalFormat numberFormat = (DecimalFormat) DecimalFormat.getInstance();
		DecimalFormatSymbols numberSymbols = numberFormat.getDecimalFormatSymbols();
		System.out.printf("Separador decimal %s\n", numberSymbols.getDecimalSeparator());
		System.out.printf("Separador miles %s\n", numberSymbols.getGroupingSeparator());

		// Formatos de fecha. No los usamos en el ejemplo, pero hay que pensar en ellos
		// cuando parseamos texto
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		System.out.printf("Formato %s\n", dateFormat.toPattern());
		System.out.printf("Formato localizado %s\n", dateFormat.toLocalizedPattern());

		// Creamos un Scanner para procesar la cadena.
		try (Scanner scanner = new Scanner(CADENA_TEXTO)) {
			// Ponemos el locale de EEUU
			scanner.useLocale(Locale.US);
			// Ponemos el separador
			scanner.useDelimiter("[\\|\\n]");
			// Usamos hasNext para el bucle, y dentro usamos varios nextXXX, en el orden
			// adecuado
			while (scanner.hasNext()) {
				int id = scanner.nextInt();
				String nombre = scanner.next();
				double estatura = scanner.nextDouble();
				double ingresos = scanner.nextDouble();
				System.out.printf("%s, con id %d mide %f y ha ingresado %f\n", nombre, id, estatura, ingresos);
			}
		}
	}
}
