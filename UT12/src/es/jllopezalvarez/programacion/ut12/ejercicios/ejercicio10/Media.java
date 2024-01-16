package es.jllopezalvarez.programacion.ut12.ejercicios.ejercicio10;

import java.time.LocalDate;

public class Media {
	private int id;
	private String titulo;
	private String artista;
	private String productora;
	private LocalDate fechaPublicacion;
	private MediaType type;

	public Media(int id, String titulo, String artista, String productora, LocalDate fechaPublicacion, MediaType type) {
		this.id = id;
		this.titulo = titulo;
		this.artista = artista;
		this.productora = productora;
		this.fechaPublicacion = fechaPublicacion;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public MediaType getType() {
		return type;
	}

	public void setType(MediaType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Media [id=");
		builder.append(id);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", artista=");
		builder.append(artista);
		builder.append(", productora=");
		builder.append(productora);
		builder.append(", fechaPublicacion=");
		builder.append(fechaPublicacion);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}