package Servidor;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class Cliente {
    public static final String HOSTNAME = "127.0.0.1";
    
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

	    try {
	    	Socket cliente = new Socket(HOSTNAME, Servidor.PORT);
	    	System.out.println("Conectado ao cliente na porta: " + Servidor.PORT);
	      
	    	Scanner entrada = new Scanner(System.in);
	    	PrintStream saida = new PrintStream(cliente.getOutputStream());
	    	String texto;

	    	/*do {                
	    		System.out.print("Digite uma mensagem (ou sair para finalizar): ");
	    		texto = entrada.nextLine();
	    		saida.println(texto);
	    	}while(!texto.equals("0"));*/
	    	
	    	/*while (true) {
	    		texto = entrada.nextLine();
	    		saida.println(texto);
	    	}*/
	    	
	    	boolean a = true;
	    	String valor_zero = "0";
	    	while(a) {
	    		System.out.print("Digite uma mensagem (ou 0 para finalizar): ");
    			texto = entrada.nextLine();
	    		if(texto.equals(valor_zero)) {
	    			a = false;
		    		saida.println(texto);
		    		//System.out.print("0 para finalizar): ");
	    		}
	    		if(!texto.equals(valor_zero)) {
		    		saida.println(texto);
		    		//System.out.print("mensagem: ");
	    		}
	    	}
	    	
	    	saida.close();
            teclado.close();
            cliente.close();
            
            System.out.println("Cliente Encerrado");
	    	
	    }
	    catch(Exception e) {
	    	System.out.println("Erro: " + e.getClass());
	    }
	}
}