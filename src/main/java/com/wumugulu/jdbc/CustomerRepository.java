package com.wumugulu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.wumugulu.model.Customer;

@Repository
public class CustomerRepository {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<Customer> findAll(){
		String sql = "select cid, custname, custlevel, custsource, custphone, custmobile from t_customer limit ?, ?";
		List<Object> args = new ArrayList<>();
		args.add(new Integer(2));
		args.add(new Integer(3));
		//Object[] temp = args.toArray();
		//List<Map<String, Object>> resultMapList = jdbcTemplate.queryForList(sql, temp);
		List<Customer> list = jdbcTemplate.query(sql, args.toArray(), new Customer());

		return list;
	}

	public Customer find(Integer id){
		String sql = "select cid, custname, custlevel, custsource, custphone, custmobile from t_customer where cid = ?";
		List<Object> args = new ArrayList<>();
		args.add(id);
		Customer customer = jdbcTemplate.queryForObject(sql, args.toArray(), new Customer());

		return customer;
	}

	public Customer create(Customer customer){
		String sql = "insert into t_customer(cid, custname, custlevel, custsource, custphone, custmobile) values(?,?,?,?,?,?)";
		KeyHolder keyHolder =new GeneratedKeyHolder();
		int result = jdbcTemplate.update(new PreparedStatementCreator() {
								@Override
								public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
									PreparedStatement ps = jdbcTemplate.getDataSource()
																		.getConnection()
																		.prepareStatement(sql, new int[]{1,2,3,4,5,6});
									ps.setInt(1, 0);
									ps.setString(2, customer.getCustomerName());
									ps.setString(3, customer.getCustomerLevel());
									ps.setString(4, customer.getCustomerSource());
									ps.setString(5, customer.getCustomerSource());
									ps.setString(6, customer.getCustomerMobile());
									
									return ps;
								}
							}, keyHolder);

		System.out.println("insert result = " + result);
		customer.setCid(keyHolder.getKey().intValue());
		return customer;
	}

	public Customer create2(Customer customer){
		String sql = "insert into t_customer(cid, custname, custlevel, custsource, custphone, custmobile) values(?,?,?,?,?,?)";
		List<Object> args = new ArrayList<>();
		args.add(new Integer(0));
		args.add(new String(customer.getCustomerName()));
		args.add(new String(customer.getCustomerLevel()));
		args.add(new String(customer.getCustomerSource()));
		args.add(new String(customer.getCustomerSource()));
		args.add(new String(customer.getCustomerMobile()));
		int result = jdbcTemplate.update(sql, args.toArray());
		System.out.println("insert result = " + result);
		
		String sqlId = "SELECT LAST_INSERT_ID()";
		Integer id = jdbcTemplate.queryForObject(sqlId, Integer.class);
		customer.setCid(id);

		return customer;
	}

	public Customer update(Integer id, Customer customer){
		String sql = "update t_customer set custname=?, custlevel=?, custsource=?, custphone=?, custmobile=?"
				+ " where cid=?";
		List<Object> args = new ArrayList<>();
		args.add(new String(customer.getCustomerName()));
		args.add(new String(customer.getCustomerLevel()));
		args.add(new String(customer.getCustomerSource()));
		args.add(new String(customer.getCustomerSource()));
		args.add(new String(customer.getCustomerMobile()));
		args.add(id);
		int result = jdbcTemplate.update(sql, args.toArray());
		System.out.println("update result = " + result);

		return customer;
	}


}
