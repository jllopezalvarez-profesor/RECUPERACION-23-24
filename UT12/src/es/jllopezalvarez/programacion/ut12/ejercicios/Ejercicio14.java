package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Scanner;

public class Ejercicio14 {

	private static Scanner scanner = new Scanner(System.in);
	private static final Path FICHERO_BECAS = Path.of("FicherosPrueba", "datosBecas.bin");

	public static void main(String[] args) {
		Becario b = pedirBecarioAUsuario();

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FICHERO_BECAS.toFile(), true))) {
			dos.writeUTF(b.getNombre());
			dos.writeUTF(b.getApellido());
			dos.writeInt(b.getEdad());
			dos.writeInt(b.getNumSuspensos());
			dos.writeBoolean(b.isViveSolo());
			dos.writeDouble(b.getIngresos());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<Becario> lista = new ArrayList<>();
//		lista.add(b);
//
//		lista.sort(new ByEdadBecarioComparator());
//		Collections.sort(lista, new ByEdadBecarioComparator());
//
//		Collections.sort(lista, new Comparator<Becario>() {
//			public int compare(Becario o1, Becario o2) {
//				return Double.compare(o1.ingresos, o2.ingresos);
//			}
//		});
//
//		Collections.sort(lista, (o1, o2) -> Double.compare(o1.ingresos, o2.ingresos));

	}

	private static Becario pedirBecarioAUsuario() {
		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Apellido: ");
		String apellido = scanner.nextLine();
		System.out.print("Edad: ");
		int edad = Integer.parseInt(scanner.nextLine());
		System.out.print("Nº de suspensos: ");
		int numSuspensos = Integer.parseInt(scanner.nextLine());
		System.out.print("Vive solo (S/N): ");
		boolean viveSolo = scanner.nextLine().equals("S") ? true : false;
		System.out.print("Ingresos: ");
		double ingresos = Double.parseDouble(scanner.nextLine());

		Becario b = new Becario(nombre, apellido, edad, numSuspensos, viveSolo, ingresos);
		return b;
	}

	private static class ByEdadBecarioComparator implements Comparator<Becario> {

		@Override
		public int compare(Becario o1, Becario o2) {
			return Integer.compare(o1.getEdad(), o2.getEdad());
		}

	}

}
