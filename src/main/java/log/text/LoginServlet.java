package log.text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/submit")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		if(validateuser(email, password)) {
			HttpSession hs = req.getSession();
			hs.setAttribute("name", email);
			
			 resp.sendRedirect("ProfileServlet");
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.forward(req, resp);
		}
		
	}

	
	
	
	private boolean validateuser(String email,String password){
		boolean br = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnect2","root","Puja2002");
			String sql = "SELECT * FROM register WHERE email=? AND password=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, email);
			pr.setString(2, password);
			ResultSet rs = pr.executeQuery();
			
			if(rs.next()) {
				br = true;
			}
			
			rs.close();
			pr.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return br;
		
	}
}
