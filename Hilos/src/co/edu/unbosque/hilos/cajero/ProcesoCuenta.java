package co.edu.unbosque.hilos.cajero;

public class ProcesoCuenta implements Runnable {
	private CuentaBancaria cb = new CuentaBancaria();

	public void run() {
		for (int x = 0; x < 5; x++) {
			realizarRetiro(10);
			if (cb.getSaldo() < 0) {
				System.out.println("Cuenta sobregirada - Saldo actual: "
						+ cb.getSaldo());
			}
		}
	}
	
	private synchronized void realizarRetiro(int valor) {
		if (cb.getSaldo() >= valor) {
			//System.out.println(Thread.currentThread().getName() + " retira: " + valor
			//		+ " ahora el saldo es de : " + cb.getSaldo());
			System.out.println(Thread.currentThread().getName() + " Tiene saldo actual de: " + cb.getSaldo()+" y va a retirar: " + valor);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
			cb.retirar(valor);
			System.out.println(" ** "+
					Thread.currentThread().getName() + " hizo retiro exitoso de: " + valor + 
					" ahora su saldo es : " + cb.getSaldo());
		} else {
			System.out.println("No hay saldo para " + Thread.currentThread().getName()
					+ " para retirar " + cb.getSaldo());
		}
	}

	private synchronized void realizarRetiro1(int valor) {
		if (cb.getSaldo() >= valor) {
			System.out.println(Thread.currentThread().getName()
					+ " Se prepara para retirar: " + valor
					+ " y el saldo en este momento es de : " + cb.getSaldo());
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}
			cb.retirar(valor);
			System.out.println(Thread.currentThread().getName()
					+ " realizó el retiro de: " + valor + "\n");
		} else {
			System.out.println("No hay saldo suficiente para "
					+ Thread.currentThread().getName() + " para poder retirar "
					+ cb.getSaldo());
		}
	}
}
