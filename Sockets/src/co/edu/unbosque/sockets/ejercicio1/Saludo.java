package co.edu.unbosque.sockets.ejercicio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Saludo implements Runnable {
	private Socket cliente;

	public Saludo(Socket cliente) {
		this.cliente = cliente;

	}
	
	public void run() {
		System.out.println("Cliente conectado....");
		try {
			// Obtenemos un Stream de escritura a partir del Socket del
			// cliente
			PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
			pw.println("Hola desde el Servidor");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
