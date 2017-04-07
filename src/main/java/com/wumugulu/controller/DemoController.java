package com.wumugulu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/getAll")
	@ResponseBody
	public ResponseEntity<Object> getAll(){
		String sql = "select * from t_customer";
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
		return ResponseEntity.status(HttpStatus.OK).body(mapList);
	}

	@GetMapping("/getOne/{id}")
	@ResponseBody
	public ResponseEntity<Object> getOne(@PathVariable("id")Integer id){
		String sql = "select * from t_customer where cid = ?";
		Map<String, Object> object = jdbcTemplate.queryForMap(sql, id);
		return ResponseEntity.status(HttpStatus.OK).body(object);
	}

}
