package com.athenahealth.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sort extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Sort() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s="<table>\n<tr><th>RegNo.</th><th>Name</th><th>Marks</th></tr>\n";
		MethodsOfApp a = new MethodsOfApp();
		a.load();
		String op="";
		String or="";
		try{
			op= new String(request.getParameter("selection").toString());
		}
		catch(Exception e) {
			op="0";
		}
		try{
			or=new String(request.getParameter("order").toString());
		}
		catch(Exception e) {
			or="a";
		}
		ArrayList<ArrayList<String>> rec = a.sort(op);
		if(or.equals("d")) {
			for(int i=rec.size()-1;i>=0;i--) {
				s=s+"<tr>";
				for(int j =0;j<rec.get(i).size();j++) {
				s=s+"<td>"+rec.get(i).get(j)+"</td>";	
				}
				s=s+"</tr>\n";
			}
		}
		else {
			for(int i=0;i<rec.size();i++) {
				s=s+"<tr>";
				for(int j =0;j<rec.get(i).size();j++) {
				s=s+"<td>"+rec.get(i).get(j)+"</td>";	
				}
				s=s+"</tr>\n";
			}
		}
		s=s+"</table>";
		request.setAttribute("data", s);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/Sort.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
