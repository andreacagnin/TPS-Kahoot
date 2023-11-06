package model;
import java.io.*; 
import java.net.*; 

public class Server extends Thread { 
	
	private ServerSocket server; 
	private Socket richiestaClient;
	
	public Server() { 
		
		try { 
			
			server = new ServerSocket(20000, 5); 
			System.out.println("PUO ENTRAREEEH"); 
			this.start(); 
			
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}
	
	public void run() { 
		
		try { 
			
			while (true) { 
				
				richiestaClient = server.accept(); /* Quando un client cerca di connettersi, il server genera un thread per gestire quel client */ 
				new Connessione(richiestaClient); 
				
			} 
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}
}
