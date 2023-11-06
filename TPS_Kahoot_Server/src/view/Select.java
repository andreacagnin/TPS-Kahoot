package view;

import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;

public class Select extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JComboBox comboBox;
	private File quiz;
	private Scanner myReader;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Select() {
		setVerifyInputWhenFocusTarget(false);
		setRequestFocusEnabled(false);
		setFocusable(false);
		setFocusTraversalKeysEnabled(false);
		setDoubleBuffered(false);
		setLayout(null);
		setBounds(0, 0, 354, 22);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(getQuiz()));
		comboBox.setBounds(0, 0, 354, 22);
		add(comboBox);
		
	}
	
	public String[] getQuiz() {
		
		String select[] = new String[getLine()];
		int i = 0;
		
		try {
			
			File quiz = new File("src/quiz/quiz.txt");
			@SuppressWarnings("resource")
			Scanner myReader = new Scanner(quiz);
			
			while(myReader.hasNextLine()) {
				
				String data = myReader.nextLine();
				select[i] = data.replaceAll("_", " ");
				
		        i++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return select;
		
	}

	private int getLine() {
		
		int i = 0;
		
		try {
			
			File quiz = new File("src/quiz/quiz.txt");
			Scanner myReader = new Scanner(quiz);
			
			while(myReader.hasNextLine()) {
				
				String data = myReader.nextLine();
		        i++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public String getTitoloQuiz() {
		// TODO Auto-generated method stub
		String s = (String) comboBox.getSelectedItem();
		
		return s.replaceAll(" ", "_");
	}
}
