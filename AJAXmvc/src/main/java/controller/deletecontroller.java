package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;

@WebServlet("/delete")
public class deletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userdao dao;

	@Override
	public void init() throws ServletException {
		dao = new userdao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		int status = dao.delete(id);
		if (status > 0) {
			PrintWriter out = response.getWriter();
			out.append("Record deleted successfully..");

		}
	}

}
