package com.stitec.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stitec.springboot.thymeleafdemo.entity.Employee;


@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	private List<Employee> theEmployees;
	
	
	@PostConstruct
	private void loadData() {
		Employee emp1 = new Employee(1, "sali", "gari", "sali@gmail.com");
		Employee emp2 = new Employee(2, "zarli", "folit", "zarli@gmail.com");
		Employee emp3 = new Employee(3, "poit", "court", "poit@gmail.com");
		
		theEmployees = new ArrayList<Employee>();
		
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		
	
	}
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
		
		
		
	}
	
}
