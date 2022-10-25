package com.spring.demo.dao;

import java.util.List;

import com.spring.demo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers(boolean dsc);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String theSearchName);
}
