package model;

import java.util.ArrayList;

public class Domande {
	
	private ArrayList<String> domande;
	
	@SuppressWarnings("unchecked")
	public Domande(Object receivedArray) {
		
		domande = new ArrayList<String>();
		domande = (ArrayList<String>) receivedArray;
		
	}

	public ArrayList<String> getDomande() {
		return domande;
	}

}
