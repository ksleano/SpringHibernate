package com.ksleano.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksleano.spring.entity.Customer;
import com.ksleano.spring.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/* 1. Inject the DAO in the CustomerController
	@Autowired
	private CustomerDAO customerDataAccessObject; 
	*/
	
	// need to inject the customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get the customers from the Data Access Object 
		// BUT now use the service
		List<Customer> customerListResult = customerService.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customerListResult);
		
		// returns a jsp page in the WEB-INF/view folder
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create customer model attribute to find form data
		Customer customerValue = new Customer();
		
		// name, value. In this case customer is used in the html/jsp page
		model.addAttribute("customer",customerValue);
		
		return "customer-form";
	}
	
	// receiving data from the form so we use post instead and use the model attribute that was passed
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customerFromForm) {
		
		// call in the service to start the process in saving the data
		// pass in the ModelAttribute object from the form
		customerService.saveCustomer(customerFromForm);
		
		
		// redirect back to the customer list
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int idFromTheUrl, Model model) {
		
		// get customer based on the id passed from the service
		Customer customerFromService = customerService.getCustomer(idFromTheUrl);
		
		// set customer as a model attribute to pre-populate th	e form
		model.addAttribute("customer", customerFromService);
		
		// send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int idFromTheUrl, Model model) {
		
		// delegate the service to do the deletion using the id from the url
		customerService.deleteCustomer(idFromTheUrl);
		
		// send back to the list
		return "redirect:/customer/list";
	}

}












