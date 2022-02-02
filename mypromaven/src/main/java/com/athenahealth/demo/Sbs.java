package com.athenahealth.demo;

import java.util.Comparator;

public class Sbs implements Comparator<Data>{
	public int compare(Data a, Data b)
    {
        return a.name.compareTo(b.name);
    }
}
