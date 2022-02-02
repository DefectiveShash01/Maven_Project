package com.athenahealth.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Homepage() {
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	RequestDispatcher view = request.getRequestDispatcher("WEB-INF/index.jsp");
		view.forward(request, response);
    	
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request,response);
	}
}
