package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.dao.ProductDao;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String p_name = request.getParameter("productName");
		
		String P_Category = request.getParameter("category");
		String P_model = request.getParameter("model");
		int p_price =Integer.parseInt(request.getParameter("price")) ;
		String p_description = request.getParameter("description");
		

		Product product = new Product(p_name, P_Category, P_model, p_price, p_description);

		ProductDao dao = new ProductDao();
		String msg = null;
		String error = null;
		try {
			int result = dao.InsertProduct(product);

			if (result > 0) {
				msg = "Record saved successfully !!!";
			} else {
				error = "Failed to insert Record.";
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("error" + e.getMessage());
		}
		request.setAttribute("msg", msg);
		request.setAttribute("error", error);
		 request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

}
