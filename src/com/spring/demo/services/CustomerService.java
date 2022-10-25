package com.spring.demo.services;

import java.util.List;

import com.spring.demo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(boolean sortDsc);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String theSearchName);
}
