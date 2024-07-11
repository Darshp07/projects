package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Product;
import com.dao.ProductDao;

@WebServlet("/Upateseverlet")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String p_name = request.getParameter("productName");
		String P_Category = request.getParameter("category");
		String P_model = request.getParameter("model");
		 int p_price = Integer.parseInt(request.getParameter("price"));
		String p_description = request.getParameter("description");
		Product product = new Product();
		product.setId(id);
		product.setProductName(p_name);
		product.setCategory(P_Category);
		product.setModel(P_model);
		product.setPrice(p_price);
		product.setDescription(p_description);
		int result;
		try {
			result = ProductDao.update(product);
			if (result > 0) {
				System.out.println(result);
				// RequestDispatcher dispatcher = request.getRequestDispatcher("viewproduct");
				// dispatcher.forward(request, response);

				response.sendRedirect("viewproduct");
			}
			response.getWriter().print("null");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}