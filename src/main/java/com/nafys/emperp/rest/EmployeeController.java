package com.nafys.emperp.rest;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		  
		  employee = employeeService.createEmployee(employee);
	  
		  return new ResponseEntity<Employee>(employee, HttpStatus.OK); 
	  }
	 

	/*@PostMapping("/employees")
	@CrossOrigin
	public ResponseEntity<Void> createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createEmployee(employee);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdEmployee.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}*/

	@PutMapping("/employees")
	@CrossOrigin
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		employee = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	@CrossOrigin
	public Employee getEmployee(@PathVariable Long id) {
		return employeeService.findById(id);
	}

	@GetMapping("/employees")
	@CrossOrigin
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@DeleteMapping("/employees/{id}")
	@CrossOrigin
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		String msg = employeeService.deleteEmployee(id);
		if (msg != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/employees/isEmployeeExistsAndActive/{employeeId}")
	public Employee isEmployeeExists(@PathVariable String employeeId) {
		Employee employee = employeeService.findByEmployeeId(employeeId);
		if (employee != null) {
			return employee;
		}
		return null;
	}

	@GetMapping("/sampleServlet")
	@CrossOrigin
	public String getDate() {
		Date date = new Date();
		return date.toString();
	}
}
