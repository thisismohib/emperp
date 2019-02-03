package com.nafys.emperp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nafys.emperp.entity.RequestHistory;

public interface RequestHistoryRepository extends JpaRepository<RequestHistory, Long> {

	RequestHistory findByEmployeeIdAndOtpStatusAndOtp(String employeeId, int otpStatus, Integer otp);

	List<RequestHistory> findByRequestStatusAndOtpStatus(Integer requestStatus, int otpStatus);
	
	RequestHistory findByEmployeeIdAndOtpStatusAndRequestStatus(String employeeId,
							Integer otpStatus, Integer requestStatus);


}
