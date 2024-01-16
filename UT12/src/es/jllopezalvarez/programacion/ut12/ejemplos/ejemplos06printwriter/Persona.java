package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos06printwriter;

import java.util.ArrayList;
import java.util.List;

import net.datafaker.Faker;

public class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private String mascota;
	double puntuacion;

	// Datafaker para conseguir datos aleatorios
	private static Faker faker = new Faker();

	public Persona(int id, String nombre, String apellido, String mascota, double puntuacion) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mascota = mascota;
		this.puntuacion = puntuacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getMascota() {
		return mascota;
	}

	public void setMascota(String mascota) {
		this.mascota = mascota;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	public static List<Persona> generarPersonasAleatorias(int cantidad) {
		List<Persona> personas = new ArrayList<>(cantidad);
		
		while(cantidad > 0) {
			int idNuevo = faker.random().nextInt(0, 1_000_000);
			String nombreNuevo = faker.name().firstName();
			String apellidoNuevo = faker.name().lastName();
			String mascotaNuevo = faker.animal().name();
			Double puntuacionNuevo = faker.random().nextDouble(0, 10);
			personas.add(new Persona(idNuevo, nombreNuevo, apellidoNuevo, mascotaNuevo, puntuacionNuevo));
			cantidad--;
		}

		return personas;
	}
}