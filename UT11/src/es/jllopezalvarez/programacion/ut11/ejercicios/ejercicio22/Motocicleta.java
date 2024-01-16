package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio22;

public class Motocicleta extends Vehiculo {

	public Motocicleta(String matricula, String marca, String modelo, Color color) {
		super(matricula, marca, modelo, color);
	}

	@Override
	public int getTamanio() {
		return Tamanio.PEQUENIO;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Motocicleta [");
		builder.append("Matrícula: ");
		builder.append(getMatricula());
		builder.append(", ");
		builder.append("Marca: ");
		builder.append(getMarca());
		builder.append(", ");
		builder.append("Modelo: ");
		builder.append(getModelo());
		if (getColor() != null) {
			builder.append(", ");
			builder.append("Color: ");
			builder.append(getColor());
		}
		builder.append("]");
		return builder.toString();
	}

}
