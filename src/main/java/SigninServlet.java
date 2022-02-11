import java.io.IOException;

import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Signin")
public class SigninServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginData logindata = new LoginData();
		logindata.setEmail(email);
		logindata.setPassword(password);
		
		LoginDao ld = new LoginDao();
		
		try {
			if (ld.checkpass(logindata)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect("comment.jsp");
			}
			else {
				response.sendRedirect("Sign In.html");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
