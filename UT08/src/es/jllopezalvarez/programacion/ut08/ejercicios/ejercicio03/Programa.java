package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio03;

import java.util.List;

public class Programa {
	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria();

		cuenta.ingresar(100, "Ingreso");
		cuenta.ingresar(200, "Ingreso");
		cuenta.ingresar(300, "Ingreso");

		System.out.printf("Saldo: %f\n", cuenta.getSaldo());

		List<Movimiento> movimientos = cuenta.getMovimientos();

		mostrarMovimientos(movimientos);

		movimientos.add(new Movimiento(TipoMovimiento.INGRESO, cuenta.getSaldo(), 2000, "Trampa"));


		System.out.printf("Saldo: %f\n", cuenta.getSaldo());

		mostrarMovimientos(movimientos);

		Movimiento movimientoFinal = movimientos.get(movimientos.size() - 2);
		movimientoFinal.setSaldoFinal(1000);

		System.out.printf("Saldo: %f\n", cuenta.getSaldo());

		mostrarMovimientos(movimientos);

	}

	private static void mostrarMovimientos(List<Movimiento> movimientos) {
		for (Movimiento movimiento : movimientos) {
			System.out.print(" " + movimiento.getSaldoFinal());
		}
		System.out.println();
	}
}
