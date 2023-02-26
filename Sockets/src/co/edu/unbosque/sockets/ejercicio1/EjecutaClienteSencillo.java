package co.edu.unbosque.sockets.ejercicio1;

import java.util.Scanner;

public class EjecutaClienteSencillo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("CLIENTE> Digite dirip:Puerto -> ");
		String iPpuerto = entrada.next();
		new ClienteSencillo().ejecuta(iPpuerto);
	}
}

