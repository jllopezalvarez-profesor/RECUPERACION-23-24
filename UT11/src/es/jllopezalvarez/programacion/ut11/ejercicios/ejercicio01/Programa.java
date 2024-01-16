package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio01;

public class Programa {

	public static void main(String[] args) {

		Fecha f1 = new Fecha(22, 26, 123);
		System.out.printf("Fecha f1 válida: %s.\n", f1.fechaCorrecta() ? "SI" : "NO");

		Fecha f2 = new Fecha(22, 12, 2023);
		System.out.printf("Fecha f2 válida: %s.\n", f2.fechaCorrecta() ? "SI" : "NO");

		System.out.printf("¿Es f1 mayor que f2?: %s.\n", f1.esMayorQue(f2) ? "SI" : "NO");
		System.out.printf("¿Es f2 mayor que f1?: %s.\n", f2.esMayorQue(f1) ? "SI" : "NO");

		Fecha f3 = new Fecha(20, 12, -1);
		Fecha fLimite = new Fecha(2, 3, 1);
		while (fLimite.esMayorQue(f3)) {
			f3.diaSiguiente();
			System.out.println(f3);
		}

	}

}
