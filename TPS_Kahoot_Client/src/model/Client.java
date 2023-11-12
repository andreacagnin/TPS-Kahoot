package model;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
	
	private static final long serialVersionUID = 1L; // You can choose your own value
    private Socket connessione;
    private BufferedReader dalServer;
    private PrintStream alServer;
    private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public Client(String indirizzo) { 
		
		try { 
			
			connessione = new Socket(indirizzo, 20000); 
			dalServer = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			alServer = new PrintStream(connessione.getOutputStream()); 
			
			out = new ObjectOutputStream(connessione.getOutputStream());
			in = new ObjectInputStream(connessione.getInputStream());
			
            ArrayList<String> receivedArray = (ArrayList<String>) in.readObject();

            System.out.print("Received string array: ");
            for (String str : receivedArray) {
                System.out.print(str + " ");
			}
		} catch (IOException | ClassNotFoundException e) { 
			
			e.printStackTrace(); 
		} 
	}
 
}
