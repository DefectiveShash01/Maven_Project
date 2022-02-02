package com.athenahealth.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindReg() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s="<table>";
		String err="";
		MethodsOfApp a = new MethodsOfApp();
		a.load();
		List<String> rec=new ArrayList<String>();
		String reg = new String(request.getParameter("Reg").toString());
		
		try {
			rec=a.regRecord(reg);
			s=s+"\n<tr><th>RegNo.</th><th>Name</th><th>Marks</th></tr>\n";
			s=s+"<tr>";
			for(int j =0;j<rec.size();j++) {
			s=s+"<td>"+rec.get(j)+"</td>";	
			}
			s=s+"</tr>\n";
			
		} catch (Exception e) {
			request.setAttribute("Err",e.getMessage());
		}
		s=s+"</table>";
		request.setAttribute("data", s);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/FindName.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
