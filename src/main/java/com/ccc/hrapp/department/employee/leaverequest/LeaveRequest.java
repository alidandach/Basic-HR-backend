package com.ccc.hrapp.department.employee.leaverequest;

import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.employee.Employee;
import com.ccc.hrapp.department.employee.leaverequest.dto.AddLeaveRequestDto;
import com.ccc.hrapp.department.employee.leaverequest.type.LeaveRequestType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

@Slf4j
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "leave_request")
public class LeaveRequest {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private Integer id;

	@Column(name = "date_from", nullable = false)
	private Date from;

	@Column(name = "date_to", nullable = false)
	private Date to;

	@Column(name = "number_of_days", nullable = false)
	private int numberOfDays;

	@Column(name = "note", nullable = false)
	private String note;

	@ManyToOne
	@JoinColumn(name = "leave_type_id")
	private LeaveRequestType leaveRequestType;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public LeaveRequest(Employee employee, LeaveRequestType leaveRequestType, AddLeaveRequestDto dto) {
		if (dto.getNote() == null || dto.getNote().trim().equals("") || dto.getFrom() == null || dto.getTo() == null)
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "the data cannot be empty or null");

		this.from = Date.from(dto.getFrom().atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.to = Date.from(dto.getTo().atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.numberOfDays = Period.between(dto.getFrom(), dto.getTo()).getDays();
		this.note = dto.getNote();
		this.employee = employee;
		this.leaveRequestType = leaveRequestType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LeaveRequest)) return false;
		LeaveRequest that = (LeaveRequest) o;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
