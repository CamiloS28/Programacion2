package co.edu.unbosque.hilos;

public class MiClaseSubirBajar extends Thread {

	private String palabra;

	public MiClaseSubirBajar(String str) {
		palabra = str;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(palabra);
		}

	}

}