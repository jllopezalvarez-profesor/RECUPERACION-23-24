package es.jllopezalvarez.programacion.ut14.ejemplos.ejemplos06transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo06ATransaccion {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String SQL_IDIOMAS = "insert into language (name) values ('Esperanto')";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement()) {

			// Cambiamos el modo de transacción
			// para que sean explícitas
			conn.setAutoCommit(false);

			// Confirmamos cambios
			conn.commit();

			
			// Ejecutamos la inserción
			st.executeUpdate(SQL_IDIOMAS);

			// Confirmamos cambios
			conn.commit();
			
			// Deshacemos los cambios
			conn.rollback();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
