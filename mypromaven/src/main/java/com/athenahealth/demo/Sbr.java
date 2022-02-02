package com.athenahealth.demo;

import java.util.Comparator;

public class Sbr implements Comparator<Data>{
	public int compare(Data a, Data b)
    {
        return a.RegNo-b.RegNo;
    }
}
