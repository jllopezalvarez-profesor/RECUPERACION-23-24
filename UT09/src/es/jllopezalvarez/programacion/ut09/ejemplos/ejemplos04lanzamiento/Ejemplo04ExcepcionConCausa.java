package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos04lanzamiento;

public class Ejemplo04ExcepcionConCausa {

	public static void main(String[] args) {

		double precio = 59.99;
		String porcentajeDescuento = "20%";
		double precioRebajado = calcularPrecioRebajado(precio, porcentajeDescuento);

		try {
			System.out.printf("El precio ha cambiado de %.2f a %.2f\n", precio, precioRebajado);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	private static double calcularPrecioRebajado(double precio, String porcentajeDescuento) {
		double porcentaje;
		try {
			porcentaje = Double.parseDouble(porcentajeDescuento);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("El porcentaje no es válido", e);
		}

		if (porcentaje < 0 || porcentaje > 50) {
			throw new IllegalArgumentException("El descuent no puede ser inferior a cero ni superior a cincuenta.");
		}
		return precio * (100 - porcentaje) / 100;
	}

}
