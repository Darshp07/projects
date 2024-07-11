package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.user;
import com.dao.userdao;


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		int id = Integer.parseInt(request.getParameter("id"));
		response.getWriter().print(id);
		userdao dao = new userdao();
		
		try {

			user user = dao.getuserdata(id);
			
			if(user!=null) {
				response.getWriter().print(user.getName());
				request.setAttribute("user", user);
				request.getRequestDispatcher("update.jsp").forward(request, response);
				
			}
			
			response.getWriter().print("null");

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(e.getMessage());
		}

	}

}
