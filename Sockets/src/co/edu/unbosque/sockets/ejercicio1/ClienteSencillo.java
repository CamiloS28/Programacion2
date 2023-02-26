package co.edu.unbosque.sockets.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public final class ClienteSencillo {

	public void ejecuta(String ipPuerto) {
		try {
			String [] ipp = new String[2];
			ipp = ipPuerto.split(":");
			String ip = ipp[0];
			int puerto = Integer.parseInt(ipp[1]);
			Socket cliente = new Socket(ip, puerto);
			try {
				BufferedReader br = 
						new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				String saludo;
				while ((saludo = br.readLine()) != null) {
					System.out.println(saludo);
				}
			} finally {
				if (cliente != null)
					cliente.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

