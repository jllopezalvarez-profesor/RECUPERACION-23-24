package es.jllopezalvarez.programacion.ut11.ejemplos.ejemplo03bcopiadefensiva;

public class Empleado {
	private int id;
	private String nombre;
	private Direccion direccion;

	public Empleado(int id, String name, Direccion address) {
		this.id = id;
		this.nombre = name;
		// Problema: nos quedamos con la referencia a un objeto que ya existe fuera del
		// empleado. 
		//this.direccion = address;
		// Solución: copia defensiva
		this.direccion = new Direccion(address);
	}

	public Empleado(int id, String name, String ciudad, String provincia, String pais) {
		this.id = id;
		this.nombre = name;
		this.direccion = new Direccion(ciudad, provincia, pais);
	}

	/**
	 * Devuelve la dirección del empleado.
	 * @return una copia de la dirección del empleado
	 */
	public Direccion getDireccion() {
		// Problema: devuelvo referencia  mi atributo
		// return this.direccion;
		// Solución: copia defensiva
		return new Direccion(this.direccion);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id + " - " + nombre + " - ");
		sb.append(direccion.getCiudad() + " - " + direccion.getProvincia() + " - " + direccion.getPais());
		return sb.toString();
	}

}
