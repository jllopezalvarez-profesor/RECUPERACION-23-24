package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos04lanzamiento;

public class Ejemplo01IllegalArgument {

	public static void main(String[] args) {

		double precio = 59.99;
		double porcentajeDescuento = 75;
		double precioRebajado = calcularPrecioRebajado(precio, porcentajeDescuento);

		System.out.printf("El precio ha cambiado de %.2f a %.2f\n", precio, precioRebajado);
	}

	private static double calcularPrecioRebajado(double precio, double porcentajeDescuento) {
		if (porcentajeDescuento < 0 || porcentajeDescuento > 50) {
			// No se pueden hacer descuentos negativos ni superiores al 50%
			throw new IllegalArgumentException();
		}
		return precio * (100 - porcentajeDescuento) / 100;
	}

}
