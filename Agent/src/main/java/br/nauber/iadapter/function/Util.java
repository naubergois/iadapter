package br.nauber.iadapter.function;

import java.io.FileWriter;
import java.io.IOException;

public class Util {
	
	
	public void writeScriptResults(String s){
		try
		{
		    String filename= "Script.csv";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(s+"\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	public void writeServerResults(String s){
		try
		{
		    String filename= "Server.csv";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(s+"\n");//appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}

}
