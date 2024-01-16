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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImportCustomersUpdateable {

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
				old_customer
			where 
				first_name like '%h%';
			""";
	private static final Path PATH_FICHERO_DATOS = Path.of("datos", "customers.bin");

	public static void main(String[] args) {
		File fichero = PATH_FICHERO_DATOS.toFile();

		try (Connection conexion = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				Statement sentenciaSelect = conexion.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet resultSetDatos = sentenciaSelect.executeQuery(SELECT_SQL);
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
			
			while (resultSetDatos.next()) {
				resultSetDatos.deleteRow();
			}
	
//			while (true) {
//				Customer c = (Customer) ois.readObject();
//
//				resultSetDatos.moveToInsertRow();
//
//				resultSetDatos.updateInt(1, c.getId());
//				resultSetDatos.updateInt(2, c.getStoreId());
//				resultSetDatos.updateString(3, c.getFirstName());
//				resultSetDatos.updateString(4, c.getLastName());
//				resultSetDatos.updateString(5, c.getEmail());
//				resultSetDatos.updateInt(6, c.getAddressId());
//				resultSetDatos.updateBoolean(7, c.isActive());
//				resultSetDatos.updateTimestamp(8, c.getCreateDate());
//				resultSetDatos.updateTimestamp(9, c.getLastUpdate());
//
//				resultSetDatos.insertRow();
//			}

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
		} 
//		catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		System.out.println("Importación finalizada");

	}
}
