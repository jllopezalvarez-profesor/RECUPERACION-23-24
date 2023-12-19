package ejercicios.ejercicio12;

public class Moto implements Vehiculo {
	private static final int NUM_PLAZAS = 2;
	private int velocidad = 0;


	@Override
	public void acelerar(int cuanto) {
		this.velocidad += cuanto;
		if (this.velocidad > VELOCIDAD_MAXIMA)
			this.velocidad = VELOCIDAD_MAXIMA;
		System.out.printf("Soy una moto y acelero a %d km/h\n", this.velocidad);

	}

	@Override
	public void frenar(int cuanto) {
		this.velocidad -= cuanto;
		if (this.velocidad < 0)
			this.velocidad = 0;
		System.out.printf("Soy una moto y freno a %d km/h\n", this.velocidad);
	}

	@Override
	public int getNumPlazas() {
		return NUM_PLAZAS;
	}

}
