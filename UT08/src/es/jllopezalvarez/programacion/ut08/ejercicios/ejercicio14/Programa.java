package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio14;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Programa {

	private enum TipoEvento {
		I, A
	}

	private static class Paciente implements Comparable<Paciente> {
		private String nombre;
		private int gravedad;
		private int numeroOrden;

		public Paciente(String nombre, int gravedad, int numeroOrden) {
			this.nombre = nombre;
			this.gravedad = gravedad;
			this.numeroOrden = numeroOrden;
		}

		public String getNombre() {
			return nombre;
		}

		public int getGravedad() {
			return gravedad;
		}

		public int getNumeroOrden() {
			return numeroOrden;
		}

		@Override
		public int compareTo(Paciente otro) {
			int comparacionGravedad = -Integer.compare(this.gravedad, otro.gravedad);
			if (comparacionGravedad != 0)
				return comparacionGravedad;
			return Integer.compare(this.numeroOrden, otro.numeroOrden);
		}

	}

	// La solución usando comparators no funciona en aceptaelreto.com, pero sí
	// funcionaría en local con un compilador lo bastante moderno.
	// private static class ByOrdenPacienteComparator implements
	// Comparator<Paciente> {
	// @Override
	// public int compare(Paciente o1, Paciente o2) {
	// return Integer.compare(o1.numeroOrden, o2.numeroOrden);
	// }
	// }
	//
	// private static class ByGravedadPacienteComparator implements
	// Comparator<Paciente> {
	// @Override
	// public int compare(Paciente o1, Paciente o2) {
	// return -Integer.compare(o1.gravedad, o2.gravedad);
	// }
	// }

	public static void main(String[] args) {
		// Colección de tipo PriorityQueue para mantener a los pacientes ordenados.
		// Se ordena por gravedad (más alta antes) y como criterio secundario por el
		// orden de llegada.
		PriorityQueue<Paciente> pacientes = new PriorityQueue<>();

		try (Scanner scanner = new Scanner(System.in)) {
			int numEventos;
			while ((numEventos = scanner.nextInt()) != 0) {
				// Vaciamos la cola antes de procesar los eventos
				pacientes.clear();

				// Contador para saber la posición en la que llega el paciente
				int ordenLlegada = 0;

				// Procesamos los eventos uno a uno
				while (numEventos > 0) {
					TipoEvento tipo = TipoEvento.valueOf(scanner.next());
					numEventos--;
					ordenLlegada++;
					if (tipo == TipoEvento.I) {
						// Ingreso de paciente
						// Leemos los datos del paciente, creamos el objeto y lo añadimos a la cola de
						// prioridad
						String nombre = scanner.next();
						int gravedad = scanner.nextInt();
						pacientes.add(new Paciente(nombre, gravedad, ordenLlegada));
					} else {
						// Atención a paciente
						// Extraemos el primer paciente de la cola y lo mostramos
						Paciente paciente = pacientes.poll();
						if (paciente != null) {
							System.out.println(paciente.getNombre());
						}
					}

				}

				// Se separan los casos con cuatro guiones
				System.out.println("----");

			}

		}
	}
}
