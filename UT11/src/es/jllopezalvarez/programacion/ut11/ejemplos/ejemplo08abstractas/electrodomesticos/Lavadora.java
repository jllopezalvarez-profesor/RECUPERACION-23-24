package es.jllopezalvarez.programacion.ut11.ejemplos.ejemplo08abstractas.electrodomesticos;

public class Lavadora extends Electrodomestico {
	private static double CARGA_DEFECTO = 5;

	private double carga;

	public Lavadora() {
		// super(); // Opcional. Si no aparece Java lo hace solo.
		this.carga = CARGA_DEFECTO;
	}

	public Lavadora(double precioBase, double peso) {
		super(precioBase, peso);
		this.carga = CARGA_DEFECTO;
	}

	public Lavadora(double precioBase, Color color, ConsumoEnergetico consumo, double peso, double carga) {
		super(precioBase, color, consumo, peso);
		this.carga = carga;
	}

	@Override
	public double getPrecioFinal() {
		double precioFinal = super.getPrecioFinal();
		if (this.carga > 8) {
			precioFinal += IncrementosPrecio.INCREMENTO_ALTA_CARGA;
		}
		return precioFinal;
	}

	@Override
	public String getTipoElectrodomestico() {
		return "Lavadora";
	}

}
