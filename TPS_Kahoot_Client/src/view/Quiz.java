package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.Controller;

public class Quiz extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton bottone1;
	private JButton bottone2;
	private JButton bottone3;
	private JButton bottone4;
	private JLabel lblDomanda;
	
	public Quiz() {
		setBounds(0, 0, 924, 650);
		setBackground(new Color(40, 40, 40));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		setVisible(false);
		
		bottone1 = new JButton("Risposta 1");
		bottone1.setActionCommand("");
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
		add(bottone1);
		
		bottone2 = new JButton("Risposta 2");
		bottone2.setActionCommand("");
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
		add(bottone2);
		
		bottone3 = new JButton("Risposta 3");
		bottone3.setActionCommand("");
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
		add(bottone3);
		
		bottone4 = new JButton("Risposta 4");
		bottone4.setActionCommand("");
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
		add(bottone4);
		
		lblDomanda = new JLabel("Domanda");
		lblDomanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomanda.setForeground(new Color(255, 255, 255));
		lblDomanda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDomanda.setBounds(252, 46, 420, 41);
		add(lblDomanda);
		
	}

	public void registraEventi(Controller controller) {
		// TODO Auto-generated method stub
		bottone1.addActionListener(controller);
		bottone2.addActionListener(controller);
		bottone3.addActionListener(controller);
		bottone4.addActionListener(controller);
	}

	public JButton getBottone1() {
		return bottone1;
	}

	public void setBottone1(JButton bottone1) {
		this.bottone1 = bottone1;
	}

	public JButton getBottone2() {
		return bottone2;
	}

	public void setBottone2(JButton bottone2) {
		this.bottone2 = bottone2;
	}

	public JButton getBottone3() {
		return bottone3;
	}

	public void setBottone3(JButton bottone3) {
		this.bottone3 = bottone3;
	}

	public JButton getBottone4() {
		return bottone4;
	}

	public void setBottone4(JButton bottone4) {
		this.bottone4 = bottone4;
	}

	public JLabel getLblDomanda() {
		return lblDomanda;
	}

	public void setLblDomanda(JLabel lblDomanda) {
		this.lblDomanda = lblDomanda;
	}
	
	

}
