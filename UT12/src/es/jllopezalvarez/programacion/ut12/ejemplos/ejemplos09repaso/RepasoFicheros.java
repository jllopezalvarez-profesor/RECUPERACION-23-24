package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos09repaso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepasoFicheros {

	private static final Path PATH_FICHERO = Path.of("datos", "ficheros", "DatosFicheroRepaso.txt");
	private static final Path PATH_FICHERO_BINARIO = Path.of("datos", "ficheros",
			"DatosFicheroRepaso.bin");
	private static final Path PATH_FICHERO_BINARIO_SERIALIZADO = Path.of("datos", "ficheros",
			"DatosFicheroRepasoSerializado.bin");
	private static final Path PATH_FICHERO_INFORME = Path.of("datos", "ficheros", "informes",
			"repaso", "DatosFicheroRepasoInforme.txt");

	public static void main(String[] args) {

		// 1- Comprobar que existe el fichero. Si no, se sale del programa
		if (!existeFichero(PATH_FICHERO)) {
			System.out.printf("No existe el fichero %s", PATH_FICHERO);
			return;
		}

		// 2- Leer el fichero y crear una lista de personas
		System.out.println("Leyendo fichero de texto...");
		List<Persona> personas = leerPersonasDeTexto(PATH_FICHERO);
		mostrarListaPersonas(personas);

		// 3- Guardar la lista de personas en un fichero binario usando DOS
		System.out.println("Escribiendo fichero binario...");
		escribirPersonasEnBinario(personas, PATH_FICHERO_BINARIO);

		// 4- Leer el fichero binario con DIS y crear una nueva lista de personas
		System.out.println("Leyendo fichero binario...");
		personas = leerPersonasDeBinario(PATH_FICHERO_BINARIO);
		mostrarListaPersonas(personas);

		// 5- Guardar la lista en un fichero binario, pero serializando (OOS)
		System.out.println("Escribiendo fichero binario serializado...");
		escribirPersonasEnBinarioSerializado(personas, PATH_FICHERO_BINARIO_SERIALIZADO);

		// 6- Leer el fichero binario con OIS y crear una nueva lista
		System.out.println("Leyendo fichero binario serializado...");
		personas = leerPersonasDeBinarioSerializado(PATH_FICHERO_BINARIO_SERIALIZADO);
		mostrarListaPersonas(personas);

		// 7- Escribir un informe en texto de la lista.
		generarInformePersonas(personas, PATH_FICHERO_INFORME);

	}

	private static void generarInformePersonas(List<Persona> personas, Path pathFicheroInforme) {

		File fichero = pathFicheroInforme.toFile();

		fichero.getParentFile().mkdirs();

		try (PrintWriter pw = new PrintWriter(fichero)) {
			pw.println("-".repeat(65));
			pw.printf("| %5s | %-10.10s | %-10.10s | %16s | %8s |\n", "ID", "NOMBRE", "APELLIDO", "FECHA NACIMIENTO", "ESTATURA");
			
			for (Persona persona : personas) {
				pw.println("-".repeat(65));
				pw.printf("| %5d | %-10.10s | %-10.10s | %16s | %8.2f |\n", persona.getId(), persona.getNombre(),
						persona.getApellido(), persona.getFechaNacimiento(),
						((double)persona.getEstaturaEnCm()/100));
			}
			pw.println("-".repeat(65));

		} catch (FileNotFoundException e) {
			throw new RuntimeException("No se ha podido escribir en el fichero de informe", e);
		}

	}

	private static List<Persona> leerPersonasDeBinarioSerializado(Path pathFichero) {
		List<Persona> personas = new ArrayList<>();

		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(pathFichero.toFile()))) {
			while (true) {
				Persona p = (Persona) ois.readObject();
				personas.add(p);
			}

		} catch (EOFException e) {
			// No hacemos nada porque es normal que salte la excepción al llegar al final
			// del fichero.
		} catch (IOException e) {
			throw new RuntimeException("Error al leer fichero binario serializado", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Clase no existe al leer fichero binario serializado", e);
		}

		return personas;
	}

	private static void escribirPersonasEnBinarioSerializado(List<Persona> personas,
			Path pathFichero) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(pathFichero.toFile()))) {
			for (Persona persona : personas) {
				oos.writeObject(persona);
			}
		} catch (IOException e) {
			throw new RuntimeException("Error al escribir en fichero binario serializado", e);
		}

	}

	private static List<Persona> leerPersonasDeBinario(Path pathFicheroBinario) {
		List<Persona> personas = new ArrayList<>();

		try (DataInputStream dis = new DataInputStream(
				new FileInputStream(pathFicheroBinario.toFile()))) {
			while (true) {
				int id = dis.readInt();
				String nombre = dis.readUTF();
				String apellido = dis.readUTF();
				String fechaNacimiento = dis.readUTF();
				int estatura = dis.readInt();

				Persona p = new Persona(id, nombre, apellido, LocalDate.parse(fechaNacimiento),
						estatura);
				personas.add(p);
			}
		} catch (EOFException e) {
			// No hacemos nada porque es normal que salte esta excepción al llegar al final,
			// y así salimos dle buvle while infinito
		} catch (IOException e) {
			throw new RuntimeException("Error al leer del fichero binario", e);
		}

		return personas;
	}

	private static void escribirPersonasEnBinario(List<Persona> personas, Path pathFicheroBinario) {

		try (FileOutputStream fos = new FileOutputStream(pathFicheroBinario.toFile());
				DataOutputStream dos = new DataOutputStream(fos)) {
			for (Persona persona : personas) {
				dos.writeInt(persona.getId());
				dos.writeUTF(persona.getNombre());
				dos.writeUTF(persona.getApellido());
				dos.writeUTF(persona.getFechaNacimiento().toString());
				dos.writeInt(persona.getEstaturaEnCm());
			}

		} catch (IOException e) {
			throw new RuntimeException("Error al escribir en el fichero binario", e);
		}

	}

	private static void mostrarListaPersonas(List<Persona> personas) {
		System.out.println("======================================");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		System.out.println("======================================");
	}

	private static List<Persona> leerPersonasDeTexto(Path pathFichero) {
		List<Persona> personas = new ArrayList<>();

		// try (Scanner scanner = new Scanner(pathFichero)) {
		// try (Scanner scanner = new Scanner(new BufferedInputStream(new
		// FileInputStream(pathFichero.toFile())))) {
		try (Scanner scanner = new Scanner(pathFichero)) {
			while (scanner.hasNext()) {
				int id = scanner.nextInt();
				String nombre = scanner.next();
				String apellido = scanner.next();
				String fechaNacimiento = scanner.next();
				int estatura = scanner.nextInt();

				Persona p = new Persona(id, nombre, apellido, LocalDate.parse(fechaNacimiento),
						estatura);
				personas.add(p);
			}
		} catch (IOException e) {
			throw new RuntimeException("Error al leer el fichero de texto", e);
		}

		return personas;
	}

	private static boolean existeFichero(Path pathFichero) {
		return pathFichero.toFile().exists();
	}

	private static boolean existeFichero(String pathFichero) {
		File fichero = new File(pathFichero);
		return fichero.exists();
	}

}
