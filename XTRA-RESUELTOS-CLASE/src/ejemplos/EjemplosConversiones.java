package ejemplos;

import java.util.Scanner;

public class EjemplosConversiones {
	public static void main(String[] args) {
		double numeroReal = 234.343;
		
		int numeroEntero = (int) numeroReal;
		
		System.out.printf("Número real: %f\n", numeroReal);
		System.out.printf("Número entero: %d\n", numeroEntero);
		
		int sumaValores = 30;
		int cuentaValores = 17;
		double media = (double)sumaValores/cuentaValores;
		System.out.printf("Media: %f\n", media);
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduce un número con decimales");

		double numeroDobleScanner = scanner.nextDouble();
		
		System.out.println(numeroDobleScanner);
		
		
		System.out.println("Introduce un número entero");
		numeroEntero = scanner.nextInt();
		System.out.println(numeroEntero);
		

		System.out.println("Introduce un número con dcimales que convertiré a entero");
		numeroEntero = (int)scanner.nextDouble();
		System.out.println(numeroEntero);

		
		
	}
}
