package ejercicios.ejercicio12;

public class Coche implements Vehiculo {
	private int velocidad = 0;
	int numPlazas;

	public Coche(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	@Override
	public void acelerar(int cuanto) {
		this.velocidad += cuanto;
		if (this.velocidad > VELOCIDAD_MAXIMA)
			this.velocidad = VELOCIDAD_MAXIMA;
		System.out.printf("Soy un coche y acelero a %d km/h\n", this.velocidad);

	}

	@Override
	public void frenar(int cuanto) {
		this.velocidad -= cuanto;
		if (this.velocidad < 0)
			this.velocidad = 0;
		System.out.printf("Soy un coche y freno a %d km/h\n", this.velocidad);

	}

	@Override
	public int getNumPlazas() {
		return this.numPlazas;
	}

}
