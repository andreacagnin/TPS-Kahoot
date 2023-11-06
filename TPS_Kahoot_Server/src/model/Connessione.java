package model;


import java.io.*;
import java.net.*;

public class Connessione extends Thread {
	private Socket connessione;
	private BufferedReader dalClient;
	private PrintStream alClient;
	
	public Connessione(Socket richiestaClient) {
		
		try {
			
			connessione = richiestaClient;
			System.out.println("Connesione richiesta da: "+ connessione.getInetAddress().toString()+":"+connessione.getPort());
			dalClient = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			alClient = new PrintStream(connessione.getOutputStream());
			this.start();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	public void run() { 
		
		try { 
			
			String messaggio = ""; 
			alClient.println("ENTRAAAAAAH"); 
			
			while (!messaggio.equals("fine")) { 
				
				messaggio = dalClient.readLine(); 
				alClient.println(messaggio); 
				
			} 
			connessione.close(); 
			
		} catch (IOException e) { e.printStackTrace(); } 
	} 
}

