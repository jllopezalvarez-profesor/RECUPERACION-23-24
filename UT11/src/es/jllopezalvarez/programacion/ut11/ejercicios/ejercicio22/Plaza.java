package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio22;

import java.time.Duration;
import java.time.LocalDateTime;

public class Plaza {
	private final int numero;
	private final int tamanio;
	private LocalDateTime fechaHoraOcupacion;
	private Vehiculo vehiculo;

	public Plaza(int numero, int tamanio) {
		if (numero <= 0) {
			throw new IllegalArgumentException("El número de plaza tiene que ser mayor que cero.");
		}
		if (tamanio < Tamanio.PEQUENIO || tamanio > Tamanio.GRANDE) {
			throw new IllegalArgumentException("El tamaño de la plaza no es válido.");
		}
		this.numero = numero;
		this.tamanio = tamanio;
		// this.ocupada = false;
		this.fechaHoraOcupacion = null;
		this.vehiculo = null;
	}

	public int getNumero() {
		return numero;
	}

	public int getTamanio() {
		return tamanio;
	}

	public boolean isOcupada() {
		return this.vehiculo != null;
	}

	public LocalDateTime getFechaHoraOcupacion() {
		return fechaHoraOcupacion;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public boolean vehiculoCabe(Vehiculo vehiculo) {
		return this.tamanio >= vehiculo.getTamanio();
	}

	public void ocupar(Vehiculo vehiculo) {
		if (this.isOcupada()) {
			throw new IllegalStateException("La plaza está ocupada");
		}
		if (!vehiculoCabe(vehiculo)) {
			throw new IllegalStateException("La plaza es demasiado pequeña.");
		}
		this.fechaHoraOcupacion = LocalDateTime.now();
		this.vehiculo = vehiculo;
	}

	public Duration liberar() {
		if (!this.isOcupada()) {
			throw new IllegalStateException("La plaza no está ocupada");
		}
		this.vehiculo = null;
		Duration tiempoTranscurrido = Duration.between(fechaHoraOcupacion, LocalDateTime.now());
		this.fechaHoraOcupacion = null;
		return tiempoTranscurrido;
	}
}
