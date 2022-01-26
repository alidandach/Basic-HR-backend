package com.ccc.hrapp.department.employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.Department;
import com.ccc.hrapp.department.employee.dto.EmployeeDto;
import com.ccc.hrapp.department.employee.dto.ViewEmployeeDto;
import com.ccc.hrapp.department.employee.leaverequest.LeaveRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

@Slf4j
@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "employee")
public class Employee implements Comparable<Employee> {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private Integer id;

	@Column(name = "employee_name", nullable = false)
	private String name;

	@Column(name = "employee_email", unique = true, nullable = false)
	private String email;

	@Column(name = "employee_address", nullable = false)
	private String address;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@MapKey(name = "id")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Map<Integer, LeaveRequest> leaveRequests;

	public Employee() {
		this.leaveRequests = new HashMap<>();
	}

	public Employee(Department department, EmployeeDto dto) {
		if (dto.getName() == null || dto.getEmail() == null || dto.getAddress() == null)
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "the employee data cannot be null");


		if (dto.getName().trim().equals("") || dto.getEmail().trim().equals("") || dto.getAddress().trim().equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "the employee data cannot be empty");

		this.name = dto.getName();
		this.email = dto.getEmail();
		this.address = dto.getAddress();
		this.department = department;
		this.leaveRequests = new HashMap<>();
	}

	public ViewEmployeeDto view() {
		return new ViewEmployeeDto()
				.setId(id)
				.setName(name)
				.setEmail(email)
				.setAddress(address);
	}

	public void update(EmployeeDto dto) {
		if (dto.getName() != null && dto.getName().trim().equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "cannot update employee name to empty");

		if (dto.getEmail() != null && dto.getEmail().trim().equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "cannot update employee email to empty");

		if (dto.getAddress() != null && dto.getAddress().trim().equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "cannot update employee address to empty");

		this.name = dto.getName();
		this.email = dto.getEmail();
		this.address = dto.getAddress();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee)) return false;
		Employee employee = (Employee) o;
		return getId().equals(employee.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public int compareTo(Employee employee) {
		return email.compareTo(employee.getEmail());
	}
}
