package com.ccc.hrapp.department.employee.dto;

import com.ccc.hrapp.common.http.annotation.StringValue;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class EmployeeDto {
	@StringValue(isRequired = true)
	private String name;

	@StringValue(isRequired = true)
	private String email;

	@StringValue(isRequired = true)
	private String address;
}
