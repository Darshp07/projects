package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user;
import dao.userdao;

@WebServlet("/insert")
public class insertcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userdao udao;

	@Override
	public void init() throws ServletException {
		udao = new userdao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		user user = new user();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		int id;
		try {
			id = udao.insertUser(user);
			if (id > 0) {
				out.append("insert succesefully....!!");
			
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
