package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.bean.user;
import com.dao.userdao;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("uname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		user user = new user(name, email, password);

		userdao dao = new userdao();

		String msg = null;
		String error = null;

		try {
			int result = dao.insertdata(user);

			if (result > 0) {

				msg = "Record saved successfully !!!";
			} else {
				error = "Failed to insert Record.";
			}

		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
			e.printStackTrace();
		}

		request.setAttribute("msg", msg);
		request.setAttribute("error", error);

		RequestDispatcher dispatcher = request.getRequestDispatcher("inputform.jsp");
		dispatcher.forward(request, response);

	}

}
