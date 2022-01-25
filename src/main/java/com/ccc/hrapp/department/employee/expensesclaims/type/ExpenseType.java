package com.ccc.hrapp.department.employee.expensesclaims.type;

import java.util.HashMap;
import java.util.Map;

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
import com.ccc.hrapp.department.employee.expensesclaims.entry.ExpenseClaimEntry;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

@Slf4j
@Getter
@Setter
@Entity
@Table(name = "expense_type")
public class ExpenseType {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private Integer id;

	@Column(name = "expense_type_name", unique = true, nullable = false)
	private String name;

	@MapKey(name = "id")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "leaveType")
	private Map<Integer, ExpenseClaimEntry> expenseClaimEntries;

	public ExpenseType() {
		this.expenseClaimEntries = new HashMap<>();
	}

	public ExpenseType(String name) {
		if (name == null || name.equals(""))
			throw new ApplicationException(StatusCode.ILLEGAL_OPERATION, "the expense type name cannot be null or empty");
		this.name = name;
		this.expenseClaimEntries = new HashMap<>();
	}
}
