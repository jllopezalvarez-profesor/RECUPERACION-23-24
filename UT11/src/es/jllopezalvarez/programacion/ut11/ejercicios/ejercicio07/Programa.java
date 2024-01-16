package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio07;

import java.util.Random;
import java.util.Scanner;

import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04.Directivo;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04.Empleado;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04.Oficial;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04.Operario;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04.Tecnico;

public class Programa {
	private static Random rnd = new Random();

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("¿Cuántos empleados quieres crear? ");
			int numEmpleados = Integer.parseInt(scanner.nextLine());

			Empleado[] empleados = new Empleado[numEmpleados];

			for (int i = 0; i < empleados.length; i++) {
				System.out.printf("Nombre del empleado %d: ", i + 1);
				String nombreEmpleado = scanner.nextLine();
				empleados[i] = crearEmpleadoAleatorio(nombreEmpleado);
			}

			for (Empleado empleado : empleados) {
				System.out.println(empleado);
			}
		}
	}

	private static Empleado crearEmpleadoAleatorio(String nombreEmpleado) {
		int aleatorio = rnd.nextInt(5);
		switch (aleatorio) {
		case 0:
			return new Empleado(nombreEmpleado);
		case 1:
			return new Directivo(nombreEmpleado);
		case 2:
			return new Operario(nombreEmpleado);
		case 3:
			return new Oficial(nombreEmpleado);
		case 4:
			return new Tecnico(nombreEmpleado);
		default:
			throw new RuntimeException("El valor aleatorio para generar el empleado no es válido.");
		}
	}

}
