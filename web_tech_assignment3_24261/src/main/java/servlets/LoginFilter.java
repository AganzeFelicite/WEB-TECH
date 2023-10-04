package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebFilter("/login")
public class LoginFilter  implements Filter{
    public void init() throws ServletException {
       
    }
    String passwd = "12345";
    String emaily = "aganzefelicite@gmail.com";
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
    	HttpServletResponse res = (HttpServletResponse)response;
    	HttpServletRequest req = (HttpServletRequest)request;
    	String password = req.getParameter("password");
    	String email = req.getParameter("email");
    	
    	if (!email.isEmpty() && !password.isEmpty()) {
    		if (email.equals(emaily) && password.equals(passwd)) {
    			HttpSession session = req.getSession();
    			session.setAttribute("password", password);
    			session.setAttribute("email", email);
    			
    			chain.doFilter(req, res);
    		}
    	}else {
    	
    	}
    	

        //chain.doFilter(request, response);

        // Post-processing logic here (after the servlet)
    }

}
