import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class SignupServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String secret = request.getParameter("secret");
		
		LoginData logindata = new LoginData();
		logindata.setEmail(email);
		logindata.setPassword(password);
		logindata.setSecret(secret);
		
		LoginDao ld = new LoginDao();
		
		try {
			if (ld.valid(logindata)) {
				response.sendRedirect("Sign Up.html");
			}
			else {
				ld.insert(logindata);
				RequestDispatcher dis = request.getRequestDispatcher("Successfully register.jsp");
				dis.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
