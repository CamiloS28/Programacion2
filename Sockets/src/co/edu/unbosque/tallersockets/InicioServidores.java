package co.edu.unbosque.tallersockets;

public class InicioServidores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServidorTCP1235 servidor1 = new ServidorTCP1235();
		ServidorTCP2468 servidor2 = new ServidorTCP2468();
		servidor1.start();
		servidor2.start();
	}

}
