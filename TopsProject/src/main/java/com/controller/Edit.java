package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Product;
import com.dao.ProductDao;


@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("p_id"));
		
		ProductDao dao = new ProductDao();
		
		try {

			Product product = dao.getproduct(id); 
			
			if(product != null) {
				request.setAttribute("product", product);
				
				request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
			}
			else {

				response.getWriter().print("null");

			}
		}catch(Exception e) {
			e.printStackTrace();
			response.getWriter().print(e.getMessage());
		}
	}

	
	

}
