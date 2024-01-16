package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio05;

import java.time.LocalDate;

public class Programa {
	public static void main(String[] args) {
//		Producto p = new Producto(2343, "01/05/2023");
//
//		LocalDate fechaCaducidad = p.getFechaCaducidad();
//
//		System.out.println(p);
//
//		ProductoFresco p2 = new ProductoFresco(2123, "20/05/2025", "España", "19/01/2023");
//
//		System.out.println(p2);
//
//		ProductoRefrigerado p3 = new ProductoRefrigerado(3423, "23/05/2023", "OMC");
//
//		System.out.println(p3);
//
//		ProductoCongelado p4 = new ProductoCongelado(32432, "20/12/2023", -9);
//
//		System.out.println(p4);

		pruebasCasting();

	}

	private static void pruebasCasting() {

		ProductoFresco pf1 = new ProductoFresco(1231, "01/01/2024", "España", "01/01/2023");

		Producto p1 = pf1;

//		System.out.println(pf1);
//		System.out.println(p1);

		Producto p2 = new ProductoCongelado(23123, "01/01/2023", -10);

		ProductoCongelado pc1 = (ProductoCongelado) p2;

//		ProductoFresco pf2 = (ProductoFresco) p2;
		
		Producto[] productos = new Producto[3];
		productos[0] = new ProductoCongelado(232, "01/01/2024", -3);
		productos[1] = new ProductoFresco(123143, "01/01/2024", "españa", "01/01/2023");
		productos[2] = new ProductoRefrigerado(2312, "01/01/2027", "OCU");
		
		for (Producto producto : productos) {
			System.out.println(producto);
		}
		
		

	}
}
