import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public boolean valid(LoginData LoginData) throws ClassNotFoundException, SQLException {
		
		boolean result = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comment","root","7558");
		
		String q = "select * from login where Email=?";
		try {
			PreparedStatement ps = c.prepareStatement(q);
			ps.setString(1, LoginData.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void insert(LoginData LoginData) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comment","root","7558");
		
		String q = "Insert into login(Email,Password,Secret) value(?,?,?)";
		
		try {
			PreparedStatement ps = c.prepareStatement(q);
			ps.setString(1, LoginData.getEmail());
			ps.setString(2, LoginData.getPassword());
			ps.setString(3, LoginData.getSecret());
			ps.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		} 
	}
	
	public boolean checkpass(LoginData LoginData) throws ClassNotFoundException, SQLException {
		
		boolean result = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comment","root","7558");
		
		String q = "select * from login where Email=? and Password=?";
		try {
			PreparedStatement ps = c.prepareStatement(q);
			ps.setString(1, LoginData.getEmail());
			ps.setString(2, LoginData.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
				LoginData.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public LoginData checksecret(LoginData LoginData) throws ClassNotFoundException, SQLException {
		
		LoginData result = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comment","root","7558");
		
		String q = "select * from login where Email=? and Secret=?";
		try {
			PreparedStatement ps = c.prepareStatement(q);
			ps.setString(1, LoginData.getEmail());
			ps.setString(2, LoginData.getSecret());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				LoginData.setPassword(rs.getString("Password"));
				result = LoginData;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void comment(LoginData LoginData) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comment","root","7558");
		
		String q = "update login set Comment=? where Email=?;";
		try {
			PreparedStatement ps = c.prepareStatement(q);
			ps.setString(1,LoginData.getComment());
			ps.setString(2, LoginData.getEmail());
			ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}