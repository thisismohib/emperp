package com.nafys.emperp.dto;

import com.nafys.emperp.entity.Employee;

public class RequestDTO {

	private Employee employee;
	private Integer otp;
	private String mac;
	private String requestedDate;
	private String mobileMake;
	private String employeeId;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getMobileMake() {
		return mobileMake;
	}

	public void setMobileMake(String mobileMake) {
		this.mobileMake = mobileMake;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
