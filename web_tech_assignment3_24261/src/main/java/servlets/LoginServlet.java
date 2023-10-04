package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = (String) req.getSession().getAttribute("email");
		String password = (String) req.getSession().getAttribute("password");
//		PrintWriter out = res.getWriter();
//		out.println("welcome  "+email+" your password is  "+password);
		req.getRequestDispatcher("home.html").forward(req, res);
	}

}
