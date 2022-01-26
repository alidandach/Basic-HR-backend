package com.ccc.hrapp.department.employee.leaverequest.type;

import javax.validation.Valid;

import com.ccc.hrapp.common.http.dto.ClientData;
import com.ccc.hrapp.common.http.dto.ClientResponse;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.employee.leaverequest.type.dto.AddLeaveTypeDto;
import lombok.AllArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/leave-request-type")
public class LeaveRequestTypeController {
	private final LeaveRequestTypeService leaveRequestTypeService;

	/**
	 * Define leave request type
	 *
	 * @param request leave request type data
	 * @return client response
	 */
	@PostMapping
	public ClientResponse<ClientData> defineLeaveRequestType(@Valid @RequestBody AddLeaveTypeDto request) {
		leaveRequestTypeService.addLeaveRequestType(request.getName());
		return new ClientResponse<>(StatusCode.SUCCESS);
	}
}
