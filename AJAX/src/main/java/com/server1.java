package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/server1")
public class server1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String value = request.getParameter("value");

		PrintWriter out = response.getWriter();
		out.append("Hello " + value);

		if (value.equals("electric")) {
			out.append("<ul><li>Fan</li><li>TV</li><li>Laptop</li></ul>");
		} else if (value.equals("cloths")) {
			out.append("<ul><li>Jeans</li><li>Top</li><li>Shirt</li></ul>");
		} else {
			out.append("No data found");
		}

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/d_product", "root", "3306");
			String sql = "SELECT * FROM Products WHERE pname LIKE '" + value + "%'";

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			String str = "<ul>";

			while (rs.next()) {
				str += "<li>" + rs.getString("pname") + "</li>";
			}

			str += "</ul>";

			out.append(str);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
