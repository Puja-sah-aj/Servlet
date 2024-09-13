package logout.text;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Invalidate the session if it exists
		HttpSession hs = request.getSession(false);
		if (hs != null) {
			hs.invalidate(); // Invalidates the current session
		}
		// Redirect to the login page (or index.html)
		response.sendRedirect("index.html");
	}

}
