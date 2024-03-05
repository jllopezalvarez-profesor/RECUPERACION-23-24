package org.pendientes.febrero.ejercicio01;

import java.util.Scanner;

public class Programa2Ejercicio1 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		char orden, cuales;
		int limInf, limSup;

		System.out.println("Introduce limite inferior");
		limInf = sc.nextInt();
		System.out.println("Introduce limite superior");
		limSup = sc.nextInt();

		System.out.println("Se mostraran en orden creciente o decreciente ('c'/'d')");
		orden = sc.next().charAt(0);

		System.out.println("Se mostraran todos o solo los pares ('t'/'p')");
		cuales = sc.next().charAt(0);

		// Dentro del if escribe la condición que nos permite llamar al método
		// pedido en el enunciado.
		// Es decir, que la variable 'orden' tiene los valores permitidos,
		// la variable 'cuales' tiene los valores permitidos
		// y el límite inferior es menor que el superior
		if ((orden == 'c' || orden == 'd') && (cuales == 't' || cuales == 'p') && (limInf < limSup))
			mostrarNumerosIntervalo(limInf, limSup, orden, cuales);
		else { // rellena la condición adecuada en cada caso
			if (limInf >= limSup)
				System.out.println("El limite superior debe ser mayor que el   inferior ");
			if ((orden != 'c' && orden != 'd'))
				System.out.println("El orden debe ser c o d ");
			if (!(cuales == 't' || cuales == 'p'))
				System.out.println("El valor de cuales se muestran debe ser t o p ");
		}
	}

	// Escribe el cuerpo del método que muestra por consola los valores dentro del
	// intervalo [lInf, lSup] ajustándose a las condiciones pedidas por el usuario y
	// explicadas en el enunciado
	/**
	 * 
	 * @param lInf limite inferior del intervalo
	 * @param lSup limite superior del intervalo
	 * @param o    caracter que indica el orden ascendente o descendente
	 * @param c    caracter que indica si se muestran todos los numeros o solo los
	 *             pares
	 */
	public static void mostrarNumerosIntervalo(int lInf, int lSup, char o, char c) {

		if (o == 'c') {
			for (int numero = lInf; numero <= lSup; numero++) {
				if (c == 't') {
					System.out.printf("%d ", numero);
				} else {
					if (numero % 2 == 0) {
						System.out.printf("%d ", numero);
					}
				}
			} 
		} else {
			for (int numero = lSup; numero >= lInf; numero--) {
				if (c == 't') {
					System.out.printf("%d ", numero);
				} else {
					if (numero % 2 == 0) {
						System.out.printf("%d ", numero);
					}
				}
			} 
		}
		
		// ...........................................................

	}
}
