package co.edu.unbosque.quiensoy;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class QuienEs {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite host:");
		String host = entrada.next();
		if (host != null) {
			try {
				byte[] dirIPS=new byte[] {(byte) 172, 18, 20, 11};
				System.out.println(dirIPS);
				//InetAddress dir = InetAddress.getByName(host);
				InetAddress dirIP = InetAddress.getByAddress(dirIPS);
				System.out.println("IP: " + dirIP.getHostAddress());
				System.out.println("Nombre: " + dirIP.getHostName());
			} catch (UnknownHostException e) {
				System.out.println("host desconocido");
			}
		}
	}
}
