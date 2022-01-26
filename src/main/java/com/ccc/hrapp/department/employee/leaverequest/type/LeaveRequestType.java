package com.ccc.hrapp.department.employee.leaverequest.type;

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

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.employee.leaverequest.LeaveRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "leave_request_type")
public class LeaveRequestType {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private Integer id;

	@Column(name = "leave_request_type_name", unique = true, nullable = false)
	private String name;

	@MapKey(name = "id")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "leaveRequestType")
	private Map<Integer, LeaveRequest> leaves;

	public LeaveRequestType() {
		this.leaves = new HashMap<>();
	}

	public LeaveRequestType(String name) {
		if (name == null || name.equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "the leave request type name cannot be null or empty");
		this.name = name;
		this.leaves = new HashMap<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LeaveRequestType)) return false;
		LeaveRequestType leaveRequestType = (LeaveRequestType) o;
		return Objects.equals(getId(), leaveRequestType.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

}
