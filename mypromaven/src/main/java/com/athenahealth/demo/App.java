package com.athenahealth.demo;

import java.io.*;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
	public static final String SAMPLE_XLSX_FILE_PATH = "C:/Users/saryan/Documents/Book1.xlsx";
	public static final Logger logs=LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws IOException
    {	
    	logs.info("Starting");
    	Scanner s = new Scanner(System.in);
    	//LinkedList <String> a = new LinkedList<String>();
        Methodsofapp a=new Methodsofapp();
        a.load();
        //a.record();	
        //System.out.println("Enter a String");
        //String ab=s.nextLine();
        //a.nameRecord(ab);
        //System.out.println("Enter reg number");
        
       // String b=s.nextLine();
        //a.regRecord(b);
        //a.checkMarks();
        //workbook.close();
        //String [] s1 =new String[3];
        //s1[0]=s.nextLine();
        //s1[1]=s.nextLine();
        //s1[2]=s.nextLine();
        //a.addStudent(s1);
        a.sort("2");
        s.close();
        logs.info("End");
    }
}
