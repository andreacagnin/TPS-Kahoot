package model;


import java.io.*;
import java.net.*;

public class Connessione extends Thread {
	private Socket connessione;
	private Server server;
	private BufferedReader dalClient;
	private PrintStream alClient;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Quiz quiz;
	
	public Connessione(Socket richiestaClient, Server server) {
		
		this.server = server;
		
		try {
			
			String message = "";
			
			connessione = richiestaClient;
			System.out.println("Connesione richiesta da: "+ connessione.getInetAddress().toString()+":"+connessione.getPort());
			
			dalClient = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
			alClient = new PrintStream(connessione.getOutputStream());
			
			alClient.println("WAIT");
			
			message = dalClient.readLine();
			while(message.compareTo("WAITING") != 0) {
				message = dalClient.readLine();
			}
			
			while(!server.getFlag()) {
				server.getFlag();
				System.out.println("");
			}
			
			alClient.println("GO");
			
			in = new ObjectInputStream(connessione.getInputStream());
			out = new ObjectOutputStream(connessione.getOutputStream());

			out.writeObject(server.getQuiz(0));
			out.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.start();
	}
	
	public void run() { 
		
		try { 
			
			String messaggio = ""; 
			
			while (!messaggio.equals("fine")) { 
				
				
			} 
			connessione.close(); 
			
		} catch (IOException e) { e.printStackTrace(); } 
	} 
	
	public void setQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		this.quiz = quiz;
	}
}
