package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio08 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Introduce el nombre del primer fichero: ");
		String nombreF1 = scanner.nextLine();
		Path pathF1 = Path.of("datos", "ficheros", nombreF1);
		System.out.print("Introduce el nombre del segundo fichero: ");
		String nombreF2 = scanner.nextLine();
		Path pathF2 = Path.of("datos", "ficheros", nombreF2);
		System.out.print("Introduce el nombre del fichero de salida: ");
		String nombreF3 = scanner.nextLine();
		Path pathF3 = Path.of("datos", "ficheros", nombreF3);

		// TODO: comprobar que los ficheros F1 y F2 existen, o usar la excepción en el
		// try
		// TODO: comprobar que no existe ya F3, si no se quiere sobrescribir

		try (BufferedReader brF1 = new BufferedReader(new FileReader(pathF1.toFile()));
				BufferedReader brF2 = new BufferedReader(new FileReader(pathF2.toFile()));
				BufferedWriter bw = new BufferedWriter(new FileWriter(pathF3.toFile()))) {
			String sF1;
			String sF2;

			sF1 = brF1.readLine();
			sF2 = brF2.readLine();

			while (sF1 != null && sF2 != null) {

				if (sF1.compareTo(sF2) < 0) {
					bw.write(sF1);
					bw.newLine();
					sF1 = brF1.readLine();
				} else if (sF1.compareTo(sF2) > 0) {
					bw.write(sF2);
					bw.newLine();
					sF2 = brF2.readLine();
				} else {
					bw.write(sF1);
					bw.newLine();
					bw.write(sF2);
					bw.newLine();
					sF1 = brF1.readLine();
					sF2 = brF2.readLine();
				}
			}

			if (sF1 != null) {
				bw.write(sF1);
				bw.newLine();				
				brF1.transferTo(bw);
				
//				do {
//					bw.write(sF1);
//					bw.newLine();
//					sF1 = brF1.readLine();
//				} while (sF1 != null);
			}
			if (sF2 != null) {
				bw.write(sF2);
				bw.newLine();				
				brF2.transferTo(bw);
				
//				do {
//					bw.write(sF2);
//					bw.newLine();
//					sF2 = brF2.readLine();
//				} while (sF2 != null);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
