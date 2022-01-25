package com.ccc.hrapp.department.employee.expensesclaims.type;

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ExpenseTypeService {
	private final ExpenseTypeRepository expenseTypeRepository;

	public void addExpenseType(String name) {
		//check if the expense type exist
		expenseTypeRepository.findByName(name).ifPresent(s -> {
			throw new ApplicationException(StatusCode.DUPLICATE_RECORD, "the expense type name {} is duplicate", name);
		});

		//save the data
		expenseTypeRepository.save(new ExpenseType(name));

		//log
		log.info("add a new expense type with name  {} ", name);
	}
}
