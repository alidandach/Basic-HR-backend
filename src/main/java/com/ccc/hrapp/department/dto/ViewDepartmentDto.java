package com.ccc.hrapp.department.dto;

import com.ccc.hrapp.department.employee.dto.ViewEmployeePage;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ViewDepartmentDto {
	private int id;
	private ViewEmployeePage employees;
}
