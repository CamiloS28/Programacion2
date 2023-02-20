package co.edu.unbosque.sockets.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public final class ClienteSencillo {
	public ClienteSencillo() {
	}

	public void ejecuta(int puerto) {
		try {
			Socket cliente = new Socket("localhost", puerto);
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

