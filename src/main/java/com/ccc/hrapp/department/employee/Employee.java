package com.ccc.hrapp.department.employee;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccc.hrapp.department.Department;
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
