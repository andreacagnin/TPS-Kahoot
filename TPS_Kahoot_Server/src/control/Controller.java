package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.*;
import view.Server_GUI;

public class Controller implements ActionListener{
	
	private Server_GUI finestra;
	private Server server;
	private Quiz quiz;
	private ControlloDomande cd;

	public Controller(Server_GUI finestra, Quiz quiz, ControlloDomande cd, Server server) {
		// TODO Auto-generated constructor stub
		this.finestra = finestra;
		this.quiz = quiz;
		this.cd = cd;
		this.server = server;
		
		finestra.registraEventi(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == finestra.getbtnAvvio()) {
			
			quiz.setQuiz(finestra.getQuiz());
			cd.setCd(finestra.getQuiz());
			server.setQuiz(quiz);
			server.setCd(cd);
			server.start();
			
		}
		if(e.getSource() == finestra.getbtnInit()) {
			
			
			//server.setFlag();
			
		}
	}

}
