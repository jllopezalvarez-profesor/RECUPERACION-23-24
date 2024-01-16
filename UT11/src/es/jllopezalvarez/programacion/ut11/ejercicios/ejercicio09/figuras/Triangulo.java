package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio09.figuras;

public class Triangulo extends Figura {
	private double ladoA;
	private double ladoB;
	private double ladoC;

	public Triangulo(double ladoA, double ladoB, double ladoC) {
		super();
		this.ladoA = ladoA;
		this.ladoB = ladoB;
		this.ladoC = ladoC;
	}

	@Override
	public double perimetro() {
		return this.ladoA + this.ladoB + this.ladoC;
	}

	@Override
	public double area() {
		// s es el semiperímetro
		double s = this.perimetro() / 2;
		return Math.sqrt(s * (s - this.ladoA) * (s - this.ladoB) * (s - this.ladoC));
	}

}
