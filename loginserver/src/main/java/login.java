
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.user;
import com.dao.userdao;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		userdao dao = new userdao();

		ArrayList<user> users = dao.logindata();
		for (user us : users) {
			if (us.getEmail().equals(email) && us.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				session.setAttribute("userId", us.getId());
				String username = (String) session.getAttribute("userId");
				System.out.println(session.getId());
				request.getRequestDispatcher("inputform.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.invalidate();
				request.setAttribute("error", "input valid id");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	}

}
