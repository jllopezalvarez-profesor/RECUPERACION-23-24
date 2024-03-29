package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos08serializacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo19Serializacion02 {

	private static final String PATH_FICHERO_PERSONAS = "FicherosPrueba" + File.separator + "personas.dat";

	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("00000000A", "Antonio", "López", "10/05/2002"));
		personas.add(new Persona("00000001B", "Carlos", "Jiménez", "22/07/2004"));
		personas.add(new Persona("00000002C", "Alberto", "Pérez", "15/10/1997"));
		personas.add(new Persona("00000003D", "María", "Martínez", "02/01/2000"));

		System.out.println("Lista de personas que vamos a guardar en el fichero.");
		mostrarListaPersonas(personas);
		
		escribirPersonasEnFichero(personas, PATH_FICHERO_PERSONAS);

		List<Persona> personasLeidas = leerPersonasEnFichero(PATH_FICHERO_PERSONAS);

		System.out.println("Lista de personas leidas del fichero.");
		mostrarListaPersonas(personasLeidas);
	}

	private static void mostrarListaPersonas(List<Persona> personasLeidas) {
		for (Persona persona : personasLeidas) {
			System.out.println(persona);
		}
	}

	private static void escribirPersonasEnFichero(List<Persona> personas, String pathFicheroPersonas) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFicheroPersonas))) {
			for (Persona persona : personas) {
				oos.writeObject(persona);
			}
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + pathFicheroPersonas);
		} catch (IOException e) {
			System.err.println("No se ha podido acceder al fichero " + pathFicheroPersonas);
			e.printStackTrace();
		}

	}

	private static List<Persona> leerPersonasEnFichero(String pathFicheroPersonas) {
		List<Persona> personas = new ArrayList<Persona>();

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFicheroPersonas))) {
			boolean eof = false;
			while (!eof) {
				try {
					personas.add((Persona) ois.readObject());

				} catch (EOFException e) {
					eof = true;
				}
			}
		} catch (ClassNotFoundException ex) {
			System.err.println("El objeto leído del fichero " + pathFicheroPersonas + " no es del tipo correcto.");
		} catch (FileNotFoundException e) {
			System.err.println("No se ha podido abrir o crear el fichero " + pathFicheroPersonas);
		} catch (IOException e) {
			System.err.println("No se ha podido acceder al fichero " + pathFicheroPersonas);
			e.printStackTrace();
		}

		return personas;
	}
	
	
}
