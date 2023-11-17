package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;

public class Connessione extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnConnettiti;
	private JLabel lblTitolo;

	/**
	 * Create the panel.
	 */
	public Connessione() {
		setBounds(0, 0, 924, 650);
		setBackground(new Color(30, 144, 255));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		
		textField = new JTextField("");
		textField.setBackground(new Color(0, 255, 255));
		textField.setFont(new Font("Impact", Font.PLAIN, 21));
		textField.setBounds(336, 292, 252, 45);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("INSERIRE L'INDIRIZZO DEL SERVER");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 194, 904, 55);
		add(lblNewLabel);
		
		btnConnettiti = new JButton("VAI CON LE DOMANDE");
		btnConnettiti.setForeground(new Color(106, 90, 205));
		btnConnettiti.setFont(new Font("Impact", Font.PLAIN, 26));
		btnConnettiti.setFocusTraversalKeysEnabled(false);
		btnConnettiti.setVerifyInputWhenFocusTarget(false);
		btnConnettiti.setRolloverEnabled(false);
		btnConnettiti.setRequestFocusEnabled(false);
		btnConnettiti.setDefaultCapable(false);
		btnConnettiti.setFocusable(false);
		btnConnettiti.setFocusPainted(false);
		btnConnettiti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConnettiti.setBackground(new Color(153, 204, 204));
		btnConnettiti.setBounds(336, 471, 252, 62);
		add(btnConnettiti);
		
		lblTitolo = new JLabel("EnigMente");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(Color.WHITE);
		lblTitolo.setFont(new Font("Impact", Font.BOLD, 79));
		lblTitolo.setBounds(10, 33, 904, 94);
		add(lblTitolo);
		
	}

	public Object getbtnConnetti() {
		// TODO Auto-generated method stub
		return btnConnettiti;
	}

	public void registraEventi(Controller controller) {
		// TODO Auto-generated method stub
		btnConnettiti.addActionListener(controller);
	}

	public String getIP() {
		// TODO Auto-generated method stub
		return textField.getText();
	}
}
