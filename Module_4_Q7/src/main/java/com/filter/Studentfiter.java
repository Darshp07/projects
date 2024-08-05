package com.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/StudentServlet")
public class Studentfiter extends HttpFilter implements Filter {

	public boolean isValidEmail(String email) {
		String regex = "^[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]{2,4}$";
		return Pattern.compile(regex).matcher(email).matches();
	}

	public boolean isValidName(String name) {
		String regex = "^[a-zA-Z]+$";
		return Pattern.compile(regex).matcher(name).matches();
	}

	public boolean isValidMobile(String mobile) {
		String regex = "^[0-9]{10}$";
		return Pattern.compile(regex).matcher(mobile).matches();
	}

	public boolean isValidPassword(String password) {
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#\\$%_&]).{4,}$";
		return Pattern.compile(regex).matcher(password).matches();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		System.out.println("name "+fname);

		RequestDispatcher dispatcher = request.getRequestDispatcher("input.jsp");

		if (fname == null || fname.isEmpty()) {
			request.setAttribute("fnameErr", "First name is required.");
			dispatcher.forward(request, response);
			return;
		} else if (!isValidName(fname)) {
			request.setAttribute("fnameErr", "First name is invalid.");
			dispatcher.forward(request, response);
			return;
		}

		if (lname == null || lname.isEmpty()) {
			request.setAttribute("lnameErr", "Last name is required.");
			dispatcher.forward(request, response);
			return;
		} else if (!isValidName(lname)) {
			request.setAttribute("lnameErr", "Last name is invalid.");
			dispatcher.forward(request, response);
			return;
		}

		if (email == null || email.isEmpty()) {
			request.setAttribute("emailErr", "Email is required.");
			dispatcher.forward(request, response);
			return;
		} else if (!isValidEmail(email)) {
			request.setAttribute("emailErr", "Email is invalid.");
			dispatcher.forward(request, response);
			return;
		}

		if (mobile == null || mobile.isEmpty()) {
			request.setAttribute("mobileErr", "Mobile number is required.");
			dispatcher.forward(request, response);
			return;
		} else if (!isValidMobile(mobile)) {
			request.setAttribute("mobileErr", "Mobile number is invalid.");
			dispatcher.forward(request, response);
			return;
		}

		if (password == null || password.isEmpty()) {
			request.setAttribute("passwordErr", "Password is required.");
			dispatcher.forward(request, response);
			return;
		} else if (!isValidPassword(password)) {
			request.setAttribute("passwordErr", "Password is invalid.");
			dispatcher.forward(request, response);
			return;
		}

		chain.doFilter(request, response);

	}

}
