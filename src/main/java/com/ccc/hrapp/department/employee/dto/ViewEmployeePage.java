package com.ccc.hrapp.department.employee.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ViewEmployeePage {
	private int totalPages;

	private long totalElements;

	private List<ViewEmployeeDto> data;
}
