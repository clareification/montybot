import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Reading {
	
	public static String[] getMonty() throws IOException {
		FileReader fre = new FileReader("C:\\Users\\owner\\Documents\\New folder\\fullmonty.txt");
	      BufferedReader bre = new BufferedReader(fre);
	      Scanner s = new Scanner(bre);
	      String scrip = "";
	      while(s.hasNextLine()){
	    	  String toAdd =s.nextLine();
	    	  scrip+= toAdd;
	    	  scrip+="\n";
	      }

	      
	    //Get rid of stage directions (text enclosed in [])   
	     String noSD = scrip.replaceAll("\\[[^\\]]*\\]", "");
	     noSD = noSD.replaceAll("\\([^()]*\\)", "");

	     
	     String noNames = noSD.replaceAll("[A-Z](.*?)\\:", "");
	     String[] dialogue = noNames.split("\n");
	     ArrayList<String> noGaps = new ArrayList<String>();
	     int counter = 0;

	     for(int i = 0; i<dialogue.length; i++){
	    	 if(dialogue[i].contains("a")){
	    		 counter++;
	    		 noGaps.add(dialogue[i]);
	    	 }	    	 
	     }
	     String[] rDia = new String[noGaps.size()];
	     for(int i = 0; i<noGaps.size(); i++){
	    	 rDia[i] = (String) noGaps.get(i);
	    	
	     }
	    
	     
	     
	     	   
	     return rDia;
	     
	}
	
	
}