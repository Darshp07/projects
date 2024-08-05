package com.MyProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Studentdao;
import com.student.student;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// out.print(request.getParameter("id"));
		String sid = request.getParameter("id");
		
		
		int Sno = Integer.parseInt(sid);
		
		String Fname = request.getParameter("firstname");
		String Lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("mobile");
		String Dob = request.getParameter("dob");
		String add = request.getParameter("address");
		String gender = request.getParameter("gender");
		String edcation = request.getParameter("education");
		String hobbies = request.getParameter("hobbies");
		
		
		
		student std = new student();
		std.setId(Sno);
		std.setFname(Fname);
		std.setLname(Lname);
		std.setEmail(email);
		std.setMobile_no(phone);
		std.setDOB(Dob);
		std.setAddrese(add);
		std.setGender(gender);
		std.setEduction(edcation);
		std.sethobbies(hobbies);
		
		int status = Studentdao.update(std);
		if (status > 0) {
			response.sendRedirect("Usertable");
		} else {
			out.println("Sorry! unable to update record");
		}
	
	//	response.sendRedirect("Usertable");

	}

}
