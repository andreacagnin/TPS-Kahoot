package model;
import java.io.*; 
import java.net.*;

public class Server extends Thread { 
	
	private ServerSocket server; 
	private Socket connection;
	private Quiz quiz;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public Server() { 
		
		
		try { 
			
			server = new ServerSocket(20000, 5); 
			System.out.println("PUO ENTRAREEEH"); 
			this.start(); 
			connection = server.accept();
			
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}
	
	public void inviaQuiz() {
		// TODO Auto-generated method stub
		
        try {
        	
        	ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
			out.writeObject(quiz.invioDomanda(0));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() { 
		
		try { 
			
			while (true) { 
				
				connection = server.accept(); /* Quando un client cerca di connettersi, il server genera un thread per gestire quel client */ 
				
				in = new ObjectInputStream(connection.getInputStream());
				out = new ObjectOutputStream(connection.getOutputStream());
				
				new Connessione(connection); 
			} 
			
		} catch (IOException e) { 
			
			e.printStackTrace(); 
			
		} 
	}

	public void setQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		this.quiz = quiz;
	}
}
