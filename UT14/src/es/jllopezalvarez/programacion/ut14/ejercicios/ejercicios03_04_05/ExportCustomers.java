package es.jllopezalvarez.programacion.ut14.ejercicios.ejercicios03_04_05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class ExportCustomers {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String SELECT_SQL = """
			select
				customer_id,
				store_id,
				first_name,
				last_name,
				email,
				address_id,
				active,
				create_date,
				last_update
			from
				customer;
			""";
	private static final Path PATH_FICHERO_DATOS = Path.of("datos", "customers.bin");

	public static void main(String[] args) {

		try (Connection conexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement sentenciaSQL = conexion.createStatement();
				ResultSet datos = sentenciaSQL.executeQuery(SELECT_SQL)) {

			if (!datos.isBeforeFirst()) {
				System.out.println("No se genera el fichero porque no hay datos.");
			} else {
				File fichero = PATH_FICHERO_DATOS.toFile();
				// Asegurarse de que existe el directorio
				fichero.getParentFile().mkdirs();

				try (ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(fichero))) {
					while (datos.next()) {
						int customeId = datos.getInt("customer_id");
						int storeId = datos.getInt("store_id");
						String firstName = datos.getString("first_name");
						String lastName = datos.getString("last_name");
						String email = datos.getString("email");
						int addressId = datos.getInt("address_id");
						boolean active = datos.getBoolean("active");
						Timestamp createDate = datos.getTimestamp("create_date");
						Timestamp timestamp = datos.getTimestamp("last_update");
						
						System.out.printf("Original: %s - Convertido: %b\n", datos.getInt("active"), active);

						Customer c = new Customer(customeId, storeId, firstName, lastName, email,
								addressId, active, createDate, timestamp);
						
						oos.writeObject(c);
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Exportación finalizada");

	}
}
