package com.ccc.hrapp.department.employee.leave.type;

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LeaveTypeService {

	private final LeaveTypeRepository leaveTypeRepository;

	public void addLeaveType(String name) {
		//check if the leave type exist
		leaveTypeRepository.findByName(name).ifPresent(s -> {
			throw new ApplicationException(StatusCode.DUPLICATE_RECORD, "the expense type name {} is duplicate", name);
		});

		//save the data
		leaveTypeRepository.save(new LeaveType(name));

		//log
		log.info("add new leave type with name  {} ", name);
	}
}
