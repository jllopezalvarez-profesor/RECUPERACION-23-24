package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio23;

import java.util.Random;

public enum Madera {

	ABETO("Abeto", 1.5, "Clara. Fácil de trabajar. Resistente a la humedad."),
	PINO("Pino", 2.4, "Clara. Barata. Fácil de trabajar."),
	CEDRO_ROJO("Cedro rojo", 1.3, "Rojiza. Moderadamente barata. Muy resistente a la humedad."),
	HAYA("Haya", 4, "Clara. Oscurece al envejecer. Dura, pero fácil de trabajar."),
	NOGAL("Nogal", 3.8, "Oscura. Bastante cara. Muy resistente."),
	CEREZO("Cerezo", 4.2, "Rojo intenso. Bastante cara. De duración media."),
	ROBLE_BLANCO("Roble blanco", 5.1, "Blanca. Bastante cara. Muy resistente. Difícil de trabajar."),
	CAOBA("Caoba", 2.7, "Marrón rojizo. Cara. Muy resistente pero fácil de trabajar."),
	TECA("Teca", 4.1, "Amarillenta, oscurece con el tiempo. Cara. Resistente humedad y putrefacción.");
	
	private static final Random RND = new Random();
	private static final Madera[] NUM_MADERAS_DIFERENTES = Madera.values();
	
	private String nombre;
	private double dureza;
	private String caracteristicas;

	private Madera(String nombre, double dureza, String caracteristicas) {
		this.nombre = nombre;
		this.dureza = dureza;
		this.caracteristicas = caracteristicas;

	}

	public String getNombre() {
		return nombre;
	}

	public double getDureza() {
		return dureza;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}
	
	public static Madera generaMaderaAleatoria() {
		return NUM_MADERAS_DIFERENTES[RND.nextInt(NUM_MADERAS_DIFERENTES.length)];
	}
}
