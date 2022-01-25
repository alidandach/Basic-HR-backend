package com.ccc.hrapp.department.employee.expensesclaims.entry;

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
import com.ccc.hrapp.department.employee.expensesclaims.type.ExpenseType;
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
@Table(name = "expense_claim_entry")
public class ExpenseClaimEntry {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private Integer id;

	@Column(name = "expense_date", nullable = false)
	private Date createdDate;

	@Column(name = "expense_total", nullable = false)
	private int total;

	@Column(name = "expense_description", nullable = false)
	private String description;

	@Column(name = "expense_status", nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "expense_type_id")
	private ExpenseType leaveType;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
}
