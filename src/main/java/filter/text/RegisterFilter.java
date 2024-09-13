package filter.text;

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
@WebFilter("/register")
public class RegisterFilter implements Filter{
	private Pattern emailpattern;
	private Pattern  passwordPattern;
	private Pattern contactPattern;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		emailpattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		passwordPattern = Pattern.compile("^(?=.[A-Z])(?=.[!@#$%^&])[A-Za-z0-9!@#$%^&]{1,8}$");
		contactPattern = Pattern.compile("^\\d{10}$");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		if(email !=null && emailpattern.matcher(email).matches()) {
			if(password != null && passwordPattern.matcher(password).matches()) {
				
				chain.doFilter(request, response);	
			}
			else {
				System.out.println("invalid password");
				RequestDispatcher rd = request.getRequestDispatcher("register.html");
				rd.forward(request, response);
			}
			
		}
		else {
			System.out.println("invalid email format");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");
			rd.forward(request, response);
		}
		if(contact != null && contactPattern.matcher(contact).matches()) {
			chain.doFilter(request, response);
		}
		else {
			System.out.println("invalid contact number");
		}
		
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

}
