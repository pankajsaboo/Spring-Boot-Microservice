package com.customer.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.CustomerDto;
import com.customer.handler.CustomerHandler;
import com.customer.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
		
		@Autowired
		private CustomerHandler customerHandler;


		@GetMapping(value = "/{id}")
		public ResponseEntity<Customer> customer(@PathVariable("id") long id) {
			return new ResponseEntity<>(customerHandler.getCustomerOne(id),HttpStatus.OK);
		}

		@GetMapping
		public ResponseEntity<Iterator<Customer>> customerList() {
			return new ResponseEntity<>(customerHandler.getCustomers(),HttpStatus.OK);
		}

		@PostMapping
		public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto){
			return new ResponseEntity<>(customerHandler.saveCustomer(customerDto),HttpStatus.OK);
		}
}
