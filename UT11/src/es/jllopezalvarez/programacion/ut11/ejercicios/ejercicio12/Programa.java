package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio12;

public class Programa {
	public static void main(String[] args) {
		Vehiculo v1 = new Coche(5);
		Vehiculo v2 = new Moto(20, 2);
		
		v1.acelerar(10);
		v2.frenar(5);
		v2.acelerar(20);
		v1.frenar(10);
		v1.frenar(100);
		
		System.out.println(v1.getNumPlazas());
		System.out.println(v2.getNumPlazas());
		
	}
}
