package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio12;

public interface Vehiculo {
	int VELOCIDAD_MAXIMA = 120;

	void acelerar(int cuanto);

	void frenar(int cuanto);

	int getNumPlazas();

}
