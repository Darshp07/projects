package com.MyProject;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Studentdao;
import com.student.student;

@WebServlet("/Usertable")
public class Usertable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='advancenew.jsp'>Add Student</a>");
		out.println("<h2>List of Student </h2>");

		List<student> list = Studentdao.show();

		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>ID</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Mobile_No</th><th>DOB</th><th>Addrese</th><th>Gender</th><th>Hobbies</th><th>Education</th><th>Edit</th><th>delete</th></tr>");
		for (student st : list) {
			out.print("<tr><td>" + st.getId() + "</td><td>" + st.getFname() + "</td><td>" + st.getLname() + "</td><td>"
					+ st.getEmail() + "</td><td>" + st.getMobile_no() + "</td><td>" + st.getDOB() + "</td><td>"
					+ st.getAddrese() + "</td><td>" + st.getGender() + "</td><td>" + st.getHobbies() + "</td><td>"
					+ st.getEduction() + "</td><td><a href='Getstd?id=" + st.getId()
					+ "'>edit</a></td>  <td><a href='StdDelete?id=" + st.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.close();
	}

}
