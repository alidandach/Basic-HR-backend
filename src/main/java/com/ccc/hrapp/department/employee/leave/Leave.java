package com.ccc.hrapp.department.employee.leave;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccc.hrapp.department.employee.Employee;
import com.ccc.hrapp.department.employee.leave.type.LeaveType;
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
@Table(name = "leave")
public class Leave {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private Integer id;

	@Column(name = "date_from", nullable = false)
	private Date createdDate;

	@Column(name = "date_to", nullable = false)
	private Date updatedDate;

	@Column(name = "number_of_days", nullable = false)
	private int numberOfDays;

	@Column(name = "note", nullable = false)
	private String note;

	@ManyToOne
	@JoinColumn(name = "leave_type_id")
	private LeaveType leaveType;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
