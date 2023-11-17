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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
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
		select.setBounds(285, 323, 354, 22);
		contentPane.add(select);
		
		lblTitolo = new JLabel("EnigMente");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setFont(new Font("Impact", Font.BOLD, 79));
		lblTitolo.setForeground(new Color(255, 255, 255));
		lblTitolo.setBounds(10, 40, 888, 94);
		contentPane.add(lblTitolo);
		
		lblSottotitolo = new JLabel("- Scegli il quiz -");
		lblSottotitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSottotitolo.setForeground(Color.WHITE);
		lblSottotitolo.setFont(new Font("Ink Free", Font.BOLD, 28));
		lblSottotitolo.setBounds(285, 239, 354, 73);
		contentPane.add(lblSottotitolo);
		
		btnAvvioDelServer = new JButton("Inizia il quiz");
		btnAvvioDelServer.setForeground(new Color(135, 206, 235));
		btnAvvioDelServer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAvvioDelServer.setVerifyInputWhenFocusTarget(false);
		btnAvvioDelServer.setRolloverEnabled(false);
		btnAvvioDelServer.setRequestFocusEnabled(false);
		btnAvvioDelServer.setFont(new Font("Impact", Font.PLAIN, 35));
		btnAvvioDelServer.setFocusable(false);
		btnAvvioDelServer.setFocusPainted(false);
		btnAvvioDelServer.setDefaultCapable(false);
		btnAvvioDelServer.setBorderPainted(false);
		btnAvvioDelServer.setBackground(new Color(147, 112, 219));
		btnAvvioDelServer.setBounds(285, 460, 354, 87);
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
