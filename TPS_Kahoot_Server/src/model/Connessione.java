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
	
	private boolean endQuiz;
	
	public Connessione(Socket richiestaClient, Server server) {
		
		this.endQuiz = false;
		
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
		
		setQuiz(server.getQuiz());
		
		try { 
			
			int i = 1;
			while(!getEndQuiz()) {
			
				String s = "";
				
				Object o = in.readObject();
				int punteggi = 0;
				
				s = (String) o;
				
			
				if(s.compareTo("") == 0) {
					
				}else {
					if(quiz.controlloRisposte(s)) {
						punteggi += 3;
						System.out.println("giusto");
					}else {
						System.out.println("sbagliato");
					}
				}
				
				
				o = (Object) punteggi;
				
				System.out.println("b");
				out.writeObject(o);
				
				out.writeObject(quiz.invioDomanda(i));
				if(quiz.getFlag())
					setEndQuiz(true);
				i++;
				
			}
			
			connessione.close(); 
			
		} catch (IOException | ClassNotFoundException e) { e.printStackTrace(); } 
	} 
	
	public void setQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		this.quiz = quiz;
	}
<<<<<<< Updated upstream
}
=======
	
	public void setEndQuiz(boolean flag) {
		this.endQuiz = flag;
	}
	
	public boolean getEndQuiz() {
		return this.endQuiz;
	}
}
>>>>>>> Stashed changes
