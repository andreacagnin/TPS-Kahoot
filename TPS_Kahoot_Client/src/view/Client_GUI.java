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
	private StampaPunteggio sp;
	private Connessione connessione;
	private Domande domande;

	/**
	 * Create the frame.
	 */
	public Client_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 924, 650);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		connessione = new Connessione();
		connessione.setBackground(new Color(30, 144, 255));
		connessione.setVisible(true);
		connessione.setLocation(0, 0);
		contentPane.add(connessione);
		
		quiz = new Quiz();
		quiz.setLocation(0, 0);
		contentPane.add(quiz);
		
		sp = new StampaPunteggio();
		sp.setLocation(0, 0);
		contentPane.add(sp);
		
	}

	public void registraEventi(Controller controller) {
		// TODO Auto-generated method stub
		connessione.registraEventi(controller);
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
	

	public StampaPunteggio getSp() {
		return sp;
	}

	public void setSp(StampaPunteggio sp) {
		this.sp = sp;
	}

	public Domande getDomande() {
		return domande;
	}

	public void setDomande(Domande domande) {
		this.domande = domande;
	}

	public void setPannelli(Controller controller) {
		// TODO Auto-generated method stub
		quiz.getLblDomanda().setText(domande.getDomande().get(0));
		quiz.getBottone1().setText(domande.getDomande().get(1));
		quiz.getBottone2().setText(domande.getDomande().get(2));
		quiz.getBottone3().setText(domande.getDomande().get(3));
		quiz.getBottone4().setText(domande.getDomande().get(4));
		
		quiz.getBottone1().setActionCommand(quiz.getBottone1().getText());
		quiz.getBottone2().setActionCommand(quiz.getBottone2().getText());
		quiz.getBottone3().setActionCommand(quiz.getBottone3().getText());
		quiz.getBottone4().setActionCommand(quiz.getBottone4().getText());
		
		quiz.getBtn1().setBackground(new Color(51, 204, 102));
		quiz.getBtn2().setBackground(new Color(51, 0, 255));
		quiz.getBtn3().setBackground(new Color(255, 204, 102));
		quiz.getBtn4().setBackground(new Color(255, 102, 102));
		
	}
	public void setPunteggi(int punteggi) {
		sp.getLblPunteggioTotalizzatoNum().setText(String.valueOf(punteggi));
	}
	
	
	public JButton getBtn1() {
		// TODO Auto-generated method stub
		return quiz.getBottone1();
	}
	
	public JButton getBtn2() {
		// TODO Auto-generated method stub
		return quiz.getBottone2();
	}
	
	public JButton getBtn3() {
		// TODO Auto-generated method stub
		return quiz.getBottone3();
	}
	
	public JButton getBtn4() {
		// TODO Auto-generated method stub
		return quiz.getBottone4();
	}

	public Object getBottone1() {
		// TODO Auto-generated method stub
		return quiz.getBottone1();
	}
	
	public Object getBottone2() {
		// TODO Auto-generated method stub
		return quiz.getBottone2();
	}
	
	public Object getBottone3() {
		// TODO Auto-generated method stub
		return quiz.getBottone3();
	}
	
	public Object getBottone4() {
		// TODO Auto-generated method stub
		return quiz.getBottone4();
	}

	public void setActionListener(Controller controller) {
		// TODO Auto-generated method stub
		quiz.getBottone1().addActionListener(controller);
		quiz.getBottone2().addActionListener(controller);
		quiz.getBottone3().addActionListener(controller);
		quiz.getBottone4().addActionListener(controller);
	}

	public void setBtn(String s) {
		// TODO Auto-generated method stub
		quiz.getBtn(s);
	}

	
}
