package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import net.datafaker.Faker;

public class Programa {

	private static final String FORMATO_FECHA = "dd/MM/yyyy";

	private static Scanner scanner = new Scanner(System.in);

	private static Faker dataFaker = new Faker(new Locale("es"));

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);

	public static void main(String[] args) {
		int opcionUsuario;

		ArrayList<Alumno> alumnos = new ArrayList<>();

		while ((opcionUsuario = pedirOpcionUsuario()) != 0) {
			switch (opcionUsuario) {
			case 1:
				listarAlumnos(alumnos);
				break;
			case 2:
				Alumno alumno = crearNuevoAlumno();
				alumnos.add(alumno);
				break;
			case 3:
				String nifAlumno = pedirNifAlumno();
				if (!eliminarAlumno(nifAlumno, alumnos)) {
					System.out.println("No se encuentra el alumno en la lista de alumnos");
				}
//				alumno = new Alumno(nifAlumno);
//				if (!alumnos.remove(alumno)) {
//					System.out.println("No se encuentra el alumno en la lista de alumnos");
//				}
				break;
			case 4:
				nifAlumno = pedirNifAlumno();
				int posicionAlumno = alumnos.indexOf(new Alumno(nifAlumno));
				if (posicionAlumno != -1) {
					mostrarDetallesAlumno(alumnos.get(posicionAlumno));
				} else {
					System.out.printf("No se encuentra el alumno con nif %s\n", nifAlumno);
				}
				break;
			case 9:
				alumno = crearAlumnoAleatorio();
				alumnos.add(alumno);
				break;
			case 0:
				System.out.println("Gracias por utilizar el programa de gestión de alumnos.");
				break;
			default:
				System.out.println("Opción no válida.");
			}

		}
	}

	private static boolean eliminarAlumno(String nifAlumno, ArrayList<Alumno> alumnos) {
		boolean encontradoAlguno = false;
		
		Iterator<Alumno> iterador = alumnos.iterator();
		while (iterador.hasNext()) {
			Alumno alumno = iterador.next();
			if (alumno.getNif().equals(nifAlumno)) {
				iterador.remove();
				encontradoAlguno = true;
			}			
		}
		return encontradoAlguno;
	}
	
	private static boolean eliminarAlumnoFor(String nifAlumno, ArrayList<Alumno> alumnos) {
		boolean encontradoAlguno = false;
		for (int i = 0; i < alumnos.size(); i++) {
			Alumno alumno = alumnos.get(i);
			if (alumno.getNif().equals(nifAlumno)) {
				alumnos.remove(i);
				encontradoAlguno = true;
			}			
		}
		return encontradoAlguno;
	}

	private static boolean eliminarAlumnoForEach(String nifAlumno, ArrayList<Alumno> alumnos) {
		boolean encontradoAlguno = false;
		for (Alumno alumno : alumnos) {
			if (alumno.getNif().equals(nifAlumno)) {
				alumnos.remove(alumno);
				encontradoAlguno = true;
			}
		}
		return encontradoAlguno;
	}

	private static void listarAlumnos(Iterable<Alumno> alumnos) {
		for (Alumno alumno : alumnos) {
			System.out.printf("%s - %s %s - Fecha Nacimiento: %s\n", alumno.getNif(), alumno.getNombre(),
					alumno.getApellidos(), formatter.format(alumno.getFechaNacimiento()));
		}

	}

	private static String pedirNifAlumno() {
		return pedirCadenaUsuario("Introduce el nif del alumno: ");
	}

	private static void mostrarDetallesAlumno(Alumno alumno) {

		StringBuilder builder = new StringBuilder();
		builder.append("Alumno nif ");
		builder.append(alumno.getNif());
		builder.append("\n");
		builder.append(alumno.getNombre());
		builder.append(" ");
		builder.append(alumno.getApellidos());
		builder.append(String.format("\n%dº de %s", alumno.getCurso(), alumno.getCiclo()));
		builder.append(String.format("\nFecha de nacimiento: %s", formatter.format(alumno.getFechaNacimiento())));
		System.out.println(builder.toString());
	}

	private static Alumno crearNuevoAlumno() {
		String nif = pedirCadenaUsuario("Nif del alumno: ");
		String nombre = pedirCadenaUsuario("Nombre del alumno: ");
		String apellidos = pedirCadenaUsuario("Apellidos del alumno: ");
		String ciclo = pedirCadenaUsuario("Ciclo formativo: ");
		int curso = pedirEnteroUsuario("Curso: ");
		LocalDate fechaNacimiento = pedirFechaUsuario("Fecha de nacimiento: ", FORMATO_FECHA);

		return new Alumno(nif, nombre, apellidos, ciclo, curso, fechaNacimiento);
	}

	private static LocalDate pedirFechaUsuario(String mensaje, String formato) {
		System.out.printf("%s (formato %s)", mensaje, formato.toLowerCase());
		while (true) {
			try {
				return LocalDate.parse(scanner.nextLine(), formatter);
			} catch (DateTimeParseException e) {
				System.out.println("El valor introducido no es una fecha válida. Inténtalo de nuevo.");
			}

		}
	}

	private static String pedirCadenaUsuario(String mensaje) {
		System.out.print(mensaje);
		return scanner.nextLine();
	}

	private static int pedirEnteroUsuario(String mensaje) {
		System.out.print(mensaje);
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error. El valor introducido no es un número. Vuelve a intenarlo");
			}
		}
	}

	private static Alumno crearAlumnoAleatorio() {
		String nif = dataFaker.idNumber().validPtNif();
		String nombre = dataFaker.name().firstName();
		String apellidos = dataFaker.name().lastName();
		String ciclo = dataFaker.educator().course();
		int curso = dataFaker.number().numberBetween(1, 2);
		LocalDate fechaNacimiento = dataFaker.date().past(30 * 365, 18 * 365, TimeUnit.DAYS).toLocalDateTime()
				.toLocalDate();

		return new Alumno(nif, nombre, apellidos, ciclo, curso, fechaNacimiento);
	}

	private static int pedirOpcionUsuario() {
		menu();
		System.out.print("Introduce la opción que quieres realizar (1-4, 9, 0 para salir): ");
		while (true) {
			try {
				int opcionUsuario = Integer.parseInt(scanner.nextLine());
				return opcionUsuario;
			} catch (NumberFormatException e) {
				System.out.print("El valor introducido no es válido. Vuelve a intentarlo: ");
			}
		}

	}

	private static void menu() {
		System.out.println("1 - Listar alumnos.");
		System.out.println("2 - Añadir alumno.");
		System.out.println("3 - Eliminar alumno.");
		System.out.println("4 - Mostrar detalles de alumno.");
		System.out.println("9 - Añadir alumno aleatorio.");
		System.out.println("0 - Salir.");
	}

}
