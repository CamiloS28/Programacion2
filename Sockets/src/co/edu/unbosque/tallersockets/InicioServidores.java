package co.edu.unbosque.tallersockets;

public class InicioServidores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServidorTCPx servidor1 = new ServidorTCPx(1235);
		ServidorTCPx servidor2 = new ServidorTCPx(2589);
		servidor1.start();
		servidor2.start();
	}
}
