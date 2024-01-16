package es.jllopezalvarez.programacion.ut09.ejercicios.ejercicio03;

public class Coche {
	private boolean arrancado;
	private boolean circulaHaciaAtras;
	private final int vMax;
	private final int vMaxAtras;
	private int velocidad;

	/**
	 * Clase que representa un coche.
	 * 
	 * @param arrancado         si el coche está arrancado
	 * @param circulaHaciaAtras si tiene puesta la marcha atrás
	 * @param vMax              velocidad máxima hacia delante
	 * @param vMaxAtras         tiene que ser negativo. Si no lo es lanza un
	 *                          excepción.
	 * @param velocidad         velocidad del coche en el momento de su creación
	 * 
	 * @throws IllegalArgumentException
	 */
	public Coche(boolean arrancado, boolean circulaHaciaAtras, int vMax, int vMaxAtras, int velocidad) {
		if (vMax <= 0) {
			throw new IllegalArgumentException("La velocidad máxima tiene que ser mayor que cero.");
		}
		if (vMaxAtras >= 0) {
			throw new IllegalArgumentException("La velocidad máxima hacia atrás tiene que ser menor que cero.");
		}

		// TODO: Hacer comprobaciones de parámetros incoherentes. Por ejemplo, velocidad
		// superior a cero con el coche parado o si está circulando marcha atrás, o
		// velocidad inferior a cero con el coche parado o circulando hacia delante.
		// También velocidad superior a la máxima correspondiente.

		this.arrancado = arrancado;
		this.circulaHaciaAtras = circulaHaciaAtras;
		this.vMax = vMax;
		this.vMaxAtras = vMaxAtras;
		this.velocidad = velocidad;
	}

	/**
	 * Clase que representa un coche.
	 * 
	 * @param vMax      velocidad máxima hacia delante
	 * @param vMaxAtras tiene que ser negativo. Si no lo es lanza un excepción.
	 * @throws IllegalArgumentException si la {@code vMax} no es positiva o si la
	 *                                  {@code vMaxAtras} no es negativa
	 */
	public Coche(int vMax, int vMaxAtras) {
		this(false, false, vMax, vMaxAtras, 0);
//		this.arrancado = false;
//		this.circulaHaciaAtras = false;
//		this.vMax = vMax;
//		this.vMaxAtras = vMaxAtras;
//		this.velocidad = 0;
	}

	public boolean arrancado() {
		return arrancado;
	}

	public boolean circulaHaciaAtras() {
		return circulaHaciaAtras;
	}

	public int getvMax() {
		return vMax;
	}

	public int getvMaxAtras() {
		return vMaxAtras;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void arrancar() {
		if (this.arrancado) {
			throw new IllegalStateException("El coche ya está arrancado.");
		}
		this.arrancado = true;
	}

	public void detener() {
		if (!this.arrancado) {
			throw new IllegalStateException("El coche ya está detenido.");
		}
		if (this.velocidad != 0) {
			throw new IllegalStateException("No se puede detener porque está en movimiento.");
		}
		this.arrancado = false;
	}

	public void ponerMarchaAtras() {
		if (this.circulaHaciaAtras) {
			throw new IllegalStateException("Ya está puesta la marcha atrás.");
		}
		if (this.velocidad != 0) {
			throw new IllegalStateException("No se puede poner marcha atrás porque está en movimiento.");
		}
		this.circulaHaciaAtras = true;
	}

	public void quitarMarchaAtras() {
		if (!this.circulaHaciaAtras) {
			throw new IllegalStateException("No está puesta la marcha atrás.");
		}
		if (this.velocidad != 0) {
			throw new IllegalStateException("No se puede quitar la marcha atrás porque está en movimiento.");
		}
		this.circulaHaciaAtras = false;
	}

	public void acelerar(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("El incremento de velocidad no puede ser menor o igual a cero.");
		}

		if (arrancado) {
			if (circulaHaciaAtras) {
				this.velocidad -= cantidad;
				if (this.velocidad < this.vMaxAtras) {
					this.velocidad = this.vMaxAtras;
				}
			} else {
				this.velocidad += cantidad;
				if (this.velocidad > this.vMax) {
					this.velocidad = this.vMax;
				}
			}
		}
	}

	public void frenar(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("El incremento de velocidad no puede ser menor o igual a cero.");
		}

		if (arrancado) {
			if (circulaHaciaAtras) {
				this.velocidad += cantidad;
				if (this.velocidad > 0) {
					this.velocidad = 0;
				}
			} else {
				this.velocidad -= cantidad;
				if (this.velocidad < 0) {
					this.velocidad = 0;
				}
			}
		}
	}

	@Override
	public String toString() {
		return String.format("Coche [arrancado=%s, circulaHaciaAtras=%s, velocidad=%s]", arrancado, circulaHaciaAtras,
				velocidad);
	}

}
