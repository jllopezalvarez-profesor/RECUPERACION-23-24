package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio10A.figuras;

public class Elipse extends Figura {
	private static final int NUM_LADOS = 0;

	private double radioMenor;
	private double radioMayor;

	public Elipse(double radioMenor, double radioMayor) {
		super(NUM_LADOS);
		this.radioMenor = radioMenor;
		this.radioMayor = radioMayor;
	}

	@Override
	public double perimetro() {
		return 2 * Math.PI * Math.sqrt(((this.radioMayor * this.radioMayor) + (this.radioMenor * this.radioMenor)) / 2);
	}

	@Override
	public double area() {
		return Math.PI * this.radioMayor * this.radioMenor;
	}

}
