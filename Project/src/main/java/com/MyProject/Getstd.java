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

@WebServlet("/Getstd")
public class Getstd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1 align='center' style='color:green;'>Update details</h1>");
		String sid = request.getParameter("id");
		out.print(sid);
		int id = Integer.parseInt(sid);
		student st = Studentdao.GetAllStudent(id);

		out.print("<form action='UpdateStudent' method='post'>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<td><label for='id'>ID</label></td>");
		out.print("<td><input type='hedden' id='id' name='id' value='" + st.getId() + "' readonly/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label for='firstname'>First Name</label></td>");
		out.print("<td><input type='text' id='firstname' name='firstname' value='" + st.getFname() + "'/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label for='lastname'>Last Name</label></td>");
		out.print("<td><input type='text' id='lastname' name='lastname' value='" + st.getLname() + "'/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label for='email'>Email ID</label></td>");
		out.print("<td><input type='email' id='email' name='email' value='" + st.getEmail() + "'/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label for='mobile'>Mobile Number</label></td>");
		out.print("<td><input type='text' id='mobile' name='mobile' value='" + st.getMobile_no() + "'/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label for='DOB'>DOB</label></td>");
		out.print("<td><input type='date' id='DOB' name='dob' value='" + st.getDOB() + "'/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label for='address'>Address</label></td>");
		out.print("<td><textarea id='address' name='address' rows='4'>" + st.getAddrese() + "</textarea></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label>Gender</label></td>");
		out.print("<td>");
		out.print("<input type='radio' id='male' name='gender' value='male'"
				+ (st.getGender().equals("male") ? " checked" : "") + " required> <label for='male'>Male</label>");
		out.print("<input type='radio' id='female' name='gender' value='female'"
				+ (st.getGender().equals("female") ? " checked" : "") + "> <label for='female'>Female</label>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label>Hobbies</label></td>");
		out.print("<td>");
		out.print("<input type='checkbox' id='cricket' name='hobbies' value='cricket'"
				+ (st.getHobbies().contains("cricket") ? " checked" : "")
				+ "> <label for='cricket'>Cricket</label><br>");
		out.print("<input type='checkbox' id='reading' name='hobbies' value='reading'"
				+ (st.getHobbies().contains("reading") ? " checked" : "")
				+ "> <label for='reading'>Reading</label><br>");
		out.print("<input type='checkbox' id='gyming' name='hobbies' value='gyming'"
				+ (st.getHobbies().contains("gyming") ? " checked" : "") + "> <label for='gyming'>Gyming</label><br>");
		out.print("<input type='checkbox' id='traveling' name='hobbies' value='traveling'"
				+ (st.getHobbies().contains("traveling") ? " checked" : "")
				+ "> <label for='traveling'>Traveling</label>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td><label for='education'>Education</label></td>");
		out.print("<td>");
		out.print("<select id='education' name='education' required>");
		out.print("<option value=''>---select----</option>");
		out.print("<option value='secondryschool'" + (st.getEduction().equals("secondryschool") ? " selected" : "")
				+ ">10th</option>");
		out.print("<option value='highschool'" + (st.getEduction().equals("highschool") ? " selected" : "")
				+ ">12th</option>");
		out.print("<option value='bachelors'" + (st.getEduction().equals("bachelors") ? " selected" : "")
				+ ">Bachelor's</option>");
		out.print("<option value='masters'" + (st.getEduction().equals("masters") ? " selected" : "")
				+ ">Master's</option>");
		out.print("<option value='phd'" + (st.getEduction().equals("phd") ? " selected" : "") + ">PhD</option>");
		out.print("<option value='other'" + (st.getEduction().equals("other") ? " selected" : "") + ">Other</option>");
		out.print("</select>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("<button style='color:green' type='submit' align='center' value='Update'>Update</button>");
		out.print("</form>");
	}
}
