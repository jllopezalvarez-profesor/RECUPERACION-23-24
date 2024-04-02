package org.pendientes.febrero.ejercicio02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Empleado extends Persona implements Cotizable {
	private static final int SUELDO_DEFECTO = 24000;

	private final LocalDate fechaIncorporacion;
	private final double sueldoAnualEuros;

	public Empleado(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion,
			double sueldoAnualEuros) {
		super(dni, nombre, apellidos);
		this.fechaIncorporacion = fechaIncorporacion;
		this.sueldoAnualEuros = sueldoAnualEuros;
	}

	public Empleado(String dni, String nombre, String apellidos, double sueldoAnualEuros) {
		super(dni, nombre, apellidos);
		this.fechaIncorporacion = LocalDate.now();
		this.sueldoAnualEuros = sueldoAnualEuros;
	}

	public Empleado(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion) {
		this(dni, nombre, apellidos, fechaIncorporacion, SUELDO_DEFECTO);
	}

	public Empleado(String dni, String nombre, String apellidos) {
		this(dni, nombre, apellidos, LocalDate.now(), SUELDO_DEFECTO);
	}

	public LocalDate getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public double getSueldoAnualEuros() {
		return sueldoAnualEuros;
	}

	public long getAntiguedad() {
		return ChronoUnit.MONTHS.between(fechaIncorporacion, LocalDate.now());
	}

	public double getIrpf() {
		return this.sueldoAnualEuros / 12 * 0.2;
	}

	@Override
	public double getCotizacionSeguridadSocial() {
		return this.getSueldoAnualEuros() / 12 * 0.05;
	}
}
