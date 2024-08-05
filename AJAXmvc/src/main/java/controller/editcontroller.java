package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.user;
import dao.userdao;

@WebServlet("/edit")
public class editcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userdao dao;

	@Override
	public void init() throws ServletException {
		dao = new userdao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("application/json");
		  response.setCharacterEncoding("UTF-8");
		user us = dao.edit(id);
		if (us != null) {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(us);
			out.append(json);
			;
		}
	}

}
