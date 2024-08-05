package com.MyProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.Studentdao;
import com.student.student;

@WebServlet("/Userinput")
public class Userinput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Studentdao dao = new Studentdao();

	@Override
	public void init() throws ServletException {
		System.out.println("server start !!");
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {

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
			std.setFname(Fname);
			std.setLname(Lname);
			std.setEmail(email);
			std.setMobile_no(phone);
			std.setDOB(Dob);
			std.setAddrese(add);
			std.setGender(gender);
			std.setEduction(edcation);
			std.sethobbies(hobbies);

			dao.insert(std);

			response.sendRedirect("NewFile.jsp");


		}

	}

}
