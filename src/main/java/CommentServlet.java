import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Comment")
public class CommentServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = session.getAttribute("email").toString();
		String comment = request.getParameter("comment");
		
		LoginData logindata = new LoginData();
		logindata.setComment(comment);
		logindata.setEmail(email);
		
		LoginDao ld = new LoginDao();
		
		try {
			ld.comment(logindata);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("comment.jsp");
		dis.forward(request, response);
	}

}
