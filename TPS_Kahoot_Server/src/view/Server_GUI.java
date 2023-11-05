package view;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;

public class Server_GUI extends JFrame {

	private JPanel contentPane;
	private Select select;
	private JLabel lblTitolo;
	private JLabel lblSottotitolo;
	private JButton btnNewButton;

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
		
		btnNewButton = new JButton("Inizia il quiz");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setDefaultCapable(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setVerifyInputWhenFocusTarget(false);
		btnNewButton.setRolloverEnabled(false);
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(371, 378, 182, 47);
		contentPane.add(btnNewButton);
	}
}
