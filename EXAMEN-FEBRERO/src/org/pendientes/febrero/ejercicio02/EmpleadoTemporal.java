package org.pendientes.febrero.ejercicio02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmpleadoTemporal extends Empleado {
	private final LocalDate fechaFinContrato;

	public EmpleadoTemporal(String dni, String nombre, String apellidos, double sueldoAnualEuros) {
		super(dni, nombre, apellidos, sueldoAnualEuros);
		this.fechaFinContrato = LocalDate.now().plusMonths(6);
	}

	public EmpleadoTemporal(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion,
			double sueldoAnualEuros) {
		super(dni, nombre, apellidos, fechaIncorporacion, sueldoAnualEuros);
		this.fechaFinContrato = LocalDate.now().plusMonths(6);
	}

	public EmpleadoTemporal(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion) {
		super(dni, nombre, apellidos, fechaIncorporacion);
		this.fechaFinContrato = LocalDate.now().plusMonths(6);
	}

	public EmpleadoTemporal(String dni, String nombre, String apellidos) {
		super(dni, nombre, apellidos);
		this.fechaFinContrato = LocalDate.now().plusMonths(6);
	}

	public EmpleadoTemporal(String dni, String nombre, String apellidos, double sueldoAnualEuros,
			LocalDate fechaFinContrato) {
		super(dni, nombre, apellidos, sueldoAnualEuros);
		this.fechaFinContrato = fechaFinContrato;
	}

	public EmpleadoTemporal(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion,
			double sueldoAnualEuros, LocalDate fechaFinContrato) {
		super(dni, nombre, apellidos, fechaIncorporacion, sueldoAnualEuros);
		this.fechaFinContrato = fechaFinContrato;
	}

	public EmpleadoTemporal(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion,
			LocalDate fechaFinContrato) {
		super(dni, nombre, apellidos, fechaIncorporacion);
		this.fechaFinContrato = fechaFinContrato;
	}

	public EmpleadoTemporal(String dni, String nombre, LocalDate fechaFinContrato, String apellidos) {
		super(dni, nombre, apellidos);
		this.fechaFinContrato = fechaFinContrato;
	}

	public LocalDate getFechaFinContrato() {
		return fechaFinContrato;
	}



	@Override
	public double getCotizacionDesempleo() {
		return this.getSueldoAnualEuros() / 12 * 0.0075;
	}

	public long getTiempoRestanteContrato() {
		return ChronoUnit.DAYS.between(this.getFechaIncorporacion(), this.fechaFinContrato);
	}
	
}
