package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio13;

public class Moto extends VehiculoMotor {
	public Moto(int numeroPlazas) {
		this(0, numeroPlazas);
	}

	public Moto(int velocidad, int numeroPlazas) {
		super(velocidad, numeroPlazas);
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
