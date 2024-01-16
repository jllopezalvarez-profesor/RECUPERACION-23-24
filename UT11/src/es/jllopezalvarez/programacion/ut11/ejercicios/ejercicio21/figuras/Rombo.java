package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio21.figuras;

public class Rombo extends Figura {
	private static final int NUM_LADOS = 0;

	private double diagonalMayor;
	private double diagonalMenor;

	public Rombo(double diagonalMayor, double diagonalMenor) {
		this.diagonalMayor = diagonalMayor;
		this.diagonalMenor = diagonalMenor;
	}

	@Override
	public double perimetro() {
		return 2 * Math.sqrt((this.diagonalMayor * this.diagonalMayor) + (this.diagonalMenor * this.diagonalMenor));
	}

	@Override
	public double area() {
		return this.diagonalMayor * this.diagonalMenor / 2;
	}

	@Override
	public int numLados() {
		return NUM_LADOS;
	}
	@Override
	public void escalar(double factor) {
		
	}
}
