package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.Server_GUI;

public class Controller implements ActionListener{
	
	private Server_GUI finestra;
	
	private Quiz quiz;

	public Controller(Server_GUI finestra, Quiz quiz) {
		// TODO Auto-generated constructor stub
		this.finestra = finestra;
		this.quiz = quiz;
		
		finestra.registraEventi(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == finestra.getbtnInit()) {
			
			new Server();
			quiz.setQuiz(finestra.getQuiz());
			quiz.invioDomanda();
			
		}
	}

}
