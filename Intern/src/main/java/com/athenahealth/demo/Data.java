package com.athenahealth.demo;
import java.io.IOException;
import java.util.List;


public class Data  {
	public int RegNo=0;
	public String name="";
	public double marks=0.0;
	
	public Data(List<String> ab){
		this.RegNo=(int)(Double.parseDouble(ab.get(0)));
		this.name=ab.get(1);
		this.marks=Double.parseDouble(ab.get(2));
	}
	/*public void display(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<tr>\n<td>"+String.valueOf(this.RegNo)+"</td>/n<td>"+this.name+"</td>/n<td>"+String.valueOf(this.marks)+"</td>/n</tr>");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<tr>\n<td>"+String.valueOf(this.RegNo)+"</td>/n<td>"+this.name+"</td>/n<td>"+String.valueOf(this.marks)+"</td>/n</tr>");
	}*/
}
