package es.jllopezalvarez.programacion.ut11.ejemplos.ejemplo02asociacion;

public class Empleado {
	int id;
	String nombre;
	Direccion direccion;

	public Empleado(int id, String name, Direccion address) {
		this.id = id;
		this.nombre = name;
		this.direccion = address;
	}

	public Empleado(int id, String name, String ciudad, String provincia, String pais) {
		this.id = id;
		this.nombre = name;
		this.direccion = new Direccion(ciudad, provincia, pais);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id + " - " + nombre + " - ");
		sb.append(direccion.getCiudad() + " - " + direccion.getProvincia()+ " - " + direccion.getPais());
		return sb.toString();
	}

}
