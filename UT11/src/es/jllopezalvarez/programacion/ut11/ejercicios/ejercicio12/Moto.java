package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio12;

public class Moto implements Vehiculo {
	int velocidad;
	int numeroPlazas;

	public Moto(int numeroPlazas) {
		this(0, numeroPlazas);
	}

	public Moto(int velocidad, int numeroPlazas) {
		this.velocidad = velocidad;
		this.numeroPlazas = numeroPlazas;
	}

	@Override
	public void acelerar(int cuanto) {
		if (this.velocidad == VELOCIDAD_MAXIMA) {
			System.out.println("Soy un moto y no puedo acelerar más");
		} else {
			this.velocidad += cuanto;
			if (this.velocidad > VELOCIDAD_MAXIMA) {
				this.velocidad = VELOCIDAD_MAXIMA;
			}
			System.out.printf("Soy un moto y circulo a %d Km/h\n", this.velocidad);
		}
	}

	@Override
	public void frenar(int cuanto) {
		if (this.velocidad == 0) {
			System.out.println("Soy un moto y no puedo frenar más");
		} else {
			this.velocidad -= cuanto;
			if (this.velocidad < 0) {
				this.velocidad = 0;
			}
			System.out.printf("Soy un moto y circulo a %d Km/h\n", this.velocidad);
		}
	}

	@Override
	public int getNumPlazas() {
		return this.numeroPlazas;
	}

}
