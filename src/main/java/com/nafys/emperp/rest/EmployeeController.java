package com.nafys.emperp.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nafys.emperp.entity.Employee;
import com.nafys.emperp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employees")
	@CrossOrigin
	public Employee createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);	
	}
	
	@PutMapping("/employees")
	@CrossOrigin
	public Employee updateEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);	
	}
	
	@GetMapping("/employees/{id}")
	@CrossOrigin
	public Employee getEmployee(@PathVariable Long id){
		return employeeService.findById(id);	
	}
	
	@GetMapping("/employees")
	@CrossOrigin
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();	
	}
	
	@DeleteMapping("/employees/{id}")
	@CrossOrigin
	public String deleteEmployee(@PathVariable Long id){
		return employeeService.deleteEmployee(id);	
	}
	
	@GetMapping("/employees/isEmployeeExistsAndActive/{employeeId}")
	public Employee isEmployeeExists(@PathVariable String  employeeId){
		Employee employee = employeeService.findByEmployeeId(employeeId);
		if(employee != null){
			return employee;
		}
		return null;	
	}
	
	@GetMapping("/sampleServlet")
	@CrossOrigin
	public String getDate(){
		Date date = new Date();
		return date.toString();	
	}
}
