package com.ksleano.spring.service;

import java.util.List;
import com.ksleano.spring.entity.Customer;


// this is just an interface. Heavy lifting is done by DAOImp
public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customerFromForm);

	public Customer getCustomer(int idFromTheUrl);

	public void deleteCustomer(int idFromTheUrl);
}	
