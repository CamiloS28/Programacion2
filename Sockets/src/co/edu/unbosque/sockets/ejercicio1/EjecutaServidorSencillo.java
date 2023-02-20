package co.edu.unbosque.sockets.ejercicio1;

import java.util.Scanner;

public class EjecutaServidorSencillo {

	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("SERVIDOR> Digite Puerto:");
		int puerto = entrada.nextInt();
		new ServidorSencillo().ejecuta(puerto);
	}
}

