package es.jllopezalvarez.programacion.ut14.ejemplos.ejemplos03callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Ejemplo de llamadas a procedimientos almancenados usando parámetros por
 * nombre
 *
 */
public class Ejemplo03BCallableStatement {

	// Específico de MySQL: para poder usar procedimientos almacenados pasando
	// parámetros por nombre, hay que dar permisos al usuario para acceder
	// a mysql.proc. Esto da permisos para ver (que no ejecutar) TODOS los
	// procedimientos de todas las BBDD del sistema.
	// Para hacerlo, con root o similar:
	// 		grant select on mysql.proc to sakilauser@localhost;
	// 		flush privileges;
	// Para eliminarlos, tb con root o similar:
	//		revoke select on mysql.proc from sakilauser@localhost;
	//		flush privileges;
	private static final String CONNECTION_URL = "jdbc:mysql://localhost/sakila";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";

	public static void main(String[] args) {
		System.out.println("Comprobando si hay stock de la película con id 1 en la tienda con id 1");
		int copiasDisponibles = obtenerStockPelicula(1, 1);
		System.out.printf("Hay %d copias disponibles de la película\n", copiasDisponibles);
	}

	private static int obtenerStockPelicula(int idPelicula, int idTienda) {
		String llamadaSp = "call film_in_stock(?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
				CallableStatement st = conn.prepareCall(llamadaSp)) {

			
			// Se añaden los parámetros por su nombre.
			// No hay por qué añadirlos en orden.
			st.setInt("p_film_id", idPelicula);
			st.setInt("p_store_id", idTienda);
			// El tercer parámetro es de salida. Hay que usar registerOutParameter,
			// indicando el tipo del parámetro que esperamos que se devuelva.
			st.registerOutParameter("p_film_count", java.sql.Types.INTEGER);
			st.execute();
			// Para recuperar el valor del parámetro se usa el su índice (posición).
			int stockPelicula = st.getInt(3);

			return stockPelicula;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
			throw new RuntimeException("Error al obtener el stock de la película", ex);
		}
	}

}
