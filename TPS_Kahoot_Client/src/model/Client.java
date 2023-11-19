package model;

import java.io.*;
import java.net.Socket;

import control.Controller;
import view.Client_GUI;

public class Client {
	
    private Socket connection;
    
    private ObjectInputStream in;
	private ObjectOutputStream out;
	private Object receivedArray;
	
	private Client_GUI finestra;
	private Controller controller;
	private Domande domande;
	private Punteggi punteggi;
	
	private String risposta;
	private boolean flag;
	
	public Client(String indirizzo, Client_GUI finestra, Controller controller, Punteggi punteggi) { 
		
		this.finestra = finestra;
		this.controller = controller;
		this.punteggi = punteggi;
		this.flag = false;
		
		boolean connesso = false;
		
		while(!connesso) {
			try {
				connection = new Socket(indirizzo, 20000);
				connesso = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		try { 
			
			out = new ObjectOutputStream(connection.getOutputStream());
			in = new ObjectInputStream(connection.getInputStream());
            
		} catch (IOException e) { 
			
			e.printStackTrace(); 
		} 
	}
	
	public void conversazione() {
		// TODO Auto-generated method stub
		try {
			
			//RICEZIONE DOMANDE
			receivedArray = in.readObject();
			if(receivedArray.equals("STOP")) {
				controller.set1( this.punteggi.getPunteggi());
				connection.close();
				setFlag(true);
			}else {
				domande = new Domande(receivedArray);
				
				finestra.setDomande(domande);
				controller.set();
			}
            
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void invioRisposta() {
		
		try {
			
			//INVIO RISPOSTA
			Object o = (Object) this.risposta;
			out.writeObject(o);
			
			//RICEZIONE PUNTEGGIO
			int punteggi = 0;
			punteggi = (int) in.readObject();
			this.punteggi.setPunteggi(punteggi);
			
			//RICEZIONE RISPOSTA CORRETTA
			String s =  "";
			s = (String) in.readObject();
			controller.setPannelli(s);
            
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
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
 
}