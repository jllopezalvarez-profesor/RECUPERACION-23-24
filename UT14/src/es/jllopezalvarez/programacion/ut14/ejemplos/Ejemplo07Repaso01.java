package es.jllopezalvarez.programacion.ut14.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ejemplo07Repaso01 {

	private static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static final String SQL_TODOS_EMPLOYEE = """
			select staff_id, first_name, last_name from staff
			""";
	private static final String SQL_BUSCAR_CUSTOMER = """
			select customer_id, first_name, last_name from customer
			where first_name like ? or last_name like ?
			""";

	private static final String DML_UPDATE_CUSTOMER_NAME = """
			update customer set last_name = concat(last_name, '**')
			where customer_id = ?
			""";

	private static final String DML_DELETE_CUSTOMER = """
			delete from customer where last_update > ?
			""";

	public static void main(String[] args) {
//		ejemploStatement();
//		ejemploPreparedStatement("CAN");
//		ejemploUpdatePreparedStatement(100_000);
//		ejemploUpdatePreparedStatement(100);
		ejemploDeletePreparedStatement("2025-01-01 00:00:00");
		ejemploDeletePreparedStatement("2000-01-01 00:00:00");

		System.out.println("Fin del programa");

	}

	private static void ejemploDeletePreparedStatement(String fecha) {
		try (Connection conexion = DriverManager.getConnection(CONNECTION_STRING, USERNAME,
				PASSWORD); PreparedStatement ps = conexion.prepareStatement(DML_DELETE_CUSTOMER);) {

			ps.setTimestamp(1, Timestamp.valueOf(fecha));

			// executeQuery no puede usarse con sentencias que no devuelven datos, como
			// update o delete. Siempre tiene que usarse con select.
			// ps.executeQuery(); // <-- Mal, en este caso
			int cuantosActualizados = ps.executeUpdate();

			System.out.printf("Se han eliminado %d clientes\n", cuantosActualizados);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void ejemploUpdatePreparedStatement(int idCliente) {
		try (Connection conexion = DriverManager.getConnection(CONNECTION_STRING, USERNAME,
				PASSWORD);
				PreparedStatement ps = conexion.prepareStatement(DML_UPDATE_CUSTOMER_NAME);) {

			ps.setInt(1, idCliente);
			
			int cuantosActualizados = ps.executeUpdate();

			System.out.printf("Se han actualizado %d clientes\n", cuantosActualizados);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void ejemploPreparedStatement(String cadenaBusqueda) {
		try (Connection conexion = DriverManager.getConnection(CONNECTION_STRING, USERNAME,
				PASSWORD); PreparedStatement ps = conexion.prepareStatement(SQL_BUSCAR_CUSTOMER)) {

			cadenaBusqueda = "%" + cadenaBusqueda + "%";

			ps.setString(1, cadenaBusqueda);
			ps.setString(2, cadenaBusqueda);

			try (ResultSet datos = ps.executeQuery()) {

				// Podemos saber si hay o no datos en el resultset llamando a isBeforeFirst nada
				// más abrir el resultset
				// System.out.println("¿Delante del primero? " + datos.isBeforeFirst());

				// Lo podemos usar para poner un mensaje si no hay datos
				if (!datos.isBeforeFirst()) {
					// No hay datos
					System.out.println("No se han encontrado empleados.");
				} else {
					// Mostramos los datos
					while (datos.next()) {
						boolean b = datos.getBoolean(1);
						
						System.out.printf("%s - %s - %s\n", datos.getInt(1),
								datos.getString("first_name"), datos.getString("last_name"));
					}
//						if (datos.next()) {
//							System.out.println(datos.getInt(1));
//							System.out.println(datos.getString("first_name"));
//							System.out.println(datos.getString("last_name"));
//						}
//						if (datos.next()) {
//							System.out.println(datos.getInt(1));
//							System.out.println(datos.getString("first_name"));
//							System.out.println(datos.getString("last_name"));
//						}
				}

			} catch (SQLException e) {
				System.out.println("Error al ejecutar la consulta.");
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println("Error al abrir la conexion o al crear el objeto PreparedStatement");
			e.printStackTrace();
		}

	}

	private static void ejemploStatement() {
		try (Connection conexion = DriverManager.getConnection(CONNECTION_STRING, USERNAME,
				PASSWORD)) {

			try (Statement statement = conexion.createStatement()) {

				// En general, execute no para consultar (leer) datos. Es más fácil executeQuery
				// ResultSet datos = statement.execute(SQL_TODOS_EMPLOYEE);

				// ExecuteUpdate tampoco para consultar
				// statement.executeUpdate(SQL_TODOS_EMPLOYEE);

				try (ResultSet datos = statement.executeQuery(SQL_TODOS_EMPLOYEE)) {

					// Podemos saber si hay o no datos en el resultset llamando a isBeforeFirst nada
					// más abrir el resultset
					// System.out.println("¿Delante del primero? " + datos.isBeforeFirst());

					// Lo podemos usar para poner un mensaje si no hay datos
					if (!datos.isBeforeFirst()) {
						// No hay datos
						System.out.println("No se han encontrado empleados.");
					} else {
						// Mostramos los datos
						while (datos.next()) {
							System.out.println(datos.getInt(1));
							System.out.println(datos.getString("first_name"));
							System.out.println(datos.getString("last_name"));
						}
//						if (datos.next()) {
//							System.out.println(datos.getInt(1));
//							System.out.println(datos.getString("first_name"));
//							System.out.println(datos.getString("last_name"));
//						}
//						if (datos.next()) {
//							System.out.println(datos.getInt(1));
//							System.out.println(datos.getString("first_name"));
//							System.out.println(datos.getString("last_name"));
//						}
					}

				} catch (SQLException e) {
					System.out.println("Error al ejecutar la consulta.");
					e.printStackTrace();
				}

			} catch (SQLException e) {
				System.out.println("Error al crear objeto Statement.");
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println("Error al abrir la conexión.");
			e.printStackTrace();
		}
	}

}
