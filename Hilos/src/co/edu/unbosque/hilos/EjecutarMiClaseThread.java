package co.edu.unbosque.hilos;

public class EjecutarMiClaseThread {
	
	public static void main(String[] args) {

		MiClaseThread m1 = new MiClaseThread("m1");
		//m1.setPriority(4);
		m1.start();
		MiClaseThread m2 = new MiClaseThread("m2");
		//m2. setPriority(6);
		m2.start();
	}
}
