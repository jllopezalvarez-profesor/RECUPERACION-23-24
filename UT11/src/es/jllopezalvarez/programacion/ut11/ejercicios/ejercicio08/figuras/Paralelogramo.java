package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio08.figuras;

public abstract class Paralelogramo extends Figura {
	private double base;
	private double altura;

	public Paralelogramo(double base, double altura) {
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
