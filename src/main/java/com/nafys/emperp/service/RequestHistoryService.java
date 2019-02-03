package com.nafys.emperp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nafys.emperp.dto.RequestDTO;
import com.nafys.emperp.entity.Employee;
import com.nafys.emperp.entity.RequestHistory;
import com.nafys.emperp.repository.EmployeeRepository;
import com.nafys.emperp.repository.RequestHistoryRepository;
import com.nafys.emperp.util.Constants;



@Service
public class RequestHistoryService {

	@Autowired
	private RequestHistoryRepository requestHistoryRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<RequestHistory> getRequestHistorys(){
		return requestHistoryRepository.findAll();
	}

	public RequestHistory createRequestHistory(RequestHistory requestHistory) {
		return requestHistoryRepository.save(requestHistory);
	}

	public RequestHistory findById(Long id) {
		Optional<RequestHistory> requestHistory = requestHistoryRepository.findById(id);
		if(requestHistory.isPresent()) {
			return requestHistory.get();
		}
		return null;
	}

	public Long deleteRequestHistory(Long id) {
		requestHistoryRepository.deleteById(id);
		return id;
	}

	public RequestHistory getOtp(RequestHistory requestHistory) {
		
		RequestHistory requestHistoryDB = requestHistoryRepository
				.findByEmployeeIdAndOtpStatusAndRequestStatus(requestHistory.getEmployeeId(), 
						Constants.OTP_INACTIVE, Constants.PENDING);
		if(requestHistoryDB == null) {
			requestHistory.setOtp(generateOTP());
			requestHistory.setOtpStatus(Constants.OTP_ACTIVE);
			requestHistory.setRequestStatus(Constants.PENDING);
			requestHistory = requestHistoryRepository.save(requestHistory);
		}else {
			return requestHistoryDB;
		}
		
		return requestHistory;
	}
	
	public static int generateOTP() {
		int randomPin   =(int)(Math.random()*9000)+1000;
		int otp  = randomPin;
		//return otp;
		return 1234;
	}

	public Employee confirmOtp(RequestHistory requestHistory) {
		Employee employee = new Employee();
		RequestHistory requestHistoryDB = requestHistoryRepository
				.findByEmployeeIdAndOtpStatusAndOtp(requestHistory.getEmployeeId(), Constants.OTP_ACTIVE, requestHistory.getOtp());
		if(requestHistoryDB == null) {
			//invalid otp
		}else {
			requestHistoryDB.setOtpStatus(Constants.OTP_INACTIVE);
			requestHistoryRepository.save(requestHistoryDB);
			employee = employeeRepository.findByEmployeeId(requestHistory.getEmployeeId());
		}
		
		return employee;
	}

	public List<RequestDTO> getRequests(Integer requestStatus, Integer otpStatus) {
		List<RequestDTO> requests = new ArrayList<RequestDTO>();
		
		List<RequestHistory> requestHistorys = requestHistoryRepository
				.findByRequestStatusAndOtpStatus(requestStatus, otpStatus);
		
		for(RequestHistory rh : requestHistorys) {
			RequestDTO request = new RequestDTO();
			request.setEmployee(employeeRepository.findByEmployeeId(rh.getEmployeeId()));
			request.setMac(rh.getMac());
			request.setMobileMake(rh.getMobileMake());
			request.setRequestedDate(rh.getRequestedDate());
			requests.add(request);
		}
		
		return requests;
	}

	public Employee processRequest(String employeeId, Integer requestStatus) {
		RequestHistory requestHistory = requestHistoryRepository
				.findByEmployeeIdAndOtpStatusAndRequestStatus(employeeId, Constants.OTP_INACTIVE, Constants.PENDING);
		
		requestHistory.setRequestStatus(requestStatus);
		requestHistoryRepository.save(requestHistory);
		
		Employee employee = employeeRepository.findByEmployeeId(employeeId);
		employee.setApproved(requestStatus);
		employeeRepository.save(employee);
		
		return employee;
	}
	
	

}
