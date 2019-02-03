package com.nafys.emperp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nafys.emperp.dto.RequestDTO;
import com.nafys.emperp.entity.Employee;
import com.nafys.emperp.entity.RequestHistory;
import com.nafys.emperp.service.RequestHistoryService;

@RestController
@RequestMapping("/api")
public class RequestHistorysController {

	@Autowired
	private RequestHistoryService requestHistoryService;

	@PostMapping("/requestHistorys")
	public RequestHistory createRequestHistory(@RequestBody RequestHistory requestHistory) {
		return requestHistoryService.createRequestHistory(requestHistory);
	}

	@PutMapping("/requestHistorys")
	public RequestHistory updateRequestHistory(@RequestBody RequestHistory requestHistory) {
		return requestHistoryService.createRequestHistory(requestHistory);
	}

	@GetMapping("/requestHistorys/{id}")
	public RequestHistory getRequestHistory(@PathVariable Long id) {
		return requestHistoryService.findById(id);
	}

	@GetMapping("/requestHistorys")
	public List<RequestHistory> getRequestHistorys() {
		return requestHistoryService.getRequestHistorys();
	}

	@DeleteMapping("/requestHistorys/{id}")
	public Long deleteRequestHistory(@PathVariable Long id) {
		return requestHistoryService.deleteRequestHistory(id);
	}

	@PostMapping("/requestHistorys/getOtp")
	public RequestHistory getOtp(@RequestBody RequestHistory requestHistory) {
		return requestHistoryService.getOtp(requestHistory);
	}

	@PostMapping("/requestHistorys/confirmOtp")
	public Employee confirmOtp(@RequestBody RequestHistory requestHistory) {
		return requestHistoryService.confirmOtp(requestHistory);
	}

	@GetMapping("/requestHistorys/getRequests/{requestStatus}/{otpStatus}")
	public List<RequestDTO> getRequests(@PathVariable Integer requestStatus, @PathVariable Integer otpStatus) {
		return requestHistoryService.getRequests(requestStatus, otpStatus);
	}
	
	@GetMapping("/requestHistorys/processRequest/{employeeId}/{requestStatus}")
	public Employee processRequest(@PathVariable String employeeId, @PathVariable Integer requestStatus) {
		return requestHistoryService.processRequest(employeeId, requestStatus);
	}
}
