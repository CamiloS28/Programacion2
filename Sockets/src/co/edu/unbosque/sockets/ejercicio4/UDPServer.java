package co.edu.unbosque.sockets.ejercicio4;

import java.io.*; 
import java.net.*; 
  
public class UDPServer { 
  public static void main(String args[]) throws Exception 
    { 
     try
     { 
      DatagramSocket serverSocket = new DatagramSocket(9876); 
      byte[] receiveData = new byte[10]; 
      byte[] sendData  = new byte[10]; 
  
      while(true) 
        { 
          receiveData = new byte[10]; 
          DatagramPacket receivePacket = 
             new DatagramPacket(receiveData, receiveData.length); 

          System.out.println ("Esperando datagramas...");

          serverSocket.receive(receivePacket); 
          String sentence = new String(receivePacket.getData()); 
  
          InetAddress IPAddress = receivePacket.getAddress(); 
          int port = receivePacket.getPort(); 
  
          System.out.println ("Desde  : " + IPAddress + ":" + port);
          System.out.println ("Mensaje: " + sentence);

          String capitalizedSentence = sentence.toUpperCase(); 
          sendData = capitalizedSentence.getBytes(); 
  
          DatagramPacket sendPacket = 
             new DatagramPacket(sendData, sendData.length, IPAddress, 
                               port); 
  
          serverSocket.send(sendPacket); 
        } 

     }
      catch (SocketException ex) {
        System.out.println("UDP Port 9876 is occupied.");
        System.exit(1);
      }

    } 
}  

