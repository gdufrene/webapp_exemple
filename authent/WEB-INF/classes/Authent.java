import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Authent")
public class Authent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("pwd");
		
		
		try {
			Class.forName("org.h2.Driver");
		} catch ( ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try ( Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/authent", "sa", "") ) {
			
			PreparedStatement ps = con.prepareStatement("select * from personne where login = ? and mdp = ?");
			ps.setString(1, login);
			ps.setString(2, password);
			// login -> guillaume' --
			ResultSet rs = ps.executeQuery();
			
			boolean exists = rs.next();
			
			if ( exists ) {
				HttpSession session = req.getSession();
				session.setAttribute("LoginOk", true);
			} else {
				System.out.println("Authentification echouée");
			}
			
			resp.sendRedirect("servlet-statut");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		
	}
	
}