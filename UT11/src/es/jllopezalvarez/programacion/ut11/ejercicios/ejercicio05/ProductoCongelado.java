package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio05;

public class ProductoCongelado extends Producto {
	private int temperaturaConservacion;

	public ProductoCongelado(int lote, String fechaCaducidad, int temperaturaConservacion) {
		super(lote, fechaCaducidad);
		this.temperaturaConservacion = temperaturaConservacion;
	}

	public int getTemperaturaConservacion() {
		return temperaturaConservacion;
	}

	public void setTemperaturaConservacion(int temperaturaConservacion) {
		this.temperaturaConservacion = temperaturaConservacion;
	}
	
	public String toString() {
		String textoSuperClase = super.toString();
		return String.format("%s - Temperatura de conservación: %d", textoSuperClase, this.temperaturaConservacion);
	}
	
	
}
