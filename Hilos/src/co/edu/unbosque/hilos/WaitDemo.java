package co.edu.unbosque.hilos;

public class WaitDemo extends Thread {
	public static void main(String[] args)
	{

		GunFight gf = new GunFight();

		// Creating a new thread and invoking
		// our fire() method on it
		new Thread() {
			@Override public void run() { gf.fire(60); }
		}.start();

		// Creating a new thread and invoking
		// our reload method on it
		new Thread() {
			@Override public void run() { gf.reload(); }
		}.start();
	}
}