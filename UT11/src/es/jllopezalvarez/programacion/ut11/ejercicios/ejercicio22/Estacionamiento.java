package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio22;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Estacionamiento {
	private final int numeroPlazas;
	private Plaza[] plazas;
	private Random rnd = new Random();

	public Estacionamiento(int numeroPlazas) {
		if (numeroPlazas < 1) {
			throw new IllegalArgumentException("El número de plazas no puede ser menor o igual que cero.");
		}
		this.numeroPlazas = numeroPlazas;

		this.plazas = new Plaza[numeroPlazas];

		inicializarPlazas();

	}

	private void inicializarPlazas() {
		for (int i = 0; i < plazas.length; i++) {
			plazas[i] = new Plaza(i + 1, rnd.nextInt(Tamanio.PEQUENIO, Tamanio.GRANDE + 1));
		}
	}

	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	public void aparcar(Vehiculo vehiculo) {

//		boolean encontrada = false;
//		int posicion = 0;
//		while (!encontrada && posicion < this.plazas.length) {
//			Plaza plaza = plazas[posicion];
//			if (!plaza.isOcupada() && plaza.vehiculoCabe(vehiculo)) {
//				plaza.ocupar(vehiculo);
//				encontrada = true;
//			}
//			posicion++;
//		}
//		if (!encontrada) {
//			throw new IllegalStateException("No hay plazas disponibles en las que quepa el vehículo");
//		}

		for (Plaza plaza : plazas) {
			if (!plaza.isOcupada() && plaza.vehiculoCabe(vehiculo)) {
				plaza.ocupar(vehiculo);
				return;
			}
		}
		throw new IllegalStateException("No hay plazas disponibles en las que quepa el vehículo");

	}

	public Duration desaparcar(Vehiculo vehiculo) {
		for (Plaza plaza : plazas) {
			if (plaza.isOcupada() && plaza.getVehiculo().equals(vehiculo)) {
				return plaza.liberar();
			}
		}
		throw new IllegalStateException("El vehículo no se encuentra en el estacionamiento.");
	}

}
