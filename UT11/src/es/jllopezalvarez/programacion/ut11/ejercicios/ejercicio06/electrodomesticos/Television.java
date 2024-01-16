package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio06.electrodomesticos;

public class Television extends Electrodomestico {
	private static final int RESOLUCION_DEFECTO = 42;
	private static final boolean TIENE_TDT2_DEFECTO = true;

	private int resolucion;
	private boolean tieneTdt2;

	public Television() {
		// super(); // Opcional. Si no aparece Java lo hace solo.
		this.resolucion = RESOLUCION_DEFECTO;
		this.tieneTdt2 = TIENE_TDT2_DEFECTO;
	}

	public Television(double precioBase, double peso) {
		super(precioBase, peso);
		this.resolucion = RESOLUCION_DEFECTO;
		this.tieneTdt2 = TIENE_TDT2_DEFECTO;
	}

	public Television(double precioBase, Color color, ConsumoEnergetico consumo, double peso, int resolucion,
			boolean tieneTdt2) {
		super(precioBase, color, consumo, peso);
		this.resolucion = resolucion;
		this.tieneTdt2 = tieneTdt2;
	}

	@Override
	public double getPrecioFinal() {
		double precioFinal = super.getPrecioFinal();
		if (this.resolucion > 65) {
			precioFinal += this.getPrecioBase() * IncrementosPrecio.FACTOR_INCREMENTO_PULGADAS;
		}
		if (this.tieneTdt2) {
			precioFinal += IncrementosPrecio.INCREMENTO_TDT2;
		}
		return precioFinal;
	}
}
