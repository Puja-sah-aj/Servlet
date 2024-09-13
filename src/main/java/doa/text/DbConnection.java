package doa.text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	public DbConnection() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnect2","root","Puja2002");
	}
	public void Saveuser(String name,String email,String password,String gender,String contact,String address ) {
		String sql = "insert into register(name,email,password,gender,contact,address) values (?,?,?,?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, email);
			pre.setString(3, password);
			pre.setString(4, gender);
			pre.setString(5, contact);
			pre.setString(6, address);
			
			int i = pre.executeUpdate();
			if(i>0) {
				System.out.println("register sucessfully");
			}
			else {
				System.out.println("register not sucessfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
	}
	
}

