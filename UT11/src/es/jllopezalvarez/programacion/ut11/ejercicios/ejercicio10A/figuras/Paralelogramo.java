package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio10A.figuras;

public abstract class Paralelogramo extends Figura {
	private static final int NUM_LADOS = 4;
	
	private double base;
	private double altura;

	public Paralelogramo(double base, double altura) {
		super(NUM_LADOS);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double perimetro() {
		return (this.getBase() + this.altura) * 2;
	}

	@Override
	public double area() {
		return getBase() * altura;
	}

	double getBase() {
		return base;
	}

}
