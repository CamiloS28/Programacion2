package co.edu.unbosque.hilos;

public class MiClasePingPong extends Thread {

	private String palabra; // variable a imprimir
	private int tiempoDeEspera; // tiempo entre impresiones

	public MiClasePingPong(String queImprimir, int cantidadSegundos) {
		palabra = queImprimir;
		tiempoDeEspera = cantidadSegundos;
	}

	public void run() { // sobreescritura del método
		while (true) {
			System.out.println(palabra + "");
			try {
				sleep(tiempoDeEspera);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}