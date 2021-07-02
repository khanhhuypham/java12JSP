package cybersoft.java12.jsp.service;

import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.jsp.Repository.CustomerRepository;
import cybersoft.java12.jsp.model.Customer;

public class CustomerService {
	private List<Customer> customers;
	private CustomerRepository repository;
	
	public CustomerService(){
		repository = new  CustomerRepository();
		customers = new LinkedList<Customer>();

	}
	
	/*hiện thực code cho các phương thức sau: 
	 * -findAllCustomer: trả về danh sách customer đang quản lý
	 * -findCustomerByCode: trả về 1 customer có code bằng với tham số được truyền vào
	 * -deleteCustomerByCode: xóa customer có mã code bằng với tham số được truyền vào
	 * -addNewCustomer: thêm customer vào danh sách quản lý
	 * */
	public List<Customer> findAllCustomers(){
		return repository.findAllCustomer();
	}
	
	public Customer findCustomerByCode(int code) {
		return repository.findCustomerByCode(code);
	}
	
	public void deleteCustomerByCode(int code) {
		int result = repository.deleteCustomerByCode(code);
		if(result == 0) {
			System.out.print("\nthe ID is not found");
			return;
		}else if(result != 0) {
			System.out.print("\nthe delete function has been finished");
		}
	}
	
	
	public void addNewCustomer(Customer customer) {
		int result = repository.addNewCustomer(customer);
		if(result == 0) {
			System.out.print("\nthe ID is not found");
			return;
		}else if(result != 0) {
			System.out.print("\nthe add function has been finished");
		}
	}
	
	public void update(Customer customerToUpdate) {
		int result = repository.updateCustomer(customerToUpdate);
		if(result == 0) {
			System.out.print("\nthe ID is not found");
			return;
		}else if(result != 0) {
			System.out.print("\nthe update function has been finished");
		}
		
	}
	
}
