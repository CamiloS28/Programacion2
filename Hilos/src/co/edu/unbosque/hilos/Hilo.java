package co.edu.unbosque.hilos;

public class Hilo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0 ; i<8 ; i++) {
			System.out.println("El Hilo del:"+Thread.currentThread().getName());
		}
	}

}
