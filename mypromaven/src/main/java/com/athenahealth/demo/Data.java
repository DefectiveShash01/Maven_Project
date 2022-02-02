package com.athenahealth.demo;

public class Data {
	public int RegNo=0;
	public String name="";
	public double marks=0.0;
	
	public Data(String reg,String n,String m){
		this.RegNo=(int)(Double.parseDouble(reg));
		this.name=n;
		this.marks=Double.parseDouble(m);
	}
	public void display() {
		System.out.print(this.RegNo+"||"+this.name+"||"+this.marks+"||");
	}

}
