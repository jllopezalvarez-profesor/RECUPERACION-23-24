package ejemplos;

public class EjemploComparaStrings {
	public static void main(String[] args) {

		String cadenaA = "HOLA";
		String cadenaB = "HOLA";

		System.out.printf("Resultado de comparar con == %s\n", cadenaA == cadenaB);
		System.out.printf("Resultado de comparar con equals %s\n", cadenaA.equals(cadenaB));

		String cadenaC = new String("HOLA");
		String cadenaD = new String("HOLA");

		System.out.printf("Resultado de comparar con == %s\n", cadenaC == cadenaD);
		System.out.printf("Resultado de comparar con equals %s\n", cadenaC.equals(cadenaD));

	}
}
