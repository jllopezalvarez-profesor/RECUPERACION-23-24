package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio03;

import java.time.LocalDateTime;

public class Movimiento  implements Cloneable {
	private TipoMovimiento tipo;
	private LocalDateTime fecha;
	private double saldoInicial;
	private double importe;
	private double saldoFinal;
	private String concepto;

	public Movimiento(TipoMovimiento tipo, double saldoInicial, double importe, String concepto) {
		this.tipo = tipo;
		this.saldoInicial = saldoInicial;
		this.importe = importe;
		this.concepto = concepto;
		this.saldoFinal = this.saldoInicial + importe;
		this.fecha = LocalDateTime.now();
	}

	public TipoMovimiento getTipo() {
		return tipo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public double getImporte() {
		return importe;
	}

	public double getSaldoFinal() {
		return saldoFinal;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setSaldoFinal(double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("No se pueden clonar movimientos");
		}
	}

}
