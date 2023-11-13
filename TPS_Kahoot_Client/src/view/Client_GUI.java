package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import model.Domande;

import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;

public class Client_GUI extends JFrame {

	private JPanel contentPane;
	private Quiz quiz;
	private Connessione connessione;
	private Domande domande;

	/**
	 * Create the frame.
	 */
	public Client_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 924, 650);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		connessione = new Connessione();
		connessione.setVisible(true);
		connessione.setLocation(0, 0);
		contentPane.add(connessione);
		
		quiz = new Quiz();
		quiz.setLocation(0, 0);
		contentPane.add(quiz);
		
		
	}

	public void registraEventi(Controller controller) {
		// TODO Auto-generated method stub
		connessione.registraEventi(controller);
		quiz.registraEventi(controller);
	}
	
	public Object getbtnConnetti() {
		// TODO Auto-generated method stub
		return connessione.getbtnConnetti();
	}

	public String getIP() {
		// TODO Auto-generated method stub
		return connessione.getIP();
	}

	public Connessione getConnessione() {
		// TODO Auto-generated method stub
		return connessione;
	}

	public Quiz getQuiz() {
		// TODO Auto-generated method stub
		return quiz;
	}

	public Domande getDomande() {
		return domande;
	}

	public void setDomande(Domande domande) {
		this.domande = domande;
	}

	public void setPannelli() {
		// TODO Auto-generated method stub
		quiz.getLblDomanda().setText(domande.getDomande().get(0));
		quiz.getBottone1().setText(domande.getDomande().get(1));
		quiz.getBottone2().setText(domande.getDomande().get(2));
		quiz.getBottone3().setText(domande.getDomande().get(3));
		quiz.getBottone4().setText(domande.getDomande().get(4));
	}

	
}
