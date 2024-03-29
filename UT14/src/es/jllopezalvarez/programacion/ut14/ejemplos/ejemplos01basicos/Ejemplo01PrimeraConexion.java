package es.jllopezalvarez.programacion.ut14.ejemplos.ejemplos01basicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo01PrimeraConexion {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String SQL_PRUEBA = "select film_id,  release_year, title from film";
	private static final String NOMBRE_COL_1 = "film_id";
	private static final String NOMBRE_COL_2 = "title";
	private static final String NOMBRE_COL_3 = "release_year";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SQL_PRUEBA)) {
			
			System.out.println(conn.getClass().getName());
			
			System.out.printf("Resultados de la consulta '%s'\n\n", SQL_PRUEBA);
			while (rs.next()) {
				String c1 = rs.getString(NOMBRE_COL_1);
				String c2 = rs.getString(NOMBRE_COL_2);
				int c3 = rs.getInt(NOMBRE_COL_3);
//				String c1 = rs.getString(1);
//				String c2 = rs.getString(2);
//				int c3 = rs.getInt(3);

				System.out.println(c1 + " - " + c2 + " - " + c3);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
