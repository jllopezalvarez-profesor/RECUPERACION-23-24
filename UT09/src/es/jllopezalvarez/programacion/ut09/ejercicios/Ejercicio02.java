package es.jllopezalvarez.programacion.ut09.ejercicios;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio02 {

	private static final int MAX_LIMITE_INFERIOR = 500;
	private static final int MIN_LIMITE_SUPERIOR = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int limiteInferior;
		int limiteSuperior;
		do {
			limiteInferior = pedirLimiteInferior(scanner);
			limiteSuperior = pedirLimiteSuperior(scanner);
			if (limiteInferior >= limiteSuperior) {
				System.out.println("A tiene que ser menor que B. Vuelve a introducir los dos números.");
			}
		} while (limiteInferior >= limiteSuperior);

		// Calcular valor aleatorio
		Random rnd = new Random();
		int numeroSecreto = rnd.nextInt(limiteInferior, limiteSuperior + 1);

		// Damos un valor por defecto a numeroUsuario.
		// Si no lo hacemos, Java nos indicará error por usar variables que pueden no
		// haber sido inicializadas.
		int numeroUsuario = Integer.MAX_VALUE;
		int intentos = 0;

		do {
			System.out.print("Introduce un número: ");
			try {
				intentos++;
				numeroUsuario = Integer.parseInt(scanner.nextLine());
				if (numeroUsuario != numeroSecreto) {
					// No ha acertado. Vamos a ver los tres posibles fallos...
					if (numeroUsuario < limiteInferior || numeroUsuario > limiteSuperior) {
						// El número no está en el rango que se ha definido al principio.
						System.out.printf("El número introducido no está entre %d y %d ambos incluidos.\n",
								limiteInferior, limiteSuperior);
					} else if (numeroUsuario < numeroSecreto) {
						// El número que hay que acertar es mayor
						System.out.println("Te has quedado corto. El número es mayor.");
					} else {
						// El número que hay que acertar es menor
						System.out.println("Te has pasado. El número es menor.");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("El valor introducido no es un número.");
			}
			System.out.printf("Este ha sido tu intento nº %d.\n", intentos);
		} while (numeroUsuario != numeroSecreto);

		System.out.printf("¡Acertaste! Has necesitado %d intentos.\n", intentos);

		scanner.close();
	}

	private static int pedirLimiteInferior(Scanner scanner) {
		int limiteInferior;
		limiteInferior = Integer.MAX_VALUE;

		do {
			System.out.printf("Introduce un valor para A, no superior a %d\n", MAX_LIMITE_INFERIOR);
			try {
				limiteInferior = Integer.parseInt(scanner.nextLine());
				if (limiteInferior > MAX_LIMITE_INFERIOR) {
					System.out.println("El valor introducido es demasiado alto");
				}
			} catch (NumberFormatException e) {
				System.out.println("El valor introducido no es válido");
			}

		} while (limiteInferior > MAX_LIMITE_INFERIOR);
		return limiteInferior;
	}

	private static int pedirLimiteSuperior(Scanner scanner) {
		int limiteSuperior;
		limiteSuperior = Integer.MIN_VALUE;

		do {
			System.out.printf("Introduce un valor para B, no inferior a %d\n", MIN_LIMITE_SUPERIOR);
			try {
				limiteSuperior = Integer.parseInt(scanner.nextLine());
				if (limiteSuperior < MIN_LIMITE_SUPERIOR) {
					System.out.println("El valor introducido es demasiado bajo");
				}
			} catch (NumberFormatException e) {
				System.out.println("El valor introducido no es válido");
			}

		} while (limiteSuperior < MIN_LIMITE_SUPERIOR);
		return limiteSuperior;
	}

}
