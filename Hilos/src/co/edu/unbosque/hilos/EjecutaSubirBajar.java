package co.edu.unbosque.hilos;

public class EjecutaSubirBajar {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread tM = new SubirBajar("MMM");
		Thread tm = new SubirBajar("mmm");
		tm.setPriority(Thread.MAX_PRIORITY);
		tM.setPriority(Thread.MIN_PRIORITY);
		tm.start();
		tM.start();

	}
}
