package com.nafys.emperp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nafys.emperp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeId(String employeeId);

}
