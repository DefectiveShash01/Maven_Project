package com.athenahealth.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class NewRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewRecord() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reg=new String(request.getParameter("RegNo").toString());
		String name=new String(request.getParameter("Name").toString());
		String marks=new String(request.getParameter("Marks").toString());
		ArrayList<String> sa= new ArrayList<String>();
		sa.add(reg);
		sa.add(name);
		sa.add(marks);
		MethodsOfApp a = new MethodsOfApp();
		a.load();
		a.addStudent(sa);
		
		String s="<table>\n<tr><th>RegNo.</th><th>Name</th><th>Marks</th></tr>\n";
		ArrayList<ArrayList<String>> rec = a.record();
		for(int i=0;i<rec.size();i++) {
			s=s+"<tr>";
			for(int j =0;j<rec.get(i).size();j++) {
			s=s+"<td>"+rec.get(i).get(j)+"</td>";	
			}
			s=s+"</tr>\n";
		}
		s=s+"</table>";
		request.setAttribute("data", s);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/Record.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
