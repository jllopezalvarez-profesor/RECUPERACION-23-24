package es.jllopezalvarez.programacion.ut09.ejercicios.ejercicio04;

import java.util.Scanner;

public class Programa {

	private static final int NUM_COCHES = 3;

	public static void main(String[] args) {

		Coche[] coches = new Coche[NUM_COCHES];
		Coche coche;
		String matricula;

		try (Scanner scanner = new Scanner(System.in)) {
			int opcionElegida;
			do {
				mostrarMenuPrincipal();
				opcionElegida = pedirOpcionPrincipal(scanner);
				try {
					switch (opcionElegida) {
					case 1:
						mostrarCoches(coches);
						break;
					case 2:
						matricula = pedirMatricula(scanner);
						coche = buscarCoche(coches, matricula);
						if (coche != null) {
							conducirCoche(coche, scanner);
						} else {
							System.out.printf("No se encuentra el coche con la matrícula '%s'.\n", matricula);
						}
						break;
					case 3:
						if (hayEspacioLibre(coches)) {
							coche = crearNuevoCoche(scanner);
							aniadirCoche(coche, coches);
						} else {
							System.out.println(
									"No queda espacio en el garaje. Elimina algñun coche antes de añadir uno nuevo.");
						}
						break;
					case 4:
						matricula = pedirMatricula(scanner);
						coche = buscarCoche(coches, matricula);
						if (coche != null) {
							eliminarCoche(coches, matricula);
						} else {
							System.out.printf("No se encuentra el coche con la matrícula '%s'.\n", matricula);
						}
						break;
					}

				} catch (IllegalStateException | IllegalArgumentException e) {
					System.out.println("Error en la operación: " + e.getMessage());
				}
			} while (opcionElegida != 0);

			System.out.println("Fin del programa.");


		}

	}

	private static Coche crearNuevoCoche(Scanner scanner) {
		System.out.print("¿Matricula? ");
		String matricula = scanner.nextLine();
		System.out.print("¿Velocidad máxima? ");
		int vMax = Integer.parseInt(scanner.nextLine());
		System.out.print("¿Velocidad máxima marcha atrás? ");
		int vMaxAtras = Integer.parseInt(scanner.nextLine());
		return new Coche(matricula, vMax, vMaxAtras);
	}

	private static String pedirMatricula(Scanner scanner) {
		System.out.print("¿Matricula? ");
		return scanner.nextLine();
	}

	private static void eliminarCoche(Coche[] coches, String matricula) {
		for (int i = 0; i < coches.length; i++) {
			if (coches[i] != null && coches[i].getMatricula().equals(matricula)) {
				coches[i] = null;
			}
		}
		// Si hemos llegado aquí es que no hemos encontrado el coche. Podríamos lanzar
		// excepción, pero en este caso no vamos a hacerlo.
	}

	private static void aniadirCoche(Coche coche, Coche[] coches) {
		for (int i = 0; i < coches.length; i++) {
			if (coches[i] == null) {
				coches[i] = coche;
				return;
			}
		}
		// Si llegamos aquí es que no hay espacio en el array. Lanzamos excepción.
		throw new ArrayIndexOutOfBoundsException("No hay espacio libre en el array para el coche.");
	}

	private static Coche buscarCoche(Coche[] coches, String matricula) {
		for (Coche coche : coches) {
			if (coche != null && coche.getMatricula().equals(matricula)) {
				return coche;
			}
		}
		return null;
	}

	private static boolean hayEspacioLibre(Coche[] coches) {
		for (Coche coche : coches) {
			if (coche == null) {
				return true;
			}
		}
		return false;
	}

	private static void mostrarCoches(Coche[] coches) {
		boolean hayCoches = false;
		for (Coche coche : coches) {
			if (coche != null) {
				System.out.println(coche);
				hayCoches = true;
			}
		}
		if (!hayCoches) {
			System.out.println("No hay coches.");
		}
	}

	private static void mostrarMenuPrincipal() {
		System.out.println(
				"1 – Mostrar coches.\n2 – Gestionar coche.\n3 – Añadir coche.\n4 – Eliminar coche.\n0 – Salir.\n");
	}

	private static int pedirOpcionPrincipal(Scanner scanner) {
		boolean ok = false;
		int opcion = 0;
		System.out.println("Selecciona la opción");
		do {
			try {
				opcion = Integer.parseInt(scanner.nextLine());
				if (opcion < 0 || opcion > 4) {
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

	private static void conducirCoche(Coche coche, Scanner scanner) {
		int opcionElegida;
		do {
			mostrarMenuConducir();
			opcionElegida = pedirOpcionConducir(scanner);
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

		System.out.println("Dejamos de conducir el coche.");
	}

	private static void mostrarMenuConducir() {
		System.out.println(
				"1 – Arrancar\n2 – Detener\n3 – Poner marcha atrás\n4 – Quitar marcha atrás\n5 – Acelerar\n6 – Frenar\n0 – Fin\n");
	}

	private static int pedirOpcionConducir(Scanner scanner) {
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
