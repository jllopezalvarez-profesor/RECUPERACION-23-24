package es.jllopezalvarez.programacion.ut08.ejemplos.ejemplos01wrappers;

public class Ejemplo01 {

	public static void main(String[] args) {

		// Auto-boxing: Crear un objeto Integer y asignar un valor
		Integer wrapperEntero = 3;
		System.out.printf("Wrapper obtenido: %d\n", wrapperEntero);

		// Auto-unboxing: obtener el tipo primitivo de un Integer
		int numeroEntero = wrapperEntero;
		System.out.printf("Valor primitivo obtenido: %d\n", numeroEntero);

		// Unboxing explícito: obtener un valor del wrapper usando método
		long numeroGrande = wrapperEntero.longValue();
		System.out.printf("Valor long obtenido: %d\n", numeroGrande);
		
		// Obtener un número desde un string:
		Integer wrapperEnteroB = Integer.valueOf("125");
		System.out.printf("Valor convertido: %d\n", wrapperEnteroB);

		// La creación de wrappers con constructores ya no está recomendada
		// Se eliminará en nuevas versiones de Java. Se debe usar valueOf. 
		double wrapperDoble = new Double(124545.23);

	}

}
