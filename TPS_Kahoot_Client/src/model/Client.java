package model;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import view.Client_GUI;

public class Client {
	
	private static final long serialVersionUID = 1L; // You can choose your own value
    private Socket connessione;
    
    private BufferedReader dalServer; 
	private PrintStream alServer;
    
    private ObjectInputStream in;
	private ObjectOutputStream out;
	private Object receivedArray;
	private Domande domande;
	
	private Client_GUI finestra;
	
	public Client(String indirizzo, Client_GUI finestra) { 
		
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
			Thread.sleep(1000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
}

/*package model;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
	
	private static final long serialVersionUID = 1L; // You can choose your own value
    private Socket connessione;
    private ObjectInputStream in;
	private ObjectOutputStream out;
	private Object receivedArray;
	
	public Client(String indirizzo) { 
		
		try { 
			connessione = new Socket(indirizzo, 20000); 
			
			out = new ObjectOutputStream(connessione.getOutputStream());
			in = new ObjectInputStream(connessione.getInputStream());
			
			receivedArray = in.readObject();
			
		} catch (IOException | ClassNotFoundException e) { 
			
			e.printStackTrace(); 
		} 
	}

	public void conversazione() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			
			//receivedArray = in.readObject();
			System.out.print("Received string array: " + receivedArray);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
}*/

