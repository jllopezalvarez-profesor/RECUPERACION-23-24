package ejercicios.ejercicio13;

public class Moto extends VehiculoMotor {
	private static final int NUM_PLAZAS = 2;

	public Moto() {
		super(NUM_PLAZAS);
	}

	@Override
	public void acelerar(int cuanto) {
		System.out.print("Soy una moto. ");
		super.acelerar(cuanto);

	}

	@Override
	public void frenar(int cuanto) {
		System.out.print("Soy una moto. ");
		super.frenar(cuanto);
	}



}
