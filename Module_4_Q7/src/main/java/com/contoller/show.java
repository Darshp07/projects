package com.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.Studentdao;

@WebServlet("/show")
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Studentdao dao = new Studentdao();
		ArrayList<Student> studentlist = dao.Studentlist();

		req.setAttribute("data", studentlist);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}
}
