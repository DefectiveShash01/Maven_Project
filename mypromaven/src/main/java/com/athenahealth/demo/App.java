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
        Methodsofapp a=new Methodsofapp();
        a.load();
        String menu= "Welcome!\nEnter an option:\n"
        		+ "1. Print the Record\n"
        		+ "2. Find Name in Record\n"
        		+ "3. Find Registration Number in Record\n"
        		+ "4. Results for Student\n"
        		+ "5. Sort\n"
        		+ "6. Add Student";
        System.out.println(menu);
        int n=s.nextInt();
        switch (n) {
        	case 1: a.record();
        		break;
        	case 2:System.out.println("Enter a String : ");
        	s.nextLine();
            	String ab=s.nextLine();
            	a.nameRecord(ab);
            	break;
        	case 3:System.out.println("Enter reg number : ");
            	String b=s.next();
            	a.regRecord(b);
            	break;
        	case 4:a.checkMarks();
        		break;
        	case 5:System.out.println("Enter 1 for RegNo, 2 for Name, 3 for Marks\n");
        		int ch=s.nextInt();
        		a.sort(ch);
        		break;
        	case 6:String [] s1 =new String[3];
        		System.out.println("Enter RegNo, Name and Marks in Order/n");
        		s.nextLine();
        		s1[0]=s.nextLine();
		    	s1[1]=s.nextLine();
		    	s1[2]=s.nextLine();
		    	a.addStudent(s1);
		    	System.out.println("Record Sucessfully Added/n");
		    	break;
        	default:System.out.println("Wrong Choice entered");
        		break;
        }
        s.close();
        logs.info("End");
    }
}
