package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ControlloDomande {
	
	private Map<String, String> controlloDomande;
	
	public InputStream input;
	private File file;
	private String filepath;
	
	public ControlloDomande() {
		controlloDomande = new HashMap<String, String>();
	}
	
	private void aggiungi() {
		try {
			
	        input = new FileInputStream(file);
			
	        String temp = "";
			String value = "";
			int c;
			int i = 0;
			
	        while((c = input.read()) != -1) {
	        	
	          char character = (char) c;
	          
	          if(character == ',') {
	        	  
	        	  c = input.read();
	        	  character = (char) c;
	        	  value += character;
	        	  
	        	  temp = temp.replaceAll("\r\n", "");
	        	  
			      if(i != 0) {
			    	  this.controlloDomande.put(temp, value);
			      }else
			    	  i++;
			      
			      temp = "";
			      value = "";
	        	  
	          }else if(character == '!'){
	        	  
	        	  i = 0;
	        	  c = input.read();
	        	  character = (char) c;
	        	  
	          }else {
	        	  
	        	  temp += character;
	        	  
	          }
	          
	        }
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setControlloDomande(controlloDomande);
	}
	
	public boolean controlloRisposte(String risposta) {
		if((controlloDomande.get(risposta)).equals("1"))
			return true;
		else
			return false;
		
	}
	
	public void setCd(String nomeFile) {
		this.filepath = "src/quiz/" + nomeFile + ".txt";
		file = new File(filepath);
		aggiungi();
	}
	
	public String getFilepath() {
		return this.filepath;
	}

	public void setControlloDomande(Map<String, String> controlloDomande) {
		// TODO Auto-generated method stub
		this.controlloDomande = controlloDomande;
	}

	public Map<String, String> getControlloDomande() {
		return controlloDomande;
	}
}
