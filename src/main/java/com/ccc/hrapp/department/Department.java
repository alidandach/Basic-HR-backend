package com.ccc.hrapp.department;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ccc.hrapp.department.employee.Employee;
import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "department")
@Accessors(chain = true)
public class Department {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private Integer id;


	@Column(name = "department_name", unique = true, nullable = false)
	private String name;

	@MapKey(name = "id")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
	private Map<Integer, Employee> employees;

	public Department() {
		this.employees = new HashMap<>();
	}

	public Department(String name) {
		if (name == null || name.equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "the department name cannot be null or empty");
		this.name = name;
		this.employees = new HashMap<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Department)) return false;
		Department that = (Department) o;
		return getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}
