package com.contoller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.Studentdao;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		
		Student std = new Student(fname, lname, email, mobile, gender, password);
		
		Studentdao dao= new Studentdao();
		
		String msg = null;
		String error = null;
		try {
			int result = dao.InsertStudent(std);
			

			if (result > 0) {
				msg = "Record saved successfully !!!";
			} else {
				error = "Failed to insert Record.";
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("error" + e.getMessage());
		}
		request.setAttribute("msg", msg);
		request.setAttribute("error", error);
		 request.getRequestDispatcher("input.jsp").forward(request, response);
	}
	}

