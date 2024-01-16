package es.jllopezalvarez.programacion.ut14.ejemplos.ejemplos04insertupdatedelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo04AResultsetEditable {
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String SQL_IDIOMAS = "select language_id, name from language";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery(SQL_IDIOMAS)) {
			// Vemos los datos antes de modificarlos.
			System.out.printf("\nDatos en el ResultSet antes de modificarlo:\n");
			while (rs.next()) {
				String c1 = rs.getString("language_id");
				String c2 = rs.getString("name");
				System.out.println(c1 + " - " + c2);
			}

			// Volvemos al principio del resultset
			rs.beforeFirst();
			
			// Lo recorremos modificando el nombre
			while (rs.next()) {
				String valor = rs.getString("name");
				// String nuevoValor = valor + " - modificado";
				String nuevoValor = valor + "*";
				// Modificamos el valor en el resultset. En este punto aún no se ha cambiado en la BD.
				rs.updateString("name", nuevoValor);
				// Confirmamos el cambio en la BD
				rs.updateRow();
			}

			// Volvemos al principio del resultset
			rs.beforeFirst();

			// Vemos los datos después de modificarlos.
			System.out.printf("\nDatos en el ResultSet después de modificarlo:\n");
			while (rs.next()) {
				String c1 = rs.getString("language_id");
				String c2 = rs.getString("name");
				System.out.println(c1 + " - " + c2);
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
