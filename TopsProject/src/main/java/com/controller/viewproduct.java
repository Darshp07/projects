package com.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.dao.ProductDao;

@WebServlet("/viewproduct")
public class viewproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDao();

		ArrayList<Product> productlist = dao.productlist();

		req.setAttribute("data", productlist);

		req.getRequestDispatcher("products.jsp").forward(req, resp);
	}

	

}
