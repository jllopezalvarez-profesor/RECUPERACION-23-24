package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06;

import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.Color;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.ConsumoEnergetico;
import es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos.Electrodomestico;

public class Prueba extends Electrodomestico {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public Prueba(double precioBase, double peso) {
		super(precioBase, peso);
		// TODO Auto-generated constructor stub
	}

	public Prueba(double precioBase, Color color, ConsumoEnergetico consumo, double peso) {
		super(precioBase, color, consumo, peso);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getPrecioFinal() {
		// TODO Auto-generated method stub
		return super.getPrecioFinal();
	}

}
