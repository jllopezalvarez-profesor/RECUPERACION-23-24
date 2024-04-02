package org.pendientes.febrero.ejercicio02;

import java.time.LocalDate;

public class EmpleadoFijo extends Empleado {

	public EmpleadoFijo(String dni, String nombre, String apellidos, double sueldoAnualEuros) {
		super(dni, nombre, apellidos, sueldoAnualEuros);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoFijo(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion,
			double sueldoAnualEuros) {
		super(dni, nombre, apellidos, fechaIncorporacion, sueldoAnualEuros);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoFijo(String dni, String nombre, String apellidos, LocalDate fechaIncorporacion) {
		super(dni, nombre, apellidos, fechaIncorporacion);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoFijo(String dni, String nombre, String apellidos) {
		super(dni, nombre, apellidos);
		// TODO Auto-generated constructor stub
	}



	@Override
	public double getCotizacionDesempleo() {
		return this.getSueldoAnualEuros() / 12 * 0.0095;
	}

}
