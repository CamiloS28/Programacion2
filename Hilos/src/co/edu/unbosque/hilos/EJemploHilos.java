package co.edu.unbosque.hilos;

public class EJemploHilos {
	public static void main(String args[]) {
		Thread hilo = new Thread(new Hilo(),"uno");
		Thread hilo2 = new Thread(new Hilo(),"dos");
		hilo2.start();
		hilo.start();
		System.out.println("final del main");
	}
}
