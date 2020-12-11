package ex1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Control")
public class Control extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if ( action == null || action.isEmpty() ) {
			resp.getWriter().println("Aucune action");
			return;
		}
		
		DAO dao = new DAO();
		
		if ( action.equals("vignette") ) {
			String idParam = req.getParameter("id");
			if ( idParam == null || idParam.isEmpty() ) {
				resp.getWriter().println("Id obligatoire");
				return;
			}
			int id = Integer.parseInt(idParam);
			
			String element = dao.findById(id);
			
			req.setAttribute("element", element);
			req.getRequestDispatcher("vignette.jsp").forward(req, resp);
			return;
		}
		
		if ( action.equals("liste") ) {
			List<String> allElements = dao.findAll();
			req.setAttribute("elements", allElements);
			req.getRequestDispatcher("liste.jsp").forward(req, resp);
			return;
		}
		
		
		resp.getWriter().println("Action inconnue");
		
	}
	
}