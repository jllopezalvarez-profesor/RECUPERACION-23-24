package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Producto {
	private int lote;
	private LocalDate fechaCaducidad;
	
	public Producto(int lote, String fechaCaducidad) {
		this.lote = lote;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.fechaCaducidad = LocalDate.parse(fechaCaducidad, formatter);
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return String.format("Lote: %d - Fecha de caducidad: %s", this.lote, formatter.format(this.fechaCaducidad));
	}

}











