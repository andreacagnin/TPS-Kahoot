package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz {
	
	private File quiz;
	private String filepath;
	private Map<String, String> controlloDomande;
	private ArrayList<String> domande;
	private boolean flag;
	
	public InputStream input;

	public Quiz() {
		this.quiz = null;
		this.flag = false;
	}
	
	public void setQuiz(String nomeFile) {
		this.filepath = "src/quiz/" + nomeFile + ".txt";
		quiz = new File(filepath);
		this.flag = true;
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public ArrayList<String> invioDomanda(int index) {
		
		domande = new ArrayList<String>();
		controlloDomande = new HashMap<String, String>();
		
		try {
			
	        input = new FileInputStream(quiz);
	        boolean flag = false;
	        
	        if(index != 0) {
	        	
	        	while(index > 0) {
	        		
	        		int c = 0;
		        	while((c = input.read()) != -1) {
		        		
		        		char character = (char) c;
		        		
		        		if(character == '!')
		        			break;
		        		
		        	}
		        	
		        	index--;
	        		
	        	}
	        	
	        }
			
			while(!flag) {
					
				String temp = "";
				String value = "";
				int c;
				
		        while((c = input.read()) != -1) {
		        	
		          char character = (char) c;
		          
		          if(character == ',') {
		        	  
		        	  c = input.read();
		        	  character = (char) c;
		        	  value += character;
		        	  
		        	  temp = temp.replaceAll("\r\n", "");
		        	  
		        	  domande.add(temp);
				      this.controlloDomande.put(temp, value);
				      
				      temp = "";
				      value = "";
		        	  
		          }else if(character == '!'){
		        	  
		        	  flag = true;
		        	  if((c = input.read()) != -1)
		        		  setFlag(true);
		        	  break;
		        	  
		          }else {
		        	  
		        	  temp += character;
		        	  
		          }
		          
		        }
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(domande);
		
		return domande;
		
	}
	

	public boolean controlloRisposte(String risposta) {
		
		if((controlloDomande.get(risposta)).equals("1"))
			return true;
		else
			return false;
		
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean getFlag() {
		// TODO Auto-generated method stub
		return this.flag;
	}

	public Map<String, String> getControlloDomande() {
		return controlloDomande;
	}

	public void setControlloDomande(Map<String, String> controlloDomande) {
		this.controlloDomande = controlloDomande;
	}

}
