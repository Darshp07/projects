package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.diagnose.DiagnoseParser;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();

		final String URL = "jdbc:mysql://localhost:3306/RegestrationFrom";
		final String USER = "root";
		final String PASS = "3306";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER, PASS);
			String sql = "delete from UserData where id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			out.print(con);
			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			out.print(e);
			e.printStackTrace();
		}
		
		response.sendRedirect("BootStrip.jsp");

	}

}
