package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;

import com.dao.UserDao;
;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();

		user.setEmail(email);
		user.setPassword(password);
		UserDao dao = new UserDao();

		ArrayList<User> users = dao.logindata();

		boolean isAuthenticated = false;

		for (User us : users) {
			if (us.getEmail().equals(email) && us.getPassword().equals(password)) {
				
				response.sendRedirect("input.jsp");
				isAuthenticated = true;
				break;

			}
		}

		if (!isAuthenticated) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("error", "Invalid Credential !!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
