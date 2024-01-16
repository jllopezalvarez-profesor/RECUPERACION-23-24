package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio13;

public class Coche extends VehiculoMotor {

	public Coche(int numeroPlazas) {
		this(0, numeroPlazas);
	}

	public Coche(int velocidad, int numeroPlazas) {
		super(velocidad, numeroPlazas);
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
