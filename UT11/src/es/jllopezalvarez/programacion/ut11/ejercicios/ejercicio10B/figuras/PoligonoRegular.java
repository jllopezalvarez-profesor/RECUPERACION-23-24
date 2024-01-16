package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio10B.figuras;

public class PoligonoRegular extends Figura {
	private int numLados;
	private double lado;
	private double apotema;

	public PoligonoRegular(int numLados, double lado, double apotema) {
		this.numLados = numLados;
		this.lado = lado;
		this.apotema = apotema;
	}

	@Override
	public double perimetro() {
		return this.lado * this.numLados;
	}

	@Override
	public double area() {
		return (this.perimetro() * this.apotema) / 2;
	}

	@Override
	public int numLados() {
		return this.numLados;
	}
}
