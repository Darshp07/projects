package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.user;
import com.dao.userdao;

@WebServlet("/userupdate")
public class userupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("uname");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	user user = new user(id,name, email, password);
	
	userdao dao = new userdao();
	
	if(dao.update(user)>0) {
		request.getRequestDispatcher("inputform.jsp").forward(request, response);
		
	}
	}

}