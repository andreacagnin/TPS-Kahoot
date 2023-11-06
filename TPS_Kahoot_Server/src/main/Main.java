package main;

import java.awt.EventQueue;

import control.Controller;
import model.Quiz;
import view.Server_GUI;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//FINESTRA
					Server_GUI frame = new Server_GUI();
					
					//MODEL
					Quiz quiz = new Quiz();
					
					//CONTROLLER
					new Controller(frame, quiz);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
