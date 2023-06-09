package co.edu.unbosque.sockets.ejercicio4;

import java.io.*; 
import java.net.*; 
  
public class UDPClient { 
	
    public static void main(String args[]) throws Exception 
    { 
     try {
        String serverHostname = new String ("127.0.0.1");

      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 
      DatagramSocket clientSocket = new DatagramSocket(); 
      InetAddress IPAddress = InetAddress.getByName(serverHostname); 
      System.out.println ("Atendiendo la conexion para " + IPAddress + 
                          ") via UDP puerto 9876");
  
      byte[] sendData = new byte[10]; 
      byte[] receiveData = new byte[10]; 
  
      System.out.print("Ingrese el mensaje: ");
      String sentence = inFromUser.readLine(); 
      sendData = sentence.getBytes();         

      System.out.println ("Enviando los datos de " + sendData.length + 
                          " bytes hacia el Servidor.");
      DatagramPacket sendPacket = 
         new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
  
      clientSocket.send(sendPacket); 
  
      DatagramPacket receivePacket = 
         new DatagramPacket(receiveData, receiveData.length); 
  
      System.out.println ("Esperando Paquete de Retorno...");
      clientSocket.setSoTimeout(10000);

      try {
           clientSocket.receive(receivePacket); 
           String modifiedSentence = new String(receivePacket.getData()); 
  
           InetAddress returnIPAddress = receivePacket.getAddress();
           int port = receivePacket.getPort();

           System.out.println ("From server at: " + returnIPAddress + ":" + port);
           System.out.println("Message: " + modifiedSentence); 
          }
      catch (SocketTimeoutException ste){
           System.out.println ("Timeout Occurred: Packet assumed lost");
      }
      clientSocket.close(); 
     }
   catch (UnknownHostException ex) { 
     System.err.println(ex);
    }
   catch (IOException ex) {
     System.err.println(ex);
    }
  } 
} 

