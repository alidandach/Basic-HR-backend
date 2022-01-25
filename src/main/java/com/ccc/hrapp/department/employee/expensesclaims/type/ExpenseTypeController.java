package com.ccc.hrapp.department.employee.expensesclaims.type;

import javax.validation.Valid;

import com.ccc.hrapp.common.http.dto.ClientData;
import com.ccc.hrapp.common.http.dto.ClientResponse;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.employee.expensesclaims.type.dto.AddExpenseTypeDto;
import lombok.AllArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/expense-type")
public class ExpenseTypeController {
	private final ExpenseTypeService expenseTypeService;

	/**
	 * Define expense type
	 *
	 * @param request leave type data
	 * @return client response
	 */
	@PostMapping
	public ClientResponse<ClientData> defineDepartment(@Valid @RequestBody AddExpenseTypeDto request) {
		expenseTypeService.addExpenseType(request.getName());
		return new ClientResponse<>(StatusCode.SUCCESS);
	}
}
