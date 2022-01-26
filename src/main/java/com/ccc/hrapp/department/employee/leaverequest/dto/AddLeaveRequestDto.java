package com.ccc.hrapp.department.employee.leaverequest.dto;

import java.time.LocalDate;

import com.ccc.hrapp.common.http.annotation.StringValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddLeaveRequestDto {
	@StringValue(isRequired = true)
	private String leaveRequestType;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate from;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate to;

	@StringValue(isRequired = true)
	private String note;
}