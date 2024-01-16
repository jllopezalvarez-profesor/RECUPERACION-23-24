package es.jllopezalvarez.programacion.ut09.ejercicios.ejercicio03;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Coche coche = new Coche(120, -22);

		try (Scanner scanner = new Scanner(System.in)) {
			int opcionElegida;
			do {
				mostrarMenu();
				opcionElegida = pedirOpcionUsuario(scanner);
				try {
					switch (opcionElegida) {
					case 1:
						coche.arrancar();
						break;
					case 2:
						coche.detener();
						break;
					case 3:
						coche.ponerMarchaAtras();
						break;
					case 4:
						coche.quitarMarchaAtras();
						break;
					case 5: {
						int incremento = pedirIncrementoUsuario(scanner, "¿Cuanto quieres acelerar?");
						coche.acelerar(incremento);
						break;
					}
					case 6:
						int incremento = pedirIncrementoUsuario(scanner, "¿Cuanto quieres frenar?");
						coche.frenar(incremento);
						break;
					}

				} catch (IllegalStateException | IllegalArgumentException e) {
					System.out.println("Error en la operación: " + e.getMessage());
				}
				System.out.println(coche);
			} while (opcionElegida != 0);

			System.out.println("Fin del programa.");
		}

	}

	private static void mostrarMenu() {
		System.out.println(
				"1 – Arrancar\n2 – Detener\n3 – Poner marcha atrás\n4 – Quitar marcha atrás\n5 – Acelerar\n6 – Frenar\n0 – Fin\n");
	}

	private static int pedirOpcionUsuario(Scanner scanner) {
		boolean ok = false;
		int opcion = 0;
		System.out.println("Selecciona la opción");
		do {
			try {
				opcion = Integer.parseInt(scanner.nextLine());
				if (opcion < 0 || opcion > 6) {
					System.out.println("Opción no válida");
				} else {
					ok = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("Opción no válida. No es un número.");
			}
		} while (!ok);
		return opcion;
	}

	private static int pedirIncrementoUsuario(Scanner scanner, String mensaje) {
		boolean ok = false;
		int incremento = 0;
		System.out.println(mensaje);
		do {
			try {
				incremento = Integer.parseInt(scanner.nextLine());
				ok = true;
			} catch (NumberFormatException e) {
				System.out.println("El valor no es un número.");
			}
		} while (!ok);
		return incremento;
	}

}
