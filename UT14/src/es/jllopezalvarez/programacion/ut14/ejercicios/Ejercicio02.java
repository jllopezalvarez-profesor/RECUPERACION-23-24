package es.jllopezalvarez.programacion.ut14.ejercicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio02 {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String SQL_INFORME = """
			SELECT CONCAT(customer.last_name, ', ', customer.first_name) AS customer,
			      address.phone,
			      film.title,
			      rental_date,
			      rental_date + INTERVAL film.rental_duration DAY AS expected_return_date,
				datediff( sysdate(), (rental_date + INTERVAL film.rental_duration DAY)) as delay_days
			FROM rental
			         INNER JOIN customer ON rental.customer_id = customer.customer_id
			         INNER JOIN address ON customer.address_id = address.address_id
			         INNER JOIN inventory ON rental.inventory_id = inventory.inventory_id
			         INNER JOIN film ON inventory.film_id = film.film_id
			WHERE rental.return_date IS NULL
			  AND rental_date + INTERVAL film.rental_duration DAY < CURRENT_DATE()
			ORDER BY title;
			""";
	private static final Path PATH_FICHERO = Path.of("datos", "informeEj02.txt");

	public static void main(String[] args) {

		// Asegurarse de que existe la carpeta donde escribimos el informe.
		PATH_FICHERO.toFile().getParentFile().mkdirs();

		try (Connection conexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement sentencia = conexion.createStatement();
				ResultSet datos = sentencia.executeQuery(SQL_INFORME);
				PrintWriter pw = new PrintWriter(new FileWriter(PATH_FICHERO.toFile()))) {

			String formatString = "| %-50.50s | %-20.20s | %-50.50s | %-10.10s | %-10.10s | %7.7s |\n";
			// Al calcular la longitud restamos 1 para no contar el \n
			int longitud = String.format(formatString, "", "", "", "", "", "").length() - 1;

			pw.println("-".repeat(longitud));
			pw.printf(formatString, "Cliente", "Teléfono", "Película", "Alquilada", "Devolver", "Retraso");
			pw.println("-".repeat(longitud));

			while (datos.next()) {
				pw.printf(formatString, datos.getString("customer"), datos.getString("phone"),
						datos.getString("title"), datos.getDate("rental_date"),
						datos.getDate("expected_return_date"),
						datos.getInt("delay_days"));
				pw.println("-".repeat(longitud));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
