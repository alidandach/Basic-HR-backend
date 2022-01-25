package com.ccc.hrapp.department;

import javax.validation.Valid;

import com.ccc.hrapp.common.http.dto.ClientData;
import com.ccc.hrapp.common.http.dto.ClientResponse;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.dto.AddDepartmentDto;
import com.ccc.hrapp.department.dto.ViewDepartmentDto;
import com.ccc.hrapp.department.employee.dto.EmployeeDto;
import lombok.AllArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService departmentService;

	/**
	 * Define department
	 *
	 * @param request department data
	 * @return client response
	 */
	@PostMapping
	public ClientResponse<ClientData> defineDepartment(@Valid @RequestBody AddDepartmentDto request) {
		departmentService.addDepartment(request.getName());
		return new ClientResponse<>(StatusCode.SUCCESS);
	}

	/**
	 * Add employees and assign them to departments
	 *
	 * @param name department name
	 * @param request employee data
	 * @return client response
	 */
	@PostMapping("/{name}/employee")
	public ClientResponse<ClientData> addEmployeesAndAssignThemToDepartments(@PathVariable String name, @Valid @RequestBody EmployeeDto request) {
		departmentService.assignEmployeeToDepartment(name, request);
		return new ClientResponse<>(StatusCode.SUCCESS);
	}

	/**
	 * List employees by department
	 *
	 * @param name department name
	 * @param pageIndex page index of employees
	 * @param pageSize number of employees in each fetch
	 * @return client response
	 */
	@GetMapping("/{name}/employee")
	public ViewDepartmentDto listEmployeesByDepartment(@PathVariable String name, @RequestParam(name = "pageIndex") Integer pageIndex,
			@RequestParam(name = "pageSize") Integer pageSize) {

		return departmentService.getDepartmentWithEmployeesPaginated(name, pageIndex, pageSize);
	}

	/**
	 * Update employee
	 *
	 * @param name department name
	 * @param id employee id
	 * @param request data to be updated
	 * @return client response
	 */
	@PutMapping("/{name}/employee/{id}")
	public ClientResponse<ClientData> updateEmployeesExistInDepartment(@PathVariable(name = "name") String name,
			@PathVariable(name = "id") int id, @Valid @RequestBody EmployeeDto request) {
		departmentService.updateEmployeeExistInDepartment(name, id, request);
		return new ClientResponse<>(StatusCode.SUCCESS);
	}


}
