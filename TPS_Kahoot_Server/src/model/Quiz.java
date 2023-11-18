package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Quiz implements Runnable{
	
	private File quiz;
	private String filepath;
	private ArrayList<String> domande;
	
	private boolean flag;
	private int index;
	
	public InputStream input;

	public Quiz() {
		this.index = 0;
		this.quiz = null;
		this.flag = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		domande = new ArrayList<String>();
		
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
				int c;
				
		        while((c = input.read()) != -1) {
		        	
		          char character = (char) c;
		          
		          if(character == ';') {
		        	  
		        	  c = input.read();
		        	  
		        	  temp = temp.replaceAll("\r\n", "");
		        	  
		        	  domande.add(temp);
				      
				      temp = "";
		        	  
		          }else if(character == '!'){
		        	  
		        	  flag = true;
		        	  c = input.read();
		        	  character = (char) c;
		        	  if(character == '!') {
		        		  setFlag(true);
		        	  }
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

		setDomande(domande);
	}
	
	public void setQuiz(String nomeFile) {
		this.filepath = "src/quiz/" + nomeFile + ".txt";
		quiz = new File(filepath);
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean getFlag() {
		// TODO Auto-generated method stub
		return this.flag;
	}
	
	public ArrayList<String> getDomande() {
		return domande;
	}

	public void setDomande(ArrayList<String> domande) {
		this.domande = domande;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getRisposta(int i) {
		// TODO Auto-generated method stub
		return domande.get(i);
	}

}
