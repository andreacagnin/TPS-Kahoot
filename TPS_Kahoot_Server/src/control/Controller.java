package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import model.*;
import view.Server_GUI;

public class Controller implements ActionListener{
	
	private Server_GUI finestra;
	private Server server;
	private Quiz quiz;
	
	private ArrayList<String> array;

	public Controller(Server_GUI finestra, Quiz quiz) {
		// TODO Auto-generated constructor stub
		this.finestra = finestra;
		this.quiz = quiz;
		
		array = new ArrayList<String>();
		
		finestra.registraEventi(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == finestra.getbtnInit()) {
			
			quiz.setQuiz(finestra.getQuiz());
			server = new Server();
			server.setQuiz(quiz);
			server.inviaQuiz();
			
		}
	}

}
