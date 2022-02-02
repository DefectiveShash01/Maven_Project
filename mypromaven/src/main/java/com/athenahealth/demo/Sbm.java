package com.athenahealth.demo;

import java.util.Comparator;

public class Sbm implements Comparator<Data>{
	
		public int compare(Data a, Data b)
	    {
	        return (int)(a.marks-b.marks);
	    }
	
}
