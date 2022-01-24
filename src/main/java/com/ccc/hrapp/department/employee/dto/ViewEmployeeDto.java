package com.ccc.hrapp.department.employee.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ViewEmployeeDto {
	private int id;

	private String name;

	private String email;

	private String address;
}
