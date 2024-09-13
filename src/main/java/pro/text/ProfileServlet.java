package pro.text;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Retrieve the session
	        HttpSession hs = request.getSession(false); // 'false' means don't create a session if it doesn't exist

	        // Check if session exists and email attribute is present
	        
	        String data = (hs != null) ? (String) hs.getAttribute("name") : null;

			if (data != null) {
				// Forward the name to the profile.jsp
				request.setAttribute("name", data);
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			} else {
				// If no session or no name attribute, redirect to login page
				response.sendRedirect("index.html");
			}
	    }

}
