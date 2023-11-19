package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.*;
import view.*;

public class Controller implements ActionListener{
	
	private Client_GUI finestra;
	
	private String IP;
	private Client client;
	private Punteggi punteggi;
	private Timer timer1;
	private Timer timer2;

	private Controller controller;
	
	public Controller(Client_GUI finestra, Punteggi p) {
		controller = this;
		this.finestra = finestra;
		this.punteggi = p;
		
		finestra.registraEventi(this);
	}
	
	ActionListener rispostaVuota = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	
        	finestra.getBtn1().setEnabled(false);
			finestra.getBtn2().setEnabled(false);
			finestra.getBtn3().setEnabled(false);
			finestra.getBtn4().setEnabled(false);
			
			client.setRisposta("");
			client.invioRisposta();
        }
    };
    
    ActionListener fineDomanda = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	timer1.stop();
        	timer2.stop();
        	client.conversazione();
			
			if(!client.isFlag()) {
				timer1.start();
				timer2.start();
			}
        }
    };

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == finestra.getbtnConnetti()) {
			
			IP = finestra.getIP();
			client = new Client(IP, finestra, this, punteggi);
			finestra.setActionListener(controller);
			client.conversazione();
		}
		if(e.getSource() == finestra.getBottone1()) {
			
			timer1.stop();
			client.setRisposta(finestra.getQuiz().getBottone1().getActionCommand());

			finestra.getBtn1().setEnabled(false);
			finestra.getBtn2().setEnabled(false);
			finestra.getBtn3().setEnabled(false);
			finestra.getBtn4().setEnabled(false);
			
			client.invioRisposta();
			
		}else if(e.getSource() == finestra.getBottone2()) {
			
			timer1.stop();
			client.setRisposta(finestra.getQuiz().getBottone2().getActionCommand());

			finestra.getBtn1().setEnabled(false);
			finestra.getBtn2().setEnabled(false);
			finestra.getBtn3().setEnabled(false);
			finestra.getBtn4().setEnabled(false);
			
			client.invioRisposta();
			
		}else if(e.getSource() == finestra.getBottone3()) {
			
			timer1.stop();
			client.setRisposta(finestra.getQuiz().getBottone3().getActionCommand());

			finestra.getBtn1().setEnabled(false);
			finestra.getBtn2().setEnabled(false);
			finestra.getBtn3().setEnabled(false);
			finestra.getBtn4().setEnabled(false);
			
			client.invioRisposta();
			
		}else if(e.getSource() == finestra.getBottone4()) {
			
			timer1.stop();
			client.setRisposta(finestra.getQuiz().getBottone4().getActionCommand());

			finestra.getBtn1().setEnabled(false);
			finestra.getBtn2().setEnabled(false);
			finestra.getBtn3().setEnabled(false);
			finestra.getBtn4().setEnabled(false);
			
			client.invioRisposta();
			
		}
	}
	
	public void set() {
		
		finestra.getConnessione().setVisible(false);
		finestra.getQuiz().setVisible(true);
		finestra.setPannelli(this);
		
		finestra.getBtn1().setEnabled(true);
		finestra.getBtn2().setEnabled(true);
		finestra.getBtn3().setEnabled(true);
		finestra.getBtn4().setEnabled(true);
		
		timer1 = new Timer(5000, rispostaVuota);
		timer1.start();
		
		timer2 = new Timer(8000, fineDomanda);
		timer2.start();
	}
	public void set1(int punteggi) {
		finestra.getQuiz().setVisible(false);
		
		finestra.getSp().setVisible(true);
		finestra.setPunteggi(punteggi);
	}
	public void setPannelli(String s) {
		// TODO Auto-generated method stub
		finestra.setBtn(s);
	}

}