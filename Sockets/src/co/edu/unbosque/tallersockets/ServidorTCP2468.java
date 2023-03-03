package co.edu.unbosque.tallersockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServidorTCP2468  extends Thread{
	
	public void run(){
		// TODO Auto-generated method stub
		try {
			System.out.println("SERVIDOR 2468> Host: " + InetAddress.getLocalHost().toString());
		} catch (UnknownHostException e) {
			System.err.println("No se detectó la dirección IP " + e);
		}
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(2468);
		} catch (IOException e) {
			System.err.println("Error al abrir el socket " + e);
		}
		int entrada;
		long salida;
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				int puerto = socket.getPort(); // Puerto remoto
				int puertoLocal = socket.getLocalPort();
				InetAddress direccionIP = socket.getInetAddress(); // IP remota
				entrada = dis.readInt(); // Lectura de los datos de la petición
				salida = (long) entrada * (long) entrada; // calculamos el
															// resultado como potencia
				// Escribimos el resultado
				dos.writeLong(salida);
				dis.close();
				dos.close();
				socket.close();

				System.out.println("Puerto Local:" + puertoLocal + " " + "Cliente:" + direccionIP + " -Puerto:" + puerto
						+ " Entrada:" + entrada + " Salida:" + salida);

			} catch (Exception e) {
				System.err.println("Se produjo una excepción" + e);
			}
		}

	}
}
