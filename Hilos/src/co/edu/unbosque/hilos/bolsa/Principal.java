package co.edu.unbosque.hilos.bolsa;

public class Principal {
//https://www.arquitecturajava.com/java-wait-notify-y-threads/
	public static void main(String[] args) {

		Bolsa bolsa = new Bolsa();
		HiloEnvio hilo = new HiloEnvio(bolsa);
		hilo.start();

		for (int i = 0; i <= 10; i++) {

			Producto p = new Producto();
			try {

				synchronized (bolsa) {

					Thread.sleep(1000);
					if (bolsa.estaLlena()) {
						bolsa.notify();
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			bolsa.addProducto(p);
			System.out.println(bolsa.getSize());

		}

	}

}
