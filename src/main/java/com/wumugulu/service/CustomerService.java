package com.wumugulu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wumugulu.jdbc.CustomerRepository;
import com.wumugulu.model.Customer;

@Service
public class CustomerService {
	
	@Resource
	private CustomerRepository customerRepository;

	public List<Customer> findAll(){
		return customerRepository.findAll(); 
	}

	public Customer find(Integer id){
		return customerRepository.find(id); 
	}

	public Customer create(Customer customer){
		return customerRepository.create(customer); 
	}

	public Customer create2(Customer customer){
		return customerRepository.create2(customer); 
	}


	public Customer update(Integer id, Customer customer){
		return customerRepository.update(id, customer); 
	}


}
