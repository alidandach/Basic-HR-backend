package com.ccc.hrapp.department.employee.leave.type.dto;

import com.ccc.hrapp.common.http.annotation.StringValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddLeaveTypeDto {
	@StringValue(isRequired = true)
	private String name;
}
