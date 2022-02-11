import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Forgot")
public class ForgotServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String secret = request.getParameter("secret");
		
		LoginData logindata = new LoginData();
		logindata.setEmail(email);
		logindata.setSecret(secret);
		
		LoginDao ld = new LoginDao();
		
		try {
			if (ld.checksecret(logindata)!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("password",logindata.getPassword());
				RequestDispatcher dis = request.getRequestDispatcher("Show password.jsp");
				dis.forward(request, response);
			}
			else {
				response.sendRedirect("Forgot Password.html");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
