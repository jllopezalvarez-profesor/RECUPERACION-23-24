package ejercicios.ejercicio13;

public class Coche extends VehiculoMotor {
	public Coche(int numPlazas) {
		super(numPlazas);
	}

	@Override
	public void acelerar(int cuanto) {
		System.out.print("Soy un coche. ");
		super.acelerar(cuanto);

	}

	@Override
	public void frenar(int cuanto) {
		System.out.print("Soy un coche. ");
		super.frenar(cuanto);
	}

}
