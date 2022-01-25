package com.ccc.hrapp.department.employee.leave.type;

import javax.validation.Valid;

import com.ccc.hrapp.common.http.dto.ClientData;
import com.ccc.hrapp.common.http.dto.ClientResponse;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.employee.leave.type.dto.AddLeaveTypeDto;
import lombok.AllArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/leave-type")
public class LeaveTypeController {
	private final LeaveTypeService leaveTypeService;

	/**
	 * Define leave type
	 *
	 * @param request leave type data
	 * @return client response
	 */
	@PostMapping
	public ClientResponse<ClientData> defineDepartment(@Valid @RequestBody AddLeaveTypeDto request) {
		leaveTypeService.addLeaveType(request.getName());
		return new ClientResponse<>(StatusCode.SUCCESS);
	}
}
