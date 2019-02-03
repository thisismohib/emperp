package com.nafys.emperp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RequestHistory {

	@Id
	@GeneratedValue
	private Long id;
	private Integer otp;
	private String mac;
	private String requestedDate;
	private String mobileMake;
	private int otpStatus;
	private String employeeId;
	private int requestStatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getOtpStatus() {
		return otpStatus;
	}
	public void setOtpStatus(int otpStatus) {
		this.otpStatus = otpStatus;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(int requestStatus) {
		this.requestStatus = requestStatus;
	}
}
