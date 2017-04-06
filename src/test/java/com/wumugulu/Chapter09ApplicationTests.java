package com.wumugulu;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wumugulu.jdbc.CustomerRepository;
import com.wumugulu.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter09ApplicationTests {

	@Resource
	private CustomerRepository customerRepository;

	@Test
	public void testCreate() {
		Customer customer = new Customer();
		customer.setCid(99);
		customer.setCustomerName("王自健 3");
		customer.setCustomerLevel("VIP-P 3");
		customer.setCustomerSource("东方卫视 3");
		customer.setCustomerPhone("020-88009965");
		customer.setCustomerMobile("13301661234");
		
		customerRepository.create2(customer);
		System.out.println(customer.toString());
	}

}
