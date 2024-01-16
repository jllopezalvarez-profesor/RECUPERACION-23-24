package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

public class Ejemplo06PropagacionExcepciones {

	public static void main(String[] args) {
		try {
			metodoA();
		} catch (Exception e) {
			// Usamos una mala práctica: excepción pokemon (Gotta catch 'em all!) para
			// capturar el error que se puede producir en la llamada al método.
			System.out.println("Excepción: " + e);
			e.printStackTrace();
		}
	}

	public static void metodoA() {
		System.out.println("Entrando en método A");
		metodoB();
		System.out.println("Saliendo de método A");
	}

	public static void metodoB() {
		System.out.println("Entrando en método B");
		metodoC();
		System.out.println("Saliendo de método B");
	}

	public static void metodoC() {
		System.out.println("Entrando en método C");
		metodoD();
		System.out.println("Saliendo de método C");

	}

	public static void metodoD() {
		System.out.println("Entrando en método D");

		// La excepción se dispara en metodoD, pero como no está controlada, "asciende"
		// por la pila de llamadas hasta llegar al programa principal, donde sí lo
		// estamos controlado.
		int numero = Integer.parseInt("ocho");
		System.out.println(numero);
		System.out.println("Saliendo de método D");

	}
}
