package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("uname");

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();

		String msg = null;
		String error = null;
		
		final String URL = "jdbc:mysql://localhost:3306/RegestrationFrom";
		final String USER = "root";
		final String PASS = "3306";
		

		try {

	
		 
		Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection(URL,USER,PASS);

			String sql = "INSERT INTO UserData(name, email, password) VALUES (?,?,?)";
		
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, password);

			int result = stmt.executeUpdate();

			if (result > 0) {
				msg = "Record saved successfully !!!";
				out.print(msg);
			} else {
				error = "Failed to insert Record.";
				out.print(error);
			}

		} catch (SQLException | ClassNotFoundException e) {
			error = "Error : " + e.getMessage();
		}

		request.setAttribute("msg", msg);
		request.setAttribute("error", error);

		out.print("<h4>Record saved successfully !!!</h4>");

		RequestDispatcher dispatcher = request.getRequestDispatcher("BootStrip.jsp");
		dispatcher.forward(request, response);

	}

}
