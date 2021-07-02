package cybersoft.java12.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if("admin".equals(username) && "123456".equals(password)) {
			req.setAttribute("name", username);
			req.setAttribute("pass", password);
			req.getRequestDispatcher("info.jsp").forward(req, resp);
		}else {
			req.setAttribute("message", "Sai tên username hoặc password");
			resp.sendRedirect(req.getContextPath() + "/login");
			}
	}
}
