package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductoFresco extends Producto {
	private String paisOrigen;
	private LocalDate fechaEnvasado;
	
	
	public ProductoFresco(int lote, String fechaCaducidad, String paisOrigen, String fechaEnvasado ) {
		super(lote, fechaCaducidad);
		this.paisOrigen = paisOrigen;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.fechaEnvasado = LocalDate.parse(fechaEnvasado, formatter);
	}
	
	@Override
	public String toString() {
		String textoSuperClase = super.toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("%s - Origen: %s - Fecha de envasado: %s", textoSuperClase, this.paisOrigen, formatter.format(this.fechaEnvasado));
	}
}
