package co.edu.unbosque.sockets.ejercicio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class ServidorSencillo {
	public ServidorSencillo() {
	}

	public void ejecuta(int puerto) {
		try {
			System.out.println("Servidor a la escucha");
			// Ahora se crea un Socket servidor para esperar peticiones
			ServerSocket servidor = new ServerSocket(puerto);
			Socket cliente;
			// Cada vez que se conecta el cliente le enviamos un saludo
			try {
				while ((cliente = servidor.accept()) != null) {
					new Thread(new Saludo(cliente)).start();
                    // En la línea anterior, observe que se inicia un hilo para cada petición.
				}

			} finally {
				servidor.close();

			}

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
