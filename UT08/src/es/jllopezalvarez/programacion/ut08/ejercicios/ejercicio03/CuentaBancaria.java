package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio03;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

	private static long siguienteNumeroCuenta = 100000000000L;

	private long numeroDeCuenta;
	private ArrayList<Movimiento> movimientos;

	public CuentaBancaria(double saldoInicial) {
		this.numeroDeCuenta = CuentaBancaria.siguienteNumeroCuenta++;
		this.movimientos = new ArrayList<>();
		this.movimientos.add(new Movimiento(TipoMovimiento.INGRESO, 0, saldoInicial, "Ingreso por apertura de cuenta"));
	}

	public CuentaBancaria() {
		this(0);
	}

	public double getSaldo() {
		return this.movimientos.get(this.movimientos.size() - 1).getSaldoFinal();
	}

	public void ingresar(double importe, String concepto) {
		this.movimientos.add(new Movimiento(TipoMovimiento.INGRESO, this.getSaldo(), importe, concepto));

	}

	public List<Movimiento> getMovimientos() {
		ArrayList<Movimiento> resultado = new ArrayList<>();
		for (Movimiento movimiento : this.movimientos) {
			resultado.add((Movimiento) movimiento.clone());
		}
		return resultado;
	}

}
