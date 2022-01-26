package com.ccc.hrapp.department.employee.leaverequest.type;

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LeaveRequestTypeService {

	private final LeaveRequestTypeRepository leaveRequestTypeRepository;

	public void addLeaveRequestType(String name) {
		//check if the leave type exist
		leaveRequestTypeRepository.findByName(name).ifPresent(s -> {
			throw new ApplicationException(StatusCode.DUPLICATE_RECORD, "the leave request type {} is duplicate", name);
		});

		//save the data
		leaveRequestTypeRepository.save(new LeaveRequestType(name));

		//log
		log.info("add new leave type with name  {} ", name);
	}

	public LeaveRequestType get(String name) {
		if (name == null || name.trim().equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "the leave request type cannot be empty or null");

		return leaveRequestTypeRepository.findByName(name)
				.orElseThrow(() -> new ApplicationException(StatusCode.RECORD_NOT_FOUND, "the leave request type {} not found", name));
	}
}
