package com.wumugulu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wumugulu.model.Customer;
import com.wumugulu.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Resource
	private CustomerService customerService;

	@GetMapping("")
	@ResponseBody
	public ResponseEntity<Object> findAll(){
		List<Customer> list = customerService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Object> find(@PathVariable("id")Integer id){
		Customer customer = customerService.find(id);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Object> create(Customer customer){
		Customer newCustomer = customerService.create(customer);
		return ResponseEntity.status(HttpStatus.OK).body(newCustomer);
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Object> create2(Customer customer){
		Customer newCustomer = customerService.create2(customer);
		return ResponseEntity.status(HttpStatus.OK).body(newCustomer);
	}
	
	@PutMapping("")
	@ResponseBody
	public ResponseEntity<Object> update(Integer id, Customer customer){
		Customer newCustomer = customerService.create(customer);
		return ResponseEntity.status(HttpStatus.OK).body(newCustomer);
	}
	
	
	@PostMapping("")
	public ResponseEntity<Object> CreateConnectionTask(){
		String result = "connection success";
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PostMapping("/session")
	public ResponseEntity<Object> sessionTest(HttpServletRequest request){
		request.getSession().setAttribute("myId", new Integer(199));
		String result = "session success";
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
