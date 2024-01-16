package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio10A.figuras;

/**
 * 
 * Versión 1 del ejercicio en el que añadimos el método para el número de lados.
 * Esta versión añade el atributo a nivel de la clase abstracta, y se implementa
 * también en ella el método. Se usan constructores para pasar el valor desde
 * cada subclase a su superclase, hasta llegar a la clase abastracta Figura.
 * 
 * Creo que es mejor la segunda versión, que no añade la complejidad de los
 * constructores
 *
 */
public abstract class Figura {
	private int numLados;

	public Figura(int numLados) {
		super();
		this.numLados = numLados;
	}

	public abstract double perimetro();

	public abstract double area();

	public int numLados() {
		return this.numLados;
	}

}
