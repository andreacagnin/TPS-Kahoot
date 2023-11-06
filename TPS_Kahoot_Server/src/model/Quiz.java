package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quiz {
	
	private File quiz;
	private String filepath;
	private ArrayList<String> domande;
	private Map<String, String> controlloDomande;
	
	public InputStream input;

	public Quiz() {
		this.quiz = null;
		controlloDomande = new HashMap<String, String>();
		domande = new ArrayList<String>();
	}
	
	public void setQuiz(String nomeFile) {
		this.filepath = "src/quiz/" + nomeFile + ".txt";
		quiz = new File(filepath);
	}
	
	public String getFilepath() {
		return this.filepath;
	}
	
	public ArrayList<String> invioDomanda() {
		
		try {
			
	        input = new FileInputStream(quiz);
	        boolean flag = false;
			
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
		        	  
		          }else {
		        	  
		        	  temp += character;
		        	  
		          }
		          
		        }
		        
		        if(c == -1)
		        	  flag = true;
		      
		        domande.add(temp);
		        this.controlloDomande.put(temp, value);
		        
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return domande;
		
	}

}
