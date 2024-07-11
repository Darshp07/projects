package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("p_id"));
		ProductDao dao = new ProductDao();
		int status = dao.delete(id);

		if (status > 0) {
			request.getRequestDispatcher("viewproduct").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("Failed to delete user with ID: " + id);
			out.close();
		}

	}

}
