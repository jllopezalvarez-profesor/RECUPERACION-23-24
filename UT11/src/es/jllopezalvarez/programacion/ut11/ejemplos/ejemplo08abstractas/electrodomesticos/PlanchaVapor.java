package es.jllopezalvarez.programacion.ut11.ejemplos.ejemplo08abstractas.electrodomesticos;

public class PlanchaVapor extends Electrodomestico {

	public PlanchaVapor() {
		// TODO Auto-generated constructor stub
	}

	public PlanchaVapor(double precioBase, double peso) {
		super(precioBase, peso);
		// TODO Auto-generated constructor stub
	}

	public PlanchaVapor(double precioBase, Color color, ConsumoEnergetico consumo, double peso) {
		super(precioBase, color, consumo, peso);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTipoElectrodomestico() {
		return "Plancha de vapor";
	}

}
