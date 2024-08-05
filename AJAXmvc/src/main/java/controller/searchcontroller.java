package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.user;
import dao.userdao;

@WebServlet("/search")
public class searchcontroller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private userdao dao;

    @Override
    public void init() throws ServletException {
        dao = new userdao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String value = request.getParameter("value");

        List<user> users = dao.search(value);
        Gson gson = new Gson();
        String json = gson.toJson(users);

        PrintWriter out = response.getWriter();
        out.write(json);
    }
}
