package model;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Connessione extends Thread {
	private Socket connessione;
	private Server server;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Quiz quiz;
	private ControlloDomande cd;
	
	private boolean endQuiz;
	private Semaphore semaforo;
	private int index;

	public Connessione(Socket richiestaClient, Quiz quiz, ControlloDomande cd, Server server, int index) {
		
		this.endQuiz = false;
		this.quiz = quiz;
		this.server = server;
		this.index = index;
		this.cd = cd;
		
		try {
			
			connessione = richiestaClient;
			System.out.println("Connesione richiesta da: "+ connessione.getInetAddress().toString()+":"+connessione.getPort());
			
			in = new ObjectInputStream(connessione.getInputStream());
			out = new ObjectOutputStream(connessione.getOutputStream());
			this.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void run() { 
		
		try { 
			
			while(!getEndQuiz()) {
				Object o = null;
				
				semaforo = server.getSemaforo();
				//INVIO DOMANDE
				semaforo.acquire();
				quiz.run();
				semaforo.release();
				
				o = quiz.getDomande();
				if(!((ArrayList<String>) o).isEmpty()) {
					out.writeObject(o);
					out.flush();
				}else {
					out.writeObject("STOP");
					out.flush();
					setEndQuiz(true);
					break;
				}
				
				//RICEZIONE RISPOSTA
				String s = "";
				o = in.readObject();
				s = (String) o;
				
				//CONTROLLO RISPOSTA
				int punteggi = 0;
				if(s.compareTo("") != 0) {
					if(cd.controlloRisposte(s)) {
						punteggi += 3;
					}
				}
				
				//INVIO PUNTEGGI
				o = (Object) punteggi;				
				out.writeObject(o);
				out.flush();
				
				this.index++;
				quiz.setIndex(index);
			}
			Thread.sleep(5000);
			
			connessione.close(); 
			
		} catch (IOException | ClassNotFoundException | InterruptedException e) { e.printStackTrace(); } 
	} 
	
	public void setQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		this.quiz = quiz;
	}
	
	public ControlloDomande getCd() {
		return cd;
	}

	public void setCd(ControlloDomande cd) {
		this.cd = cd;
	}

	public void setEndQuiz(boolean flag) {
		this.endQuiz = flag;
	}
	
	public boolean getEndQuiz() {
		return this.endQuiz;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
