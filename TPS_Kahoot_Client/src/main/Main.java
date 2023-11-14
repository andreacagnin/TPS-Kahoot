package main;

import java.awt.EventQueue;

import control.Controller;
import model.*;
import view.Client_GUI;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Client client = new Client();
					
					//FRAME
					Client_GUI frame = new Client_GUI();
					
					//MODEL
					Punteggi p = new Punteggi();
					
					//CONTROLLER
					new Controller(frame, p);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
