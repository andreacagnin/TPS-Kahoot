package control;

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
			
			new Client(IP);
			finestra.getConnessione().setVisible(false);
			finestra.getQuiz().setVisible(true);
		}
	}

}
