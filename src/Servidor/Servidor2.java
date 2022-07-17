package Servidor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;

public class Servidor2 {
	private static ServerSocket servidor;
	private static Socket cliente;
	private static InputStreamReader inputStreamReader;
	private static BufferedReader bufferedReader;
	private static String texto="";
    public static final int PORT = 4000;

	public static void main(String args[]){
		try {
			servidor = new ServerSocket(PORT); 
	        System.out.println("Servidor iniciado na porta: " + PORT);

	    } catch (IOException e) {
            System.out.println("Erro ao iniciar servidor na porta: " + PORT);
	    }
	  
	  
	    while (!texto.equalsIgnoreCase("0")) {
	        try {
	  
	            cliente = servidor.accept(); 
	            
	            inputStreamReader = new InputStreamReader(cliente.getInputStream());
	            bufferedReader = new BufferedReader(inputStreamReader);                     
	             
	            texto = bufferedReader.readLine();
	  
	            System.out.println(texto);
	              
	            inputStreamReader.close();
	            cliente.close();
	  
	        } catch (IOException ex) {
	            System.out.println("Erro: no envio da mensagem");
	        }
	    }
	    try {
			servidor.close();
            System.out.println("Servidor Encerrado"); 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  }
}