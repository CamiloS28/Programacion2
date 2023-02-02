package co.edu.unbosque.sockets.ejercicio3;

//Programa: TCPServer.java
//Objetivo: Esperar desde un Cliente el envio de un archivo de texto.

import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9801);
		} catch (IOException e) {
			System.err.println("El Puerto no se encuentra Disponible");
			System.exit(1);
		}

		Socket clientSocket = null;
		System.out.println("En espera de conectividad con el cliente.....");

		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("Conexion no Aceptada");
			System.exit(1);
		}

		System.out.println("Conexion Realizada");
		System.out.println("Escriba su Mensaje.....");

		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		String inputLine;

		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println("Server: " + inputLine);
				out.println(inputLine);

				if (inputLine.equals("Suerte"))
					break;
			}

		} catch (IOException e) {
			System.out.println("Error" + e.getCause());
		}

		out.close();
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
}
