package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static final int PORT = 4000;

	public static void main(String args[]){
        try {
            ServerSocket servidor = new ServerSocket(PORT);
            System.out.println("Servidor iniciado na porta " + PORT);

            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado do IP "+cliente.getInetAddress().getHostAddress());
            
            Scanner entrada = new Scanner(cliente.getInputStream());
	    	String texto;

            /*while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }*/
            
            /*do {
                System.out.println(entrada.nextLine());
	    	}while(entrada.nextLine() != "0");*/
            /*while (entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }*/
            
	    		    	
            /*do {
            	texto = entrada.nextLine();
                System.out.println(texto);
	    	}while(texto.equals("0"));*/
	    	
	    	boolean a = true;
	    	String valor_zero = "0";
	    	while(a) {
    			texto = entrada.nextLine();
	    		if(texto.equals(valor_zero)) {
	    			a = false;
	    		}
	    		if(!texto.equals(valor_zero)) {
	                System.out.println(texto);
	    		}
	    	}
	    	
	    	if(!cliente.isClosed()){  
	    		servidor.close();
	            
	            System.out.println("Servidor Encerrado"); 
	        }  
            
            
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

    }

}