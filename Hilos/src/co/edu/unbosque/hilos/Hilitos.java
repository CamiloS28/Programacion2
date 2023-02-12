package co.edu.unbosque.hilos;

public class Hilitos extends Thread{
	
	public Hilitos(String nombre) {
		setName(nombre);
	}
	
	public void run() {
		System.out.println("Este es mi hilito de:"+getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0 ; i<5 ; ++i) {
			System.out.println("Proceso>"+i);
		}
	}
}
