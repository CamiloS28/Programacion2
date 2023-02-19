package co.edu.unbosque.quiensoy;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class QuienSoy {

	public static void main(String[] args) {
		try {
			InetAddress dir = InetAddress.getLocalHost();
			int i = dir.toString().indexOf("/");
			String dirS = dir.toString().substring(i+1);
			System.out.println(dir+"\n"+ dirS);
		} catch (UnknownHostException e) {
			System.out.println("host desconocido");
		}
	}
}

