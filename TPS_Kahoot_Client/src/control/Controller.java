package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class Controller implements ActionListener{
	
	private Client_GUI finestra;
	
	private String IP;
	private String risposta;
	public Controller(Client_GUI finestra) {
		this.finestra = finestra;
		
		finestra.registraEventi(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == finestra.getbtnConnetti()) {
			IP = finestra.getIP();
			
			new Client(IP, finestra);
			finestra.getConnessione().setVisible(false);
			finestra.getQuiz().setVisible(true);
			finestra.setPannelli(this);
			
		}
		if(e.getSource() == finestra.getBottone1()) {
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
			
			IP = finestra.getIP();
			
			Client client = new Client(IP);
			finestra.getConnessione().setVisible(false);
			finestra.getQuiz().setVisible(true);
			client.conversazione();
		}
	}

}
*/