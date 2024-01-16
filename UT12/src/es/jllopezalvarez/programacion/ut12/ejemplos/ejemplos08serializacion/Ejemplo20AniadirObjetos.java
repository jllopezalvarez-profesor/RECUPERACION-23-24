package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos08serializacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.Random;

public class Ejemplo20AniadirObjetos {

	private static final Path PATH_FICHERO_PUNTOS = Path.of("FicherosPrueba", "puntos.dat");
	private static Random rnd = new Random();

	public static void main(String[] args) throws FileNotFoundException, IOException {

		File fichero = PATH_FICHERO_PUNTOS.toFile();

		if (!fichero.exists()) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
			}
		}

		// Escribir el fichero
		try (ObjectOutputStream oos = new ObjectAppendOutputStream(new FileOutputStream(fichero, true))) {
			oos.writeObject(new Punto(rnd.nextInt(100), rnd.nextInt(100)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Leer el fichero
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
			while (true) {
				Punto p = (Punto) ois.readObject();
				System.out.println(p);
			}
		} catch (EOFException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static class ObjectAppendOutputStream extends ObjectOutputStream {

		public ObjectAppendOutputStream() throws IOException, SecurityException {
			super();
			// TODO Auto-generated constructor stub
		}

		public ObjectAppendOutputStream(OutputStream out) throws IOException {
			super(out);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected void writeStreamHeader() throws IOException {

		}

	}
	
}



class Punto implements Serializable {
	private int x;
	private int y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Punto [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}
}
