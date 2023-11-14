package model;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import view.Client_GUI;

public class Client {
	
    private Socket connessione;
    
    private BufferedReader dalServer; 
	private PrintStream alServer;
    
    private ObjectInputStream in;
	private ObjectOutputStream out;
	private Object receivedArray;
	private Domande domande;
	private String risposta;
	private Punteggi punteggi;
	
	private Client_GUI finestra;
	
	public Client(String indirizzo, Client_GUI finestra) { 
		
		this.finestra = finestra;
		
		boolean connesso = false;
		
		while(!connesso) {
			try {
				connessione = new Socket(indirizzo, 20000);
				connesso = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		try { 
			
			String message = "";
			
			dalServer = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			alServer = new PrintStream(connessione.getOutputStream()); 
			
			message = dalServer.readLine();
			if(message.compareTo("WAIT") == 0)
				alServer.println("WAITING");
			while(message.compareTo("WAIT") == 0) {
				message = dalServer.readLine();
			}
			
			if(message.compareTo("GO") == 0) {
				
				out = new ObjectOutputStream(connessione.getOutputStream());
				in = new ObjectInputStream(connessione.getInputStream());
				
	            receivedArray = in.readObject();

	            System.out.print("Received string array: " + receivedArray);
	            
	            domande = new Domande(receivedArray);
	            finestra.setDomande(domande);
	            
			}
            
		} catch (IOException | ClassNotFoundException e) { 
			
			e.printStackTrace(); 
		} 
	}
	
	public void conversazione() {
		// TODO Auto-generated method stub
		try {
			
			Object o = (Object) risposta;
			int punteggi = 0;
			
			System.out.println("a");
			out.writeObject(o);
			
			punteggi = (int) in.readObject();
			
			this.punteggi.setPunteggi(punteggi);
			
			receivedArray = in.readObject();

            System.out.print("Received string array: " + receivedArray);
            
            domande = new Domande(receivedArray);
            finestra.setDomande(domande);
			
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public Punteggi getPunteggi() {
		return punteggi;
	}

	public void setPunteggi(Punteggi punteggi) {
		this.punteggi = punteggi;
	}
 
}