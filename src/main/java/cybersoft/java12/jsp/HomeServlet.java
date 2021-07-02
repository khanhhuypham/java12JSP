package cybersoft.java12.jsp;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "homeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: Xử lý trang home
//		resp.sendRedirect(req.getContextPath() +"/home-page.jsp");
		req.getRequestDispatcher("/WEB-INF/home-page.jsp").forward(req, resp);
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Điện thoại Nokia", 20, 1500000));
		products.add(new Product("Điện thoại Samsung", 50, 5500000));
		
		req.setAttribute("products", products);
		req.getRequestDispatcher("home-page.jps").forward(req, resp);
		
	}
	
	
	
}
