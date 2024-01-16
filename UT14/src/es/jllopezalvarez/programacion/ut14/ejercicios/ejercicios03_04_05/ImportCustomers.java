package es.jllopezalvarez.programacion.ut14.ejercicios.ejercicios03_04_05;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class ImportCustomers {

	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String INSERT_SQL = """
			insert into old_customer (
				customer_id,
				store_id,
				first_name,
				last_name,
				email,
				address_id,
				active,
				create_date,
				last_update)
			values
				(?, ?, ?, ?, ?, ?, ?, ?, ?);
			""";
	private static final String DELETE_SQL = "delete from old_customer";
	private static final Path PATH_FICHERO_DATOS = Path.of("datos", "customers.bin");

	public static void main(String[] args) {
		File fichero = PATH_FICHERO_DATOS.toFile();

		try (Connection conexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				PreparedStatement sentenciaInsert = conexion.prepareStatement(INSERT_SQL);
				PreparedStatement sentenciaDelete = conexion.prepareStatement(DELETE_SQL);
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
			
			int numRegistrosAfectados = sentenciaDelete.executeUpdate();
			System.out.printf("Se han borrado %s filas\n", numRegistrosAfectados);
			
			while (true) {
				Customer c = (Customer)ois.readObject();
				
				//System.out.printf("Fecha de creación: %s\n", c.getCreateDate());
				
				sentenciaInsert.setInt(1, c.getId());
				sentenciaInsert.setInt(2, c.getStoreId());
				sentenciaInsert.setString(3, c.getFirstName());
				sentenciaInsert.setString(4, c.getLastName());
				sentenciaInsert.setString(5, c.getEmail());
				sentenciaInsert.setInt(6, c.getAddressId());
				sentenciaInsert.setBoolean(7, c.isActive());
				sentenciaInsert.setTimestamp(8, c.getCreateDate());
				sentenciaInsert.setTimestamp(9, c.getLastUpdate());
				
				numRegistrosAfectados = sentenciaInsert.executeUpdate();
				
				//System.out.printf("Se han actualizado %s registros.\n", numRegistrosAfectados);

			}

		} catch (EOFException e) {
			System.out.println("Se haa llegado al fin de fichero.");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Importación finalizada");

	}
}
