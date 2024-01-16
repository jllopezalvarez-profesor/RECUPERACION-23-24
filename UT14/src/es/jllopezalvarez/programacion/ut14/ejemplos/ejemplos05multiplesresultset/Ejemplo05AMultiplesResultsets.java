package es.jllopezalvarez.programacion.ut14.ejemplos.ejemplos05multiplesresultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSetMetaData;

public class Ejemplo05AMultiplesResultsets {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
//	private static final String SQL_IDIOMAS = "select language_id, name from language;";
//	private static final String SQL_CUSTOMERS = "select customer_id, first_name, last_name from customer;";
	private static final String SQL_DOBLE = "call get_idiomas_y_clientes()";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement()) {

			boolean hayResultset = st.execute(SQL_DOBLE);
			while (hayResultset) {
				try (ResultSet datos = st.getResultSet()) {
					mostrarDatos(datos);
					hayResultset = st.getMoreResults();
				}
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void mostrarDatos(ResultSet datos) throws SQLException {
		System.out.println("\n\nMostrando resultados del resultset.");
		ResultSetMetaData metaData = datos.getMetaData();
		int numColumnas = metaData.getColumnCount();
		while (datos.next()) {
			mostrarFilaDatos(datos, numColumnas);
		}

	}

	private static void mostrarFilaDatos(ResultSet datos, int numColumnas) throws SQLException {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numColumnas; i++) {
			sb.append(datos.getString(i));
			if (i < numColumnas) {
				sb.append(" - ");
			}
		}

		System.out.println(sb.toString());
	}

}
