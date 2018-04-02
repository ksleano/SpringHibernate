package com.ksleano.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksleano.spring.dao.CustomerDAO;
import com.ksleano.spring.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	// need to inject the CustomerDataAccessObject because the service depends
	// on the DAO
	@Autowired
	private CustomerDAO customerDataAccessObject;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// use the DAO's getCustomers() to get thy customers
		return customerDataAccessObject.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customerFromForm) {
		
		// delegate the saving process to the data access object
		customerDataAccessObject.saveCustomer(customerFromForm);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int idFromTheUrl) {
		
		// delegate the customer grabbing to the Data Access Object
		return customerDataAccessObject.getCustomer(idFromTheUrl);
	}

	@Override
	@Transactional
	public void deleteCustomer(int idFromTheUrl) {
		// delegate the deletion using the data access object
		customerDataAccessObject.deleteCustomer(idFromTheUrl);
		
	}

}
