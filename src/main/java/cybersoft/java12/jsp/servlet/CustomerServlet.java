package cybersoft.java12.jsp.servlet;

import java.io.IOException;
import java.net.URLStreamHandler;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java12.jsp.model.Customer;
import cybersoft.java12.jsp.service.CustomerService;
import cybersoft.java12.jsp.util.PathUtils;
import cybersoft.java12.jsp.util.UrlUtils;

@WebServlet(name = "customerServlet", urlPatterns = {
		UrlUtils.CUSTOMER_DASHBOARD,
		UrlUtils.CUSTOMER_ADD,
		UrlUtils.CUSTOMER_UPDATE,
		UrlUtils.CUSTOMER_DELETE
})
public class CustomerServlet extends HttpServlet{
	private CustomerService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		System.out.println(path);
		switch(path) {
		case UrlUtils.CUSTOMER_DASHBOARD:{
			List<Customer> customers = service.findAllCustomers();
			req.setAttribute("customers", customers);
			req.getRequestDispatcher(PathUtils.CUSTOMER_DASHBOARD).forward(req, resp);
			break;
			}
			
		case UrlUtils.CUSTOMER_ADD:{
			req.getRequestDispatcher(PathUtils.CUSTOMER_ADD).forward(req, resp);
			break;
			}
			
		case UrlUtils.CUSTOMER_UPDATE: {
			int codeToUpdate = Integer.parseInt(req.getParameter("code"));
			Customer customerToUpdate = service.findCustomerByCode(codeToUpdate);
			req.setAttribute("customer", customerToUpdate);
			req.getRequestDispatcher(PathUtils.CUSTOMER_UPDATE).forward(req, resp);	
			break;
			}
		
		case UrlUtils.CUSTOMER_DELETE:{
			int codeToBeDeleted = Integer.parseInt(req.getParameter("code"));
			service.deleteCustomerByCode(codeToBeDeleted);
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;
		}
			
		default:
		
		}
		
//		System.out.printf("\n =>>> %s has been accessed", path);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		
		switch(path) {
		case UrlUtils.CUSTOMER_ADD:{	
			int code = Integer.parseInt(req.getParameter("code"));
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String email = req.getParameter("email");
			Customer newCustomer = new Customer(code, name, address, email);
			service.addNewCustomer(newCustomer);
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;
		}
		
		case UrlUtils.CUSTOMER_UPDATE:{
			int codeToUpdate = Integer.parseInt(req.getParameter("code"));
			
			Customer customerToUpdate = service.findCustomerByCode(codeToUpdate);
			
			customerToUpdate.setName(req.getParameter("name"));
			customerToUpdate.setAddress(req.getParameter("address"));
			customerToUpdate.setEmail(req.getParameter("email"));
			service.update(customerToUpdate);
			resp.sendRedirect(req.getContextPath() + UrlUtils.CUSTOMER_DASHBOARD);
			break;
		}
		
		}
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		service = new CustomerService();
	}
	
	
}
