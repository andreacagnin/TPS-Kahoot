package main;

import java.awt.EventQueue;

import control.Controller;
import model.*;
import view.*;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//FINESTRA
					Server_GUI frame = new Server_GUI();
					
					//MODEL
					Quiz quiz = new Quiz();
					ControlloDomande cd = new ControlloDomande();
					Server server = new Server();
					
					//CONTROLLER
					new Controller(frame, quiz, cd, server);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
