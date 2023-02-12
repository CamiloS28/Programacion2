package co.edu.unbosque.hilos;

public class EjercutarHilitos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilitos h1 = new Hilitos("Hilo 1");
		h1.start();
		Hilitos h2 = new Hilitos("Hilo 2");
		h2.start();
		System.out.println("Fin del proceso main()");
	}

}
