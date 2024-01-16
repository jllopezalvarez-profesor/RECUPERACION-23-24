package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio02;

import java.time.LocalDate;

public class Fecha {
	private static final int MES_FEBRERO = 2;
	private static final int NUM_MESES = 12;
	private static final int[] DIAS_MES = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private int dia;
	private int mes;
	private int anio;

	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	public Fecha() {
		LocalDate hoy = LocalDate.now();
		this.dia = hoy.getDayOfMonth();
		this.mes = hoy.getMonthValue();
		this.anio = hoy.getYear();
	}

	public Fecha(Fecha fecha) {
		this(fecha.dia, fecha.mes, fecha.anio);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public boolean fechaCorrecta() {
		if (this.anio == 0 || this.mes < 1 || this.mes > NUM_MESES || this.dia < 1) {
			return false;
		}
		int ultimoDiaMes = getUltimoDiaMes();
		return (this.dia <= ultimoDiaMes);
	}

	private int getUltimoDiaMes() {
		int ultimoDiaMes = DIAS_MES[this.mes - 1];
		if (this.mes == MES_FEBRERO && esBisiesto()) {
			ultimoDiaMes++;
		}
		return ultimoDiaMes;
	}

	private boolean esBisiesto() {
		return (((this.anio % 4 == 0) && (this.anio % 100 != 0)) || (this.anio % 400 == 0));
	}

	public void diaSiguiente() {
		int ultimoDiaMes = getUltimoDiaMes();
		this.dia++;
		if (this.dia > ultimoDiaMes) {
			this.dia = 1;
			this.mes++;
			if (this.mes > NUM_MESES) {
				this.mes = 1;
				this.anio++;
				if (this.anio == 0) {
					this.anio = 1;
				}
			}
		}
	}

	public boolean esMayorQue(Fecha otra) {
		if (otra == null) {
			throw new IllegalArgumentException("La fecha a comparar no puede ser nula");
		}

		int valorComparacion = Integer.compare(this.anio, otra.anio);
		if (valorComparacion == 0) {
			valorComparacion = Integer.compare(this.mes, otra.mes);
			if (valorComparacion == 0) {
				valorComparacion = Integer.compare(this.dia, otra.dia);
			}
		}

		return valorComparacion > 0;
	}

	public String toString() {
		return String.format("%02d-%02d-%d", this.dia, this.mes, this.anio);
	}

}
