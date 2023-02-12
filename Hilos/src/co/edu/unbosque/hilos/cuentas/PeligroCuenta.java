package co.edu.unbosque.hilos.cuentas;

public class PeligroCuenta implements Runnable {

	private CuentaBanco cb = new CuentaBanco();

	public void run() {
		for (int x = 0; x < 5; x++) {
			realizarRetiro(10);
			if (cb.getSaldo() < 0) {
				System.out.println(Thread.currentThread().getName() + " Tiene cuenta sobregirada - Saldo actual: "
						+ cb.getSaldo());
			}
		}
	}

	private void realizarRetiro(int valor) {
		if (cb.getSaldo() >= valor) {
			System.out.println(Thread.currentThread().getName() + " Tiene saldo actual de: " + cb.getSaldo()
					+ " y va a retirar: " + valor);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
			cb.retirar(valor);
			System.out.println(" ** " + Thread.currentThread().getName() + " hizo retiro exitoso de: " + valor
					+ " ahora su saldo es : " + cb.getSaldo());
		} else {
			System.out.println(
					"No hay saldo para " + Thread.currentThread().getName() + " para retirar " + cb.getSaldo());
		}
	}
}

