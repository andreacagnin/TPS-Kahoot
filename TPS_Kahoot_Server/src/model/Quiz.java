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
	private boolean flag;
	
	public InputStream input;

	public Quiz() {
		this.quiz = null;
		this.flag = false;
		controlloDomande = new HashMap<String, String>();
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
		
		ArrayList<String> domande = new ArrayList<String>();
		
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
		
		return domande;
		
	}

	public boolean getFlag() {
		// TODO Auto-generated method stub
		return this.flag;
	}

}
