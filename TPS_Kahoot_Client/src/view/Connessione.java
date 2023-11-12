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

	/**
	 * Create the panel.
	 */
	public Connessione() {
		setBounds(0, 0, 924, 650);
		setBackground(new Color(40, 40, 40));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(true);
		
		textField = new JTextField();
		textField.setBounds(336, 123, 252, 38);
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("INSERIRE L'INDIRIZZO DEL SERVER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(336, 74, 252, 38);
		add(lblNewLabel);
		
		btnConnettiti = new JButton("CONNETTITI");
		btnConnettiti.setFocusTraversalKeysEnabled(false);
		btnConnettiti.setVerifyInputWhenFocusTarget(false);
		btnConnettiti.setRolloverEnabled(false);
		btnConnettiti.setRequestFocusEnabled(false);
		btnConnettiti.setDefaultCapable(false);
		btnConnettiti.setFocusable(false);
		btnConnettiti.setFocusPainted(false);
		btnConnettiti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConnettiti.setBackground(new Color(255, 255, 255));
		btnConnettiti.setBounds(336, 302, 252, 38);
		add(btnConnettiti);
		
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
