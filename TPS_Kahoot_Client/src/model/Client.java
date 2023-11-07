package model;

import java.io.*; 
import java.net.*;

import view.Client_GUI; 

public class Client { 
	Client_GUI gui = new Client_GUI();
	private Socket connessione; 
	private BufferedReader dalServer; 
	private PrintStream alServer; // Scrive bytes mentre PrintWriter scrive caratteri 
	
	public Client() { 
		BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			
			System.out.println("Inserire l'indirizzo del server"); 
			String indirizzo = gui.ipserver; 
			connessione = new Socket(indirizzo, 20000); 
			dalServer = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			alServer = new PrintStream(connessione.getOutputStream()); 
			gui.panelRichiestaClient.setVisible(false);
		} catch (IOException e) { e.printStackTrace(); } 
	}
	public void connectToServer(String serverAddress) {
        try {
            connessione = new Socket(serverAddress, 20000);
            dalServer = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
            alServer = new PrintStream(connessione.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
