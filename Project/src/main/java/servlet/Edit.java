package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegestrationFrom", "root", "3306");

			String sql = "SELECT * FROM UserData WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			HashMap<String, String> map = new HashMap<String, String>();

			while (rs.next()) {
				map.put("id", rs.getInt("id") + "");
				map.put("name", rs.getString("name"));
				map.put("email", rs.getString("email"));
				map.put("password", rs.getString("password"));
			}

			request.setAttribute("data", map);

		//	response.sendRedirect("update.jsp");

			RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException | ClassNotFoundException e) {

		}

	}

}
