package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18A;

public abstract class Viento extends Instrumento {
	private Material material;

	public Viento(String propietario, int dificultad, Material material) {
		super(propietario, dificultad);
		this.material = material;
	}

	public Material getMaterial() {
		return material;
	}

}
