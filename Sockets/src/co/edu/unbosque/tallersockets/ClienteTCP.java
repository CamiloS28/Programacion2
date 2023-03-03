package co.edu.unbosque.tallersockets;

/* Programa: ClienteTCP.java
 * Objetivo: Cliente para enviar un número entero al Servidor
 *  y recibe el cuadrado del número
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTCP {

	private static String ipPuerto;
	private static String ip;
	private static String[] ipp;
	private static int puerto;
	private static String[] mensaje;
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		capturarHostPuerto();
		System.out.print("Digite mensaje de numeros separados con coma:");
		String msg = entrada.next();
		mensaje = msg.split(",");
		InetAddress direccionIP = null;
		try {
			direccionIP = InetAddress.getByName(ip);
			System.out.println("direccion ip:"+direccionIP);
		} catch (UnknownHostException e) {
			System.out.println("No se ha encontrado el Host");
		}
		//int puerto = capturarPuertoRenoto();
		enviarMensaje(direccionIP, puerto);
	}

	public static void capturarHostPuerto() {
		System.out.print("CLIENTE> Digite host:puerto>");
		ipPuerto = entrada.next();
		ipp = new String[2];
		ipp = ipPuerto.split(":"); // formato direccionip:puerto
		ip = ipp[0];
		puerto = Integer.parseInt(ipp[1]);
	}

	public static int capturarPuertoRenoto() {
		System.out.print("Digite puerto remoto:");
		return entrada.nextInt();
	}

	public static void enviarMensaje(InetAddress dirIP, int puerto) {
		for (int n = 0; n < mensaje.length; n++) {
			Socket socket = null;
			DataInputStream dis = null;
			DataOutputStream dos = null;
			System.out.println("Entre mensaje:"+mensaje[n]+" "+dirIP+" "+puerto);
			try {
				int numero = Integer.parseInt(mensaje[n]);
				socket = new Socket(dirIP, puerto);
				// Para recibir las respuesta desde el Servidor
				dis = new DataInputStream(socket.getInputStream());
				// Para enviar datos al Servidor
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeInt(numero); // Escribimos el numero
				long resultado = dis.readLong(); // Leemos el resultado final
				// Ahora, mostramos en pantalla
				System.out.print("Puerto Local:" + socket.getLocalPort() + " Puerto:" + socket.getPort() + " ");
				System.out.println("Solicitud= " + numero + "\t Resultado =" + resultado);
				dis.close();
				dos.close();
				// socket.close();
			} catch (Exception e) {
				System.out.println("Se produjo la excepción " + e);
			}
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el socket " + e);
			}
		}
	}
}
