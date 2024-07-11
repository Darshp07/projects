package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.userdao;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		int id = Integer.parseInt(request.getParameter("id"));
		int status = userdao.delete(id);

	    if (status > 0) {
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("users");
	        dispatcher.forward(request, response);
	    } else {
	      
	        PrintWriter out = response.getWriter();
	        out.println("Failed to delete user with ID: " + id);
	        out.close();
	    }

	}

}
