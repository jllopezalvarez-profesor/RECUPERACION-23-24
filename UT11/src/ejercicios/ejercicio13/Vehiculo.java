package ejercicios.ejercicio13;

public interface Vehiculo {
	int VELOCIDAD_MAXIMA = 120; // Es public static

	// Todos los métodos son por defecto public y abstract
	void acelerar(int cuanto);

	void frenar(int cuanto);

	int getNumPlazas();
}
