package co.edu.unbosque.tallersockets;

/* Programa: ServidorTCP.java
 * Objetivo: Servidor para recibir un número entero desde el cliente
 *  y devuelve el cuadrado del número
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServidorTCP {

	private static ServerSocket serverSocket1 = null, serverSocket2 = null;
	
	
	public static void main(String[] args) {
		try {
			System.out.println("SERVIDOR> Host: " + InetAddress.getLocalHost().toString());
			serverSocket1 = new ServerSocket(1235);
			System.out.println("Escuchando por el puerto 1235");
			serverSocket2 = new ServerSocket(2468);
			System.out.println("Escuchando por el puerto 2468");
		} catch (IOException e) {
			//System.err.println("No se detectó la dirección IP " + e);
			System.out.println("Error de IP o al abrir el socket " + e);
		}
		int entrada1, entrada2;
		long salida1, salida2;
		while (true) {
			try {
				Socket socket1 = serverSocket1.accept();
				DataInputStream dis1 = new DataInputStream(socket1.getInputStream());
				DataOutputStream dos1 = new DataOutputStream(socket1.getOutputStream());
				int puerto1 = socket1.getPort(); // Puerto remoto
				int puertoLocal1 = socket1.getLocalPort();
				InetAddress direccionIP1 = socket1.getInetAddress(); // IP remota
				System.out.println("Dirección ip1:"+direccionIP1);
				entrada1 = dis1.readInt(); // Lectura de los datos de la petición
				salida1 = (long) entrada1 * (long) entrada1; // calculamos el
				dos1.writeLong(salida1);
				dis1.close();
				dos1.close();
				socket1.close();
				System.out.println("Puerto Local 1:" + puertoLocal1 + " " + "Cliente:" + direccionIP1 + " -Puerto:" + puerto1
						+ " Entrada:" + entrada1 + " Salida:" + salida1);
				
				Socket socket2 = serverSocket2.accept();
				DataInputStream dis2 = new DataInputStream(socket2.getInputStream());
				DataOutputStream dos2 = new DataOutputStream(socket2.getOutputStream());
				int puerto2 = socket2.getPort(); // Puerto remoto
				int puertoLocal2 = socket2.getLocalPort();
				InetAddress direccionIP2 = socket2.getInetAddress(); // IP remota
				entrada2 = dis2.readInt(); // Lectura de los datos de la petición
				salida2 =  2 * (long) entrada2 + (long) entrada2; // calculamos el
				dos2.writeLong(salida2);

				dis2.close();
				dos2.close();
				socket2.close();	
				System.err.println("Puerto Local 2:" + puertoLocal2 + " " + "Cliente:" + direccionIP2 + " -Puerto:" + puerto2
						+ " Entrada:" + entrada2 + " Salida:" + salida2);

			} catch (Exception e) {
				System.err.println("Se produjo una excepción" + e);
			}
		}
	}

	public void iniciarServidor() {

	}
}
