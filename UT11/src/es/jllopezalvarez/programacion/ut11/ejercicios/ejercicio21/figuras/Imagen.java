package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio21.figuras;

public class Imagen implements Escalable{
	private int alto;
	private int ancho;

	public Imagen(int alto, int ancho) {
		super();
		this.alto = alto;
		this.ancho = ancho;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-".repeat(ancho + 2));
		sb.append("\n");
		for (int i = 0; i < this.alto; i++) {
			sb.append("|");
			sb.append(" ".repeat(ancho));
			sb.append("|");
			sb.append("\n");
		}
		sb.append("-".repeat(ancho + 2));
		sb.append("\n");

		return sb.toString();
	}

	@Override
	public void escalar(double factor) {
		if (factor <= 0) {
			throw new IllegalArgumentException("El factor de escala no puede ser menor o igual a cero.");
		}

		this.alto = (int)Math.round(alto*factor);
		this.ancho = (int)Math.round(ancho*factor);
		
	}

}
