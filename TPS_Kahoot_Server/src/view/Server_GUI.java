package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;

public class Server_GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 494720585099566505L;
	
	private JPanel contentPane;
	private Select select;
	private JLabel lblTitolo;
	private JLabel lblSottotitolo;
	private JButton btnAvvioDelServer;

	/**
	 * Create the frame.
	 */
	public Server_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		select = new Select();
		select.setRequestFocusEnabled(false);
		select.setVerifyInputWhenFocusTarget(false);
		select.setDoubleBuffered(false);
		select.setFocusTraversalKeysEnabled(false);
		select.setFocusable(false);
		select.setBackground(new Color(255, 255, 255));
		select.setBounds(285, 200, 354, 22);
		contentPane.add(select);
		
		lblTitolo = new JLabel("Quizzone");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitolo.setForeground(new Color(255, 255, 255));
		lblTitolo.setBounds(285, 29, 354, 73);
		contentPane.add(lblTitolo);
		
		lblSottotitolo = new JLabel("- Scegli il quiz -");
		lblSottotitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSottotitolo.setForeground(Color.WHITE);
		lblSottotitolo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSottotitolo.setBounds(285, 116, 354, 73);
		contentPane.add(lblSottotitolo);
		
		btnAvvioDelServer = new JButton("Inizia il quiz");
		btnAvvioDelServer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAvvioDelServer.setVerifyInputWhenFocusTarget(false);
		btnAvvioDelServer.setRolloverEnabled(false);
		btnAvvioDelServer.setRequestFocusEnabled(false);
		btnAvvioDelServer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAvvioDelServer.setFocusable(false);
		btnAvvioDelServer.setFocusPainted(false);
		btnAvvioDelServer.setDefaultCapable(false);
		btnAvvioDelServer.setBorderPainted(false);
		btnAvvioDelServer.setBackground(Color.WHITE);
		btnAvvioDelServer.setBounds(371, 405, 182, 47);
		contentPane.add(btnAvvioDelServer);
	}
	
	public JButton getbtnAvvio() {
		// TODO Auto-generated method stub
		return btnAvvioDelServer;
	}

	public void registraEventi(Controller controller) {
		// TODO Auto-generated method stub
		btnAvvioDelServer.addActionListener(controller);
	}

	public String getQuiz() {
		// TODO Auto-generated method stub
		return select.getTitoloQuiz();
	}
}
