package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Client;

import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Client_GUI extends JFrame implements ActionListener{
	public String ipserver;
	private JPanel contentPane;
	public JPanel panelRichiestaClient;
	private JFormattedTextField ipLogin;
	private JButton richiestaBtn;
	private JButton bottone1;
	private JButton bottone2;
	private JButton bottone3;
	private JButton bottone4;
	private JLabel lblDomanda;

	/**
	 * Create the frame.
	 */
	public Client_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 650);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 40, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		panelRichiestaClient = new JPanel();
		panelRichiestaClient.setBackground(new Color(51, 51, 51));
		panelRichiestaClient.setBounds(0, 0, 908, 611);
		contentPane.add(panelRichiestaClient);
		
		ipLogin = new JFormattedTextField();
		ipLogin.setBounds(333, 169, 240, 28);
		ipLogin.setVerifyInputWhenFocusTarget(false);
		ipLogin.setHorizontalAlignment(SwingConstants.CENTER);
		ipLogin.setSelectedTextColor(new Color(0, 0, 0));
		ipLogin.setText("IP SERVER");
		
		
		panelRichiestaClient.setLayout(null);
		
		richiestaBtn = new JButton("New button");
		richiestaBtn.setBounds(333, 306, 240, 39);
		richiestaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		richiestaBtn.setBackground(new Color(0, 0, 102));
		panelRichiestaClient.add(richiestaBtn);
		richiestaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverAddress = ipLogin.getText();
                Client client = new Client();
                client.connectToServer(serverAddress);
                // Add code to do something with the client instance or server connection.
            }
        });
		panelRichiestaClient.add(ipLogin);
		
		bottone1 = new JButton("Risposta 1");
		bottone1.setBackground(new Color(255, 255, 255));
		bottone1.setVerifyInputWhenFocusTarget(false);
		bottone1.setRolloverEnabled(false);
		bottone1.setRequestFocusEnabled(false);
		bottone1.setFocusable(false);
		bottone1.setFocusTraversalKeysEnabled(false);
		bottone1.setFocusPainted(false);
		bottone1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone1.setDefaultCapable(false);
		bottone1.setBorderPainted(false);
		bottone1.setBounds(53, 211, 310, 68);
		contentPane.add(bottone1);
		
		bottone2 = new JButton("Risposta 2");
		bottone2.setBackground(new Color(255, 255, 255));
		bottone2.setVerifyInputWhenFocusTarget(false);
		bottone2.setRolloverEnabled(false);
		bottone2.setRequestFocusEnabled(false);
		bottone2.setFocusable(false);
		bottone2.setFocusTraversalKeysEnabled(false);
		bottone2.setFocusPainted(false);
		bottone2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone2.setDefaultCapable(false);
		bottone2.setBorderPainted(false);
		bottone2.setBounds(53, 359, 310, 68);
		contentPane.add(bottone2);
		
		bottone3 = new JButton("Risposta 3");
		bottone3.setBackground(new Color(255, 255, 255));
		bottone3.setVerifyInputWhenFocusTarget(false);
		bottone3.setRolloverEnabled(false);
		bottone3.setRequestFocusEnabled(false);
		bottone3.setFocusable(false);
		bottone3.setFocusTraversalKeysEnabled(false);
		bottone3.setFocusPainted(false);
		bottone3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone3.setDefaultCapable(false);
		bottone3.setBorderPainted(false);
		bottone3.setBounds(545, 359, 310, 68);
		contentPane.add(bottone3);
		
		bottone4 = new JButton("Risposta 4");
		bottone4.setBackground(new Color(255, 255, 255));
		bottone4.setVerifyInputWhenFocusTarget(false);
		bottone4.setRolloverEnabled(false);
		bottone4.setRequestFocusEnabled(false);
		bottone4.setFocusable(false);
		bottone4.setFocusTraversalKeysEnabled(false);
		bottone4.setFocusPainted(false);
		bottone4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bottone4.setDefaultCapable(false);
		bottone4.setBorderPainted(false);
		bottone4.setBounds(545, 211, 310, 68);
		contentPane.add(bottone4);
		
		lblDomanda = new JLabel("Domanda");
		lblDomanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomanda.setForeground(new Color(255, 255, 255));
		lblDomanda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDomanda.setBounds(252, 46, 420, 41);
		contentPane.add(lblDomanda);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			ipserver = ipLogin.getText();
		
	}
}
