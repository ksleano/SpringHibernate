package com.ksleano.spring.dao;
import com.ksleano.spring.entity.Customer;

public interface CustomerDAO {
	
	public java.util.List<Customer> getCustomers();

	public void saveCustomer(Customer customerFromForm);

	public Customer getCustomer(int idFromTheUrl);

	public void deleteCustomer(int idFromTheUrl);


}
