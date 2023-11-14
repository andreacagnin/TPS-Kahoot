package model;

public class Punteggi {
	
	private int punteggi;
	
	public Punteggi() {
		this.punteggi = 0;
	}
	
	public void setPunteggi(int punteggi) {
		this.punteggi += punteggi;
	}
	
	public int getPunteggi() {
		return this.punteggi;
	}

}
