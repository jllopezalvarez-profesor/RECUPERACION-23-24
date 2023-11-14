package ejemplos;

import java.util.Scanner;

public class EjemploTernario {
	private final static int VALOR_MAXIMO = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		String mensaje;

		if (n > VALOR_MAXIMO) {
			mensaje = "El número está por encima del máximo";
		} else {
			mensaje = "El número no está por encima del máximo";
		}
		System.out.println(mensaje);

		mensaje = (n > VALOR_MAXIMO) ? "El número está por encima del máximo"
				: "El número no está por encima del máximo";
		System.out.println(mensaje);

		mensaje = String.format("El número %sestá por encima del máximo", (n > VALOR_MAXIMO) ? "" : "no ");
		System.out.println(mensaje);

	}
}
