package co.edu.unbosque.quiensoy;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class QuienEs {
//inicio
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite host:");
		String host = entrada.next();
		if (host != null) {
			try {
				InetAddress dir = InetAddress.getByName(host);
				System.out.println("IP: " + dir.getHostAddress());
				System.out.println("Nombre: " + dir.getHostName());//
			} catch (UnknownHostException e) {
				System.out.println("host desconocido");
			}
		}
	}
}
