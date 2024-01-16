package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio20.figuras;

public abstract class Paralelogramo extends Figura {
	private static final int NUM_LADOS = 4;
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
	
	@Override
	public int numLados() {
		return NUM_LADOS;
	}

	@Override
	public void escalar(double factor) {
		if (factor <= 0) {
			throw new IllegalArgumentException("El factor de escala no puede ser menor o igual a cero.");
		}
		this.base *= factor;
		this.altura *= factor;		
	}
}
