package co.edu.unbosque.hilos;

public class SubirBajar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread tM = new MiClaseSubirBajar("HOLA");
		Thread tm = new MiClaseSubirBajar("hola");
		tm.setPriority(Thread.MAX_PRIORITY);
		tM.setPriority(Thread.MIN_PRIORITY);
		tm.start();
		tM.start();

	}
}
