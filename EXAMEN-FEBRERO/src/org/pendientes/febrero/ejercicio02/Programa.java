package org.pendientes.febrero.ejercicio02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>(5);

		personas.add(new Persona("123456789A", "José Luis", "López Álvarez"));
		personas.add(new Persona("123456789B", "Antonio", "Martín"));
		personas.add(new EmpleadoFijo("123456789C", "María", "Fernández", LocalDate.of(2024, 1, 1)));
		personas.add(new EmpleadoFijo("123456789D", "Juan", "Alonso", 30000));
		personas.add(new EmpleadoTemporal("123456789E", "Manuel", "Jimenez", LocalDate.of(2024, 2, 29),
				LocalDate.of(2024, 7, 1)));

		for (Persona persona : personas) {
			if (persona instanceof EmpleadoFijo) {
				EmpleadoFijo empleado = (EmpleadoFijo) persona;
				System.out.printf("%s - %s - %s - %.2f - Antiguedad: %d meses\n", persona.getDni(), persona.getNombre(),
						persona.getApellidos(), empleado.getCotizacionSeguridadSocial(), empleado.getAntiguedad());
				// } else if (persona instanceof Persona) {
			} else if (persona instanceof EmpleadoTemporal empleado) {
				// EmpleadoTemporal empleado = (EmpleadoTemporal)persona;
				System.out.printf("%s - %s - %s - %.2f - Antiguedad: %d meses - Tiempo restante: %d días\n", persona.getDni(), persona.getNombre(),
						persona.getApellidos(), empleado.getCotizacionSeguridadSocial(), empleado.getAntiguedad(), empleado.getTiempoRestanteContrato());
			} else {
				System.out.printf("%s - %s - %s\n", persona.getDni(), persona.getNombre(), persona.getApellidos());
			}
		}

	}
}
