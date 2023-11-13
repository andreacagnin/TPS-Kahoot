package model;
import java.io.*; 
import java.net.*;
import java.util.ArrayList;

public class Server extends Thread { 
	
	private ServerSocket server; 
	private Socket connection;
	private Quiz quiz;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	private PrintStream alClient;
	private boolean flag;
	
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
				
				connection = server.accept(); /* Quando un client cerca di connettersi, il server genera un thread per gestire quel client */
				new Connessione(connection, this);
			} 
			
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}
	
	public void inviaQuiz(int i) {
		// TODO Auto-generated method stub
	    this.flag = true;
	}

	public void setQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		this.quiz = quiz;
	}
	
	public ArrayList<String> getQuiz(int i) {
		return quiz.invioDomanda(i);
	}
	
	public boolean getFlag() {
		return this.flag;
	}
}
/*package model;
import java.io.*; 
import java.net.*;

public class Server extends Thread { 
	
	private ServerSocket server; 
	private Socket connection;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Quiz quiz;
	
	public Server(Quiz quiz) { 
		
		this.quiz = quiz;
		
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
				
				connection = server.accept();  Quando un client cerca di connettersi, il server genera un thread per gestire quel client 
				new Connessione(connection, quiz);
				
			} 
			
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}
	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

}*/
