package com.spring.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.entity.Customer;
import com.spring.demo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private boolean sortDsc = false;
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model model) {
		
		List<Customer> customersList = customerService.getCustomers(sortDsc);
		
		
		model.addAttribute("customersList",customersList);
		// System.out.println(customersList);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		customerService.saveCustomer(customer);
		
		
		return "redirect:/customer/list";
		
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int id, Model model) {
		
		
		Customer customerToUpdate = customerService.getCustomer(id);
		
		model.addAttribute("customer",customerToUpdate);
		
		return "customer-form";
		
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int id) {
		
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
		
	}
    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        //System.out.println(theCustomers);
        theModel.addAttribute("customersList", theCustomers);
        return "list-customers";        
    }
    @GetMapping("/sort")
	public String sort(Model model) {
    	sortDsc = !sortDsc;
		List<Customer> customersList = customerService.getCustomers(sortDsc);

		model.addAttribute("customersList",customersList);
		// System.out.println(customersList);
		return "list-customers";
	}
	
}
