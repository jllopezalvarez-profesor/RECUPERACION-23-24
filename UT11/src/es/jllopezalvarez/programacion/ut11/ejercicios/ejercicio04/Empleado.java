package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04;

public class Empleado {
	private String nombre;

//	public Empleado() {
//		System.out.println("En el constructor por defecto de Empleado");
//	}
	
	public Empleado(String nombre) {
		//System.out.println("En el constructor con parámetro de Empleado");
		this.nombre = nombre;
		// this.setNombre(nombre);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return String.format("Empleado %s", this.nombre);
	}

}
