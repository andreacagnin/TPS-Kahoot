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
		if(e.getSource() == finestra.getbtnAvvio()) {
			
			server = new Server();
			
		}
		if(e.getSource() == finestra.getbtnInit()) {
			
			quiz.setQuiz(finestra.getQuiz());
			server.setQuiz(quiz);
			server.inviaQuiz(0);
			
		}
	}

}
/*package control;

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
		if(e.getSource() == finestra.getbtnAvvio()) {
			//avvio del server
			quiz.setQuiz(finestra.getQuiz());
			server = new Server(quiz);
			
		}
		if(e.getSource() == finestra.getbtnInit()) {
			//invio del quiz
			

		}
	}

}*/
