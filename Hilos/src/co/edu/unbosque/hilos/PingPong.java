package co.edu.unbosque.hilos;

public class PingPong {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declaración de dos hilos
		MiClasePingPong p1 = new MiClasePingPong("GOLPE UNO", 30);
		MiClasePingPong p2 = new MiClasePingPong("GOLPE DOS", 10);
		// Alistamiento de los hilos -Activación-
		p1.start();
		p2.start();
		// Espera de dos segundos
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// return;
		}

		p1.interrupt();
		p2.interrupt();
	}
}
