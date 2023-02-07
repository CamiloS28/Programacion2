package co.edu.unbosque.hilos;

public class Main {
	public static void main(String[] args) {
		MiPrimerThread t = new MiPrimerThread();
		t.start();
		System.out.println("Fin del thread");
		ejecutarThread1();
	}
	
	public static void ejecutarThread1() {
		Thread t = new Thread(new Mi2oThread());
		t.start();
		System.out.println("Fin del thread en el método");
	}
}
