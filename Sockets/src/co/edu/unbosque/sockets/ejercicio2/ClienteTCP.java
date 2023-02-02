package co.edu.unbosque.sockets.ejercicio2;

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

public class ClienteTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress direccionIP = null;
		try {
			direccionIP = InetAddress.getByName(args[0]);
		} catch (UnknownHostException e) {
			System.out.println("No se ha encontrado el Host");
		}
		int puerto = 1235;
		for (int n = 1; n < args.length; n++) {
			Socket socket = null;
			DataInputStream dis = null;
			DataOutputStream dos = null;
			try {
				int numero = Integer.parseInt(args[n]);
				socket = new Socket(direccionIP, puerto);
				// Para recibir las respuesta desde el Servidor
				dis = new DataInputStream(socket.getInputStream());
				// Para enviar datos al Servidor
				dos = new DataOutputStream(socket.getOutputStream());
				dos.writeInt(numero); // Escribimos el numero
				long resultado = dis.readLong(); // Leemos el resultado final
				// Ahora, mostramos en pantalla
				System.out.println("Solicitud= " + numero + "\t Resultado =" + resultado);
				dis.close();
				dos.close();
				//socket.close();
			} catch (Exception e) {
				System.err.println("Se produjo la excepción " + e);
			}
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar el socket " + e);
			}
		}
	}

}

