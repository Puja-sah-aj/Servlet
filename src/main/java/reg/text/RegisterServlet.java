package reg.text;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import doa.text.DbConnection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DbConnection dbConnection;
	public RegisterServlet() {
		super();
		dbConnection = new DbConnection();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String contact = req.getParameter("contact");
		String address = req.getParameter("address");
		
		
		try {
			
			
			dbConnection.Saveuser(name,email,password,gender,contact,address);
			System.out.println("registered");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	

}
