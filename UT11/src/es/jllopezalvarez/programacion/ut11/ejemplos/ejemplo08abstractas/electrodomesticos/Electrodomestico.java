package es.jllopezalvarez.programacion.ut11.ejemplos.ejemplo08abstractas.electrodomesticos;

public abstract class Electrodomestico {
	private static final Color COLOR_DEFECTO = Color.BLANCO;
	private static final ConsumoEnergetico CONSUMO_DEFECTO = ConsumoEnergetico.F;
	private static final double PRECIO_BASE_DEFECTO = 100;
	private static final double PESO_DEFECTO = 5;

	private double precioBase;
	private Color color;
	private ConsumoEnergetico consumo;
	private double peso;

	public Electrodomestico() {
		this(PRECIO_BASE_DEFECTO, COLOR_DEFECTO, CONSUMO_DEFECTO, PESO_DEFECTO);
	}

	public Electrodomestico(double precioBase, double peso) {
		this(precioBase, COLOR_DEFECTO, CONSUMO_DEFECTO, peso);
	}

	public Electrodomestico(double precioBase, Color color, ConsumoEnergetico consumo, double peso) {
		this.precioBase = precioBase;
		this.color = color;
		this.consumo = consumo;
		this.peso = peso;
	}

	double getPrecioBase() {
		return this.precioBase;
	}
	
	public abstract String getTipoElectrodomestico();
	
	public double getPrecioFinal() {
		double precioFinal = this.precioBase;

		switch (this.consumo) {
		case A:
			precioFinal += IncrementosPrecio.INCREMENTO_CONSUMO_A;
			break;
		case B:
			precioFinal += IncrementosPrecio.INCREMENTO_CONSUMO_B;
			break;
		case C:
			precioFinal += IncrementosPrecio.INCREMENTO_CONSUMO_C;
			break;
		case D:
			precioFinal += IncrementosPrecio.INCREMENTO_CONSUMO_D;
			break;
		case E:
			precioFinal += IncrementosPrecio.INCREMENTO_CONSUMO_E;
			break;
		case F:
			precioFinal += IncrementosPrecio.INCREMENTO_CONSUMO_F;
			break;
		}

		if (this.peso < 20) {
			precioFinal += IncrementosPrecio.INCREMENTO_PESO_0_20;
		}
		if (pesoEntre(20, 50)) {
			precioFinal += IncrementosPrecio.INCREMENTO_PESO_20_50;
		}
		if (pesoEntre(50, 80)) {
			precioFinal += IncrementosPrecio.INCREMENTO_PESO_50_80;
		}
		if (this.peso > 80) {
			precioFinal += IncrementosPrecio.INCREMENTO_PESO_80_MAS;
		}

		return precioFinal;
	}

	private boolean pesoEntre(double minInclusive, double maxExclusive) {
		return this.peso >= minInclusive && this.peso < maxExclusive;
	}

}
