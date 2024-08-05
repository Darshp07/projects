package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.user;
import dao.userdao;

@WebServlet("/users")
public class users extends HttpServlet {
	private static final long serialVersionUID = 1L;

	userdao dao;

	public void init() throws ServletException {
		dao = new userdao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		ArrayList<user> userlist = dao.userlist();

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(userlist);
//		out.write(json);
//		out.flush();
		out.append(json);
	}

}
