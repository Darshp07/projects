package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user;
import dao.userdao;

@WebServlet("/update")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	userdao dao;

	@Override
	public void init() throws ServletException {
		dao = new userdao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		user user = new user();
		user.setId(id);

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		int status = dao.update(user);
		if(status>0) {
			out.write("insert succesefully....!!");
		}
	}

}
