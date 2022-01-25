package com.ccc.hrapp.department.employee;

import java.util.stream.Collectors;

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.Department;
import com.ccc.hrapp.department.employee.dto.EmployeeDto;
import com.ccc.hrapp.department.employee.dto.ViewEmployeePage;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	private final EmployeePaginationRepository employeePaginationRepository;

	public void addEmployee(Department department, EmployeeDto request) {
		//check if the employee exist
		employeeRepository.findByEmail(request.getEmail())
				.ifPresent(employee -> {
					throw new ApplicationException(StatusCode.DUPLICATE_RECORD, "the employee {} already exist", employee.getId());
				});

		//save the data
		employeeRepository.save(new Employee(department, request));
	}


	public ViewEmployeePage viewPageOfEmployees(Department department, int pageIndex, int pageSize) {
		//fetch the page
		Page<Employee> page = employeePaginationRepository.findAllByDepartment(department, PageRequest.of(pageIndex, pageSize));

		//return the page
		return new ViewEmployeePage().setTotalPages(page.getTotalPages())
				.setTotalElements(page.getTotalElements())
				.setData(page.getContent()
						.stream()
						.map(Employee::view)
						.collect(Collectors.toList()));
	}

	public void updateEmployee(int employeeId, EmployeeDto request) {
		//check if the employee exist
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ApplicationException(StatusCode.RECORD_NOT_FOUND, "employee with id {} not found", employeeId));

		//check if the email is taken by someone
		if (!employee.getEmail().equals(request.getEmail())) {
			employeeRepository.findByEmail(request.getEmail())
					.ifPresent(i -> {
						throw new ApplicationException(StatusCode.DUPLICATE_RECORD, "cannot update email of the employee {} because already exist", request.getName());
					});
		}

		//update the data
		employee.update(request);

		//save the change
		employeeRepository.save(employee);
	}
}
