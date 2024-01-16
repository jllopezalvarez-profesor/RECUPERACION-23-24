package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio02;

public class Persona {
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String ciudad;
	private Fecha fechaNacimiento;

	public Persona(String nombre, String direccion, String codigoPostal, String ciudad, Fecha fechaNacimiento) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.fechaNacimiento = new Fecha(fechaNacimiento);
	}

	public boolean esMayorEdad() {
		Fecha hoy = new Fecha();
		Fecha fechaNacMayorEdad = new Fecha(hoy.getDia(), hoy.getMes(), hoy.getAnio() - 18);
		return (this.fechaNacimiento.getAnio() < fechaNacMayorEdad.getAnio())
				|| (this.fechaNacimiento.getAnio() == fechaNacMayorEdad.getAnio()
						&& this.fechaNacimiento.getMes() < fechaNacMayorEdad.getMes())
				|| (this.fechaNacimiento.getAnio() == fechaNacMayorEdad.getAnio()
						&& this.fechaNacimiento.getMes() == fechaNacMayorEdad.getMes()
						&& this.fechaNacimiento.getDia() <= fechaNacMayorEdad.getDia());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Nombre: %s.\n", this.nombre));
		sb.append(String.format("Fecha de nacimiento: %s.\n", this.fechaNacimiento));
		sb.append(String.format("Direccion: %s.\n", this.direccion));
		sb.append(String.format("Nombre: %s.\n", this.nombre));
		return super.toString();
	}

}
