package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StampaPunteggio extends JPanel {

	private static final long serialVersionUID = 1L;

	
	private JLabel lblPunteggioTotalizzatoNum;
	
	/**
	 * Create the panel.
	 */
	public StampaPunteggio() {
		setBounds(0, 0, 924, 650);
		setBackground(new Color(32, 178, 170));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblTitolo = new JLabel("EnigMente");
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setForeground(Color.WHITE);
		lblTitolo.setFont(new Font("Impact", Font.BOLD, 79));
		lblTitolo.setBounds(10, 52, 904, 94);
		add(lblTitolo);
		
		JLabel lblPunteggioTotalizzato = new JLabel("PUNTEGGIO TOTALIZZATO");
		lblPunteggioTotalizzato.setHorizontalAlignment(SwingConstants.CENTER);
		lblPunteggioTotalizzato.setForeground(Color.WHITE);
		lblPunteggioTotalizzato.setFont(new Font("Ink Free", Font.PLAIN, 39));
		lblPunteggioTotalizzato.setBounds(10, 258, 904, 74);
		add(lblPunteggioTotalizzato);
		
		lblPunteggioTotalizzatoNum = new JLabel("0");
		lblPunteggioTotalizzatoNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPunteggioTotalizzatoNum.setForeground(Color.WHITE);
		lblPunteggioTotalizzatoNum.setFont(new Font("Ink Free", Font.PLAIN, 97));
		lblPunteggioTotalizzatoNum.setBounds(10, 376, 904, 138);
		add(lblPunteggioTotalizzatoNum);
		setVisible(false);
	}

	public JLabel getLblPunteggioTotalizzatoNum() {
		return lblPunteggioTotalizzatoNum;
	}

	public void setLblPunteggioTotalizzatoNum(JLabel lblPunteggioTotalizzatoNum) {
		this.lblPunteggioTotalizzatoNum = lblPunteggioTotalizzatoNum;
	}
}
