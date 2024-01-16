package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos02path;

import java.nio.file.Path;

public class Ejemplo05Path {
	public static void main(String[] args) {
		// Creamos un path relativo
		Path pathA = Path.of("var", "log");
		System.out.printf("%s es %s\n", pathA, pathA.isAbsolute() ? "absoluto" : "relativo");

		// Creamos un path absoluto
		Path pathB = Path.of("/", "var", "log");
		System.out.printf("%s es %s\n", pathB, pathB.isAbsolute() ? "absoluto" : "relativo");

		// Obtenemos el path de la carpeta home del usuario.
		Path pathHome = Path.of(System.getProperty("user.home"));
		System.out.printf("Home del usuario: %s\n", pathHome);

		// Obtenemos el path B como relativo al home del usuario
		Path pathBRelativoAHome = pathHome.relativize(pathB);
		System.out.printf("Path de logs relativo a home del usuario: %s\n", pathBRelativoAHome);

		// Obtenemos el path de la carpeta donde se ejecuta el programa.
		Path pathPrograma = Path.of(System.getProperty("user.dir"));
		System.out.printf("Path donde está el programa: %s\n", pathPrograma);

		// Obtenemos el path B como relativo al del programa
		Path pathBRelativoAPrograma = pathPrograma.relativize(pathB);
		System.out.printf("Path de logs relativo a path del programa: %s\n", pathBRelativoAPrograma);

		// Volvemos a convertir el path relativo en absoluto
		Path pathBAbsoluto = pathBRelativoAPrograma.toAbsolutePath();
		System.out.printf("Path de logs (convertido a absoluto): %s\n", pathBAbsoluto);
		
		// Para eliminar todos los pasos se puede normalizar
		Path pathBAbsolutoNormalizado = pathBAbsoluto.normalize();
		System.out.printf("Path de logs absoluto normalizado: %s\n", pathBAbsolutoNormalizado);
	}
}
