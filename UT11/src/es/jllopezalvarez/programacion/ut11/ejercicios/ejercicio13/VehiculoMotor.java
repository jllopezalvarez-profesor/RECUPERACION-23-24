package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio13;

public abstract class VehiculoMotor implements Vehiculo {
	private int numeroPlazas;
	private int velocidad;

	public VehiculoMotor(int velocidad, int numeroPlazas) {
		this.velocidad = velocidad;
		this.numeroPlazas = numeroPlazas;
	}

	@Override
	public void acelerar(int cuanto) {
		if (this.velocidad == VELOCIDAD_MAXIMA) {
			System.out.println("No puedo acelerar más");
		} else {
			this.velocidad += cuanto;
			if (this.velocidad > VELOCIDAD_MAXIMA) {
				this.velocidad = VELOCIDAD_MAXIMA;
			}
			System.out.printf("Circulo a %d Km/h\n", this.velocidad);
		}
	}

	@Override
	public void frenar(int cuanto) {
		if (this.velocidad == 0) {
			System.out.println("No puedo frenar más");
		} else {
			this.velocidad -= cuanto;
			if (this.velocidad < 0) {
				this.velocidad = 0;
			}
			System.out.printf("Circulo a %d Km/h\n", this.velocidad);
		}
	}

	@Override
	public int getNumPlazas() {
		return this.numeroPlazas;
	}
}
