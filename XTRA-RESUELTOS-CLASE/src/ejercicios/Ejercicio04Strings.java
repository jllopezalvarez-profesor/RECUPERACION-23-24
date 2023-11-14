package ejercicios;

public class Ejercicio04Strings {
	public static void main(String[] args) {

		String cadenaOriginal = "murciélago";
		String cadenaInversa = invertirCadena(cadenaOriginal);

		System.out.printf("'%s' se convierte en '%s' al invertirla en orden 'normal'\n", cadenaOriginal, cadenaInversa);

		cadenaInversa = invertirCadena2(cadenaOriginal);
		System.out.printf("'%s' se convierte en '%s' al invertirla en orden 'inverso'\n", cadenaOriginal,
				cadenaInversa);

		cadenaInversa = invertirCadenaConArray(cadenaOriginal);
		System.out.printf("'%s' se convierte en '%s' al invertirla con un array\n", cadenaOriginal, cadenaInversa);

		cadenaInversa = invertirCadenaConStringBuilder(cadenaOriginal);
		System.out.printf("'%s' se convierte en '%s' al invertirla con un StringBuilder en orden 'normal'\n",
				cadenaOriginal, cadenaInversa);

		cadenaInversa = invertirCadenaConStringBuilder2(cadenaOriginal);
		System.out.printf("'%s' se convierte en '%s' al invertirla con un StringBuilder en orden 'inverso'\n",
				cadenaOriginal, cadenaInversa);

	}

	private static String invertirCadena(String s) {
		if (s == null) {
			return null;
		}
		String nueva = "";
		for (int i = 0; i < s.length(); i++) {
			nueva = s.charAt(i) + nueva;
		}
		return nueva;
	}

	private static String invertirCadena2(String s) {
		if (s == null) {
			return null;
		}
		String nueva = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			nueva += s.charAt(i);
		}
		return nueva;
	}

	private static String invertirCadenaConArray(String s) {
		if (s == null) {
			return null;
		}
		char[] caracteres = s.toCharArray();
		invertirArray(caracteres);
		return new String(caracteres);
	}

	private static void invertirArray(char[] numeros) {

		int posInicial = 0;
		int posFinal = numeros.length - 1;

		while (posFinal > posInicial) {
			char aux = numeros[posFinal];
			numeros[posFinal] = numeros[posInicial];
			numeros[posInicial] = aux;
			posInicial++;
			posFinal--;
		}
	}

	private static String invertirCadenaConStringBuilder(String s) {
		if (s == null) {
			return null;
		}
		StringBuilder nueva = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			nueva = nueva.insert(0, s.charAt(i));
		}
		return nueva.toString();
	}

	private static String invertirCadenaConStringBuilder2(String s) {
		if (s == null) {
			return null;
		}
		// Si creamos el StringBuilder con la capacidad necesaria
		// Se ahorrará tener que ir copiando el array cuando lo llene.
		StringBuilder nueva = new StringBuilder(s.length()); 
		for (int i = s.length() - 1; i >= 0; i--) {
			nueva = nueva.append(s.charAt(i));
		}
		return nueva.toString();
	}

	
	
}
