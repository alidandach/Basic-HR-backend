package com.ccc.hrapp.department.dto;

import com.ccc.hrapp.common.http.annotation.StringValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddDepartmentDto {

	@StringValue(isRequired = true)
	private String name;
}
