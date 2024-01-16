package es.jllopezalvarez.programacion.ut14.ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio06 {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String sentenciaSql;

		do {
			System.out.println("\n\nIntroduce la sentencia a ejecutar");
			sentenciaSql = scanner.nextLine();
			if (!sentenciaSql.isBlank()) {
				intentarEjecutarSentencia(sentenciaSql);
			}
		} while (!sentenciaSql.isBlank());

	}

	private static void intentarEjecutarSentencia(String sentenciaSql) {
		try (Connection conexion = DriverManager.getConnection(CONNECTION_URL, USERNAME,
				PASSWORD)) {
			try (Statement st = conexion.createStatement()) {
				try {
					boolean hayResultados = st.execute(sentenciaSql);
					if (hayResultados) {
						ResultSet resultados = st.getResultSet();
						mostrarInformeResultados(resultados);
					} else {
						System.out.println("Sentencia ejecutada con éxito");
					}
				} catch (SQLException e) {
					System.out.printf(
							"Error al ejecutar la sentencia SQL o al generar los resultados: %s\n",
							e.getMessage());
				}
			} catch (SQLException e) {
				System.out.printf("Error al crear la sentencia SQL: %s\n", e.getMessage());
			}
		} catch (SQLException e) {
			System.out.printf("Error al abrir la conexión con la BD: %s\n", e.getMessage());
		}

	}

	private static void mostrarInformeResultados(ResultSet resultados) throws SQLException {
		ResultSetMetaData metaData = resultados.getMetaData();
		Map<Integer, Integer> longitudesColumnas = getLongitudesColumnas(metaData);

		generarCabecera(metaData, longitudesColumnas);
		mostrarDatos(resultados, metaData, longitudesColumnas);
	}

	private static void mostrarDatos(ResultSet resultados, ResultSetMetaData metaData, Map<Integer, Integer> longitudesColumnas)
			throws SQLException {
		while (resultados.next()) {
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				System.out.printf("| %" + longitudesColumnas.get(i) + "s ", resultados.getString(i));
			}
			System.out.println("|");
		}
	}

	private static void generarCabecera(ResultSetMetaData metaData, Map<Integer, Integer> longitudesColumnas) throws SQLException {

		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			String etiqueta = metaData.getTableName(i) + "." + metaData.getColumnName(i);
			System.out.printf("| %" + longitudesColumnas.get(i) + "s ", etiqueta);
		}
		System.out.println("|");
	}

	private static Map<Integer, Integer> getLongitudesColumnas(ResultSetMetaData metaData)
			throws SQLException {
		Map<Integer,Integer> longitudesColumnas = new HashMap<>();
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			String etiqueta = metaData.getTableName(i) + "." + metaData.getColumnName(i);
			int longitud = Math.max(etiqueta.length(), metaData.getColumnDisplaySize(i));
			longitudesColumnas.put(i, longitud);
		}
		return longitudesColumnas;
	}
}
