package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio13 {

	private static final Path PATH_FICHERO = Path.of("FicherosPrueba", "ficheroBinario.dat");
	private static Scanner scanner = new Scanner(System.in);
	private static Random rnd = new Random();

	public static void main(String[] args) {

		int cantidadNumeros = 5;

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(PATH_FICHERO.toFile(), true))) {
			for (int i = 0; i < cantidadNumeros; i++) {
				dos.writeInt(rnd.nextInt(0, 101));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (DataInputStream dis = new DataInputStream(new FileInputStream(PATH_FICHERO.toFile()))) {
			int numLeidos = 0;
			while (true) {
				int numero = dis.readInt();
				System.out.printf("%d ", numero);
				numLeidos++;
				if (numLeidos % 20 == 0) {
					System.out.println();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// Vacío intencionadamente porque es el control de fin de fichero
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
