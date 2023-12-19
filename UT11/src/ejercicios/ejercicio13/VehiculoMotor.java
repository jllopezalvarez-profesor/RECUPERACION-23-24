package ejercicios.ejercicio13;

public abstract class VehiculoMotor implements Vehiculo
{
	private int velocidad = 0;
	int numPlazas;

	public VehiculoMotor(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	@Override
	public void acelerar(int cuanto) {
		this.velocidad += cuanto;
		if (this.velocidad > VELOCIDAD_MAXIMA)
			this.velocidad = VELOCIDAD_MAXIMA;
		System.out.printf("Acelero a %d km/h\n", this.velocidad);

	}

	@Override
	public void frenar(int cuanto) {
		this.velocidad -= cuanto;
		if (this.velocidad < 0)
			this.velocidad = 0;
		System.out.printf("Freno a %d km/h\n", this.velocidad);

	}

	@Override
	public int getNumPlazas() {
		return this.numPlazas;
	}


}
