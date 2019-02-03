package com.nafys.emperp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nafys.emperp.entity.Employee;
import com.nafys.emperp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployees(){
		
		return employeeRepository.findAll();
		
	}

	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	public Employee findById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee Id :"+ id +" Deleted Successfully";
	}

	public Employee findByEmployeeId(String employeeId) {
		Employee employee = employeeRepository.findByEmployeeId(employeeId);
		return employee;
	}
}
