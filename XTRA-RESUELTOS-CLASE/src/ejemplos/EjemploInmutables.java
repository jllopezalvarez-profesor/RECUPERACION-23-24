package ejemplos;

public class EjemploInmutables {
	public static void main(String[] args) {

		String s = "Hola";

		System.out.printf("S antes de toUpperCase %s\n", s);

		String s2 = s.toUpperCase();

		System.out.printf("S después de toUpperCase %s\n", s);

		System.out.printf("S2 %s\n", s2);

		String s3 = " dfahsjkf asjkdfkask hasd fasd ";
		s3 = s3.trim();

		Persona p = new Persona(1234, "José Luis");
		System.out.println(p);
		cambiarAlgo(p);
		System.out.println(p);
		
		int numero = 4;
		System.out.println(numero);
		cambiarAlgo(numero);
		System.out.println(numero);
		

	}
	
	private static void cambiarAlgo(Persona p) {
		p.setNombreApellidos("XX - " + p.getNombreApellidos());
	}
	
	private static void cambiarAlgo(int n) {
		n = n*2;
	}
	
}
