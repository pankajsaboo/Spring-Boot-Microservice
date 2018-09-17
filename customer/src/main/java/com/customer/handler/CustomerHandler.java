package com.customer.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dto.CustomerDto;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerHandler {
		
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer getCustomerOne(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if(customerOptional.isPresent()) {
			return null;
		}
		return customerOptional.get();
	}
	
	public Iterator<Customer> getCustomers() {
		return customerRepository.findAll().iterator();
	}
	
	public Customer saveCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		return customerRepository.save(customer);
	}

}
