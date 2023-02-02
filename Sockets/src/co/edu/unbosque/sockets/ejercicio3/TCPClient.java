package co.edu.unbosque.sockets.ejercicio3;

//Programa: TCPClient.java
//Objetivo: Enviar un archivo de texto al Servidor.

import java.io.*;
import java.net.*;

public class TCPClient {
	public static void main(String[] args) throws IOException {

		String serverHostname = new String("127.0.0.1");

		if (args.length > 0)
			serverHostname = args[0];
		System.out.println("Conectando al Servidor " + serverHostname + " En el Puerto 9800");

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			echoSocket = new Socket(serverHostname, 9801);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Servidor Desconocido " + serverHostname);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("No se pudo conectar con  " + serverHostname);
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new FileReader("TCPInputFile.txt"));
		String userInput;

		System.out.print("Mensaje: ");
		while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);

			int a = 0;
			while (stdIn.ready()) {
				int n = Integer.parseInt(in.readLine());
				if (n > a) {
					a = n;
				}

				System.out.println("Mje: " + a);
			}

		}

		out.close();
		in.close();
		stdIn.close();
		echoSocket.close();
	}
}
