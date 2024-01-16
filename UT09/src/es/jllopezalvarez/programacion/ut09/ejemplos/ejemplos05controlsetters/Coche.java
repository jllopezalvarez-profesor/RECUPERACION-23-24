package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos05controlsetters;

public class Coche {
	private int velocidadMaxima;
	private int velocidad;
	private int marcha;
	private boolean arrancado;

	public Coche(int velocidadMaxima, int velocidad, int marcha, boolean arrancado) {
		this.velocidadMaxima = velocidadMaxima;
		setVelocidad(velocidad);
		this.marcha = marcha;
		this.arrancado = arrancado;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		if (velocidad > velocidadMaxima) {
			String mensaje = String.format("Velocidad excesiva (%d). La velocidad máxima es %d.",
					velocidad, this.velocidadMaxima);
			throw new IllegalArgumentException(mensaje);
		}
		this.velocidad = velocidad;
	}

	public int getMarcha() {
		return marcha;
	}

	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}

	public boolean isArrancado() {
		return arrancado;
	}

	public int getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void arrancar() {
		if (this.arrancado)
			throw new IllegalStateException("No se puede arrancar el coche porque ya está arrancado.");
		this.arrancado = true;
	}

	public void parar() {
		if (!this.arrancado)
			throw new IllegalStateException("No se puede parar el coche porque no está arrancado.");
		this.arrancado = false;
	}

}
