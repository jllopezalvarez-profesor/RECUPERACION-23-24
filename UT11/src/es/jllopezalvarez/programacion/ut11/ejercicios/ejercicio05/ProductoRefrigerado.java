package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio05;

import java.time.format.DateTimeFormatter;

public class ProductoRefrigerado extends Producto {
	private String orgSupervisor;

	public ProductoRefrigerado(int lote, String fechaCaducidad, String orgSupervisor) {
		super(lote, fechaCaducidad);
		this.orgSupervisor = orgSupervisor;
	}

	public String getOrgSupervisor() {
		return orgSupervisor;
	}

	public void setOrgSupervisor(String orgSupervisor) {
		this.orgSupervisor = orgSupervisor;
	}

	@Override
	public String toString() {
		String textoSuperClase = super.toString();
		return String.format("%s - Organismo supervisor: %s", textoSuperClase, this.orgSupervisor);
	}


}
