package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.user;
import com.dao.userdao;

@WebServlet("/users")
public class userslist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		userdao dao = new userdao();
		ArrayList<user> userlist = dao.getUserList();
		
		request.setAttribute("data", userlist);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
		dispatcher.forward(request, response);

   
	}

}
