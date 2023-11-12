package model;

import java.io.*; 
import java.net.*; 

public class Client { 
	private Socket connessione; 
	private BufferedReader dalServer; 
	private PrintStream alServer; // Scrive bytes mentre PrintWriter scrive caratteri 
	
	public Client() { 
		BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			System.out.println("Inserire l'indirizzo del server"); 
			String indirizzo = tastiera.readLine(); 
			connessione = new Socket(indirizzo, 20000); 
			dalServer = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			alServer = new PrintStream(connessione.getOutputStream()); 
		} catch (IOException e) { e.printStackTrace(); } 
	}
 
}
