package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio11;

import java.util.Random;

public class Agricultor {
	private String nombre;
	private String producto;

	private static int cantidadTotalProducida = 0;

	private static Random rnd = new Random();

	public Agricultor(String nombre, String producto) {
		this.nombre = nombre;
		this.producto = producto;
	}

	public void recolectar() {
		int cantidad = rnd.nextInt(100, 200);
		Agricultor.cantidadTotalProducida += cantidad;
		System.out.printf("%s: recolectados %d kg de %s.\n", this.nombre, cantidad, producto);

	}

	public static int getCantidadTotalProducida() {
		return Agricultor.cantidadTotalProducida;
	}
}
