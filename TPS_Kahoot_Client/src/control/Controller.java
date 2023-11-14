package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import model.*;
import view.*;

public class Controller implements ActionListener{
	
	private Client_GUI finestra;
	
	private String IP;
<<<<<<< Updated upstream
	private String risposta;
	public Controller(Client_GUI finestra) {
=======
	private Risposta risposta;
	private Client client;
	private Punteggi punteggi;
	private Timer timer1;
	private Timer timer2;

	private Controller controller;
	
	public Controller(Client_GUI finestra, Punteggi p) {
		controller = this;
>>>>>>> Stashed changes
		this.finestra = finestra;
		this.punteggi = p;
		
		finestra.registraEventi(this);
	}
	
	ActionListener rispostaVuota = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	timer1.stop();
        	risposta = new Risposta("");
			client.setRisposta(risposta.getRisposta());
			client.conversazione();
        }
    };
    
    ActionListener fineDomanda = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	timer2.stop();
        	finestra.getQuiz().setVisible(false);
			finestra.setPannelli(controller);
			finestra.getQuiz().setVisible(true);
			timer1.start();
			timer2.start();
        }
    };

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == finestra.getbtnConnetti()) {
			IP = finestra.getIP();
			
			client = new Client(IP, finestra);
			client.setPunteggi(punteggi);
			finestra.setActionListener(controller);
			finestra.getConnessione().setVisible(false);
			finestra.getQuiz().setVisible(true);
			finestra.setPannelli(this);
			
			timer1 = new Timer(5000, rispostaVuota);
			timer1.start();
			
			timer2 = new Timer(8000, fineDomanda);
			timer2.start();
		}

        
        
		if(e.getSource() == finestra.getBottone1()) {
<<<<<<< Updated upstream
			risposta=finestra.getQuiz().getBottone1().getActionCommand();
		}else if(e.getSource() == finestra.getBottone2()) {
			risposta=finestra.getQuiz().getBottone2().getActionCommand();
		}else if(e.getSource() == finestra.getBottone3()) {
			risposta=finestra.getQuiz().getBottone3().getActionCommand();
		}else if(e.getSource() == finestra.getBottone4()) {
			risposta=finestra.getQuiz().getBottone4().getActionCommand();
		}
	}

}

/*package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class Controller implements ActionListener{
	
	private Client_GUI finestra;
	
	private String IP;
	
	public Controller(Client_GUI finestra) {
		this.finestra = finestra;
		
		finestra.registraEventi(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == finestra.getbtnConnetti()) {
=======
>>>>>>> Stashed changes
			
			timer1.stop();
			risposta = new Risposta(e.getActionCommand());
			client.setRisposta(risposta.getRisposta());
			client.conversazione();
			
		}
		if(e.getSource() == finestra.getBottone2()) {
					
			timer1.stop();
			risposta = new Risposta(e.getActionCommand());
			client.setRisposta(risposta.getRisposta());
			client.conversazione();
			
		}
		if(e.getSource() == finestra.getBottone3()) {
			
			timer1.stop();
			risposta = new Risposta(e.getActionCommand());
			client.setRisposta(risposta.getRisposta());
			client.conversazione();
			
		}
		if(e.getSource() == finestra.getBottone4()) {
			
			timer1.stop();
			risposta = new Risposta(e.getActionCommand());
			client.setRisposta(risposta.getRisposta());
			client.conversazione();
			
		}
	}

}