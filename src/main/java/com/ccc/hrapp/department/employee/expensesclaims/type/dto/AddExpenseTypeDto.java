package com.ccc.hrapp.department.employee.expensesclaims.type.dto;

import com.ccc.hrapp.common.http.annotation.StringValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddExpenseTypeDto {
	@StringValue(isRequired = true)
	private String name;
}
