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
					
					//CONTROLLER
					new Controller(frame);
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
