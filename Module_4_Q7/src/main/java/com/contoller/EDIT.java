package com.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;

import com.dao.Studentdao;

@WebServlet("/EDIT")
public class EDIT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		response.getWriter().print(id);

		Studentdao dao = new Studentdao();

		try {

			Student std = dao.getStudentdata(id);

			if (std != null) {
				response.getWriter().print(std.getFname());
				request.setAttribute("Student", std);
				request.getRequestDispatcher("edit.jsp").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(e.getMessage());
		}

	}
}
