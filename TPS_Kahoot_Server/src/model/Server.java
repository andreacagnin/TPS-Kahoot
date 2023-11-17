package model;
import java.io.*; 
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Server extends Thread { 
	
	private ServerSocket server; 
	private Socket connection;
	private Quiz quiz;
	private ControlloDomande cd;

	private Semaphore semaforo = new Semaphore(1);
	private int index;
	
	public Server() { 
		
		try { 
			
			server = new ServerSocket(20000, 5); 
			System.out.println("PUO ENTRAREEEH"); 
			
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}

	public Semaphore getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	public void run() { 
		
		try { 
			
			while (true) { 
				
				connection = server.accept(); /* Quando un client cerca di connettersi, il server genera un thread per gestire quel client */
				new Connessione(connection, this.quiz, this.cd, this, index);
			} 
			
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}

	public void setQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		this.quiz = quiz;
		this.index = 0;
	}
	
	public Quiz getQuiz() {
		return this.quiz;
	}
	
	public ControlloDomande getCd() {
		return cd;
	}

	public void setCd(ControlloDomande cd) {
		this.cd = cd;
	}
}
