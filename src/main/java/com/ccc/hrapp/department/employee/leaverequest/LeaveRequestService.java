package com.ccc.hrapp.department.employee.leaverequest;

import com.ccc.hrapp.department.employee.Employee;
import com.ccc.hrapp.department.employee.leaverequest.dto.AddLeaveRequestDto;
import com.ccc.hrapp.department.employee.leaverequest.type.LeaveRequestType;
import com.ccc.hrapp.department.employee.leaverequest.type.LeaveRequestTypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LeaveRequestService {
	private final LeaveRequestRepository leaveRequestRepository;

	private final LeaveRequestTypeService leaveRequestTypeService;

	public void submitLeaveRequest(Employee employee, AddLeaveRequestDto request) {
		// check the leave request type
		LeaveRequestType leaveRequestType = leaveRequestTypeService.get(request.getLeaveRequestType());

		//add new request
		leaveRequestRepository.save(new LeaveRequest(employee, leaveRequestType, request));

		//log
		log.info("the employee {} add a new request", employee.getName());
	}
}
