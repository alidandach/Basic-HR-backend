package com.ccc.hrapp.department;

import com.ccc.hrapp.common.http.dto.ApplicationException;
import com.ccc.hrapp.common.http.enums.StatusCode;
import com.ccc.hrapp.department.dto.ViewDepartmentDto;
import com.ccc.hrapp.department.employee.Employee;
import com.ccc.hrapp.department.employee.EmployeeService;
import com.ccc.hrapp.department.employee.dto.EmployeeDto;
import com.ccc.hrapp.department.employee.dto.ViewEmployeePage;
import com.ccc.hrapp.department.employee.leaverequest.LeaveRequestService;
import com.ccc.hrapp.department.employee.leaverequest.dto.AddLeaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DepartmentService {
	private final LeaveRequestService leaveRequestService;

	private final EmployeeService employeeService;

	private final DepartmentRepository departmentRepository;


	public void addDepartment(String name) {
		//check if the department exist
		departmentRepository.findByName(name).ifPresent(s -> {
			throw new ApplicationException(StatusCode.DUPLICATE_RECORD, "the department name {} is duplicate", name);
		});

		//save the data
		departmentRepository.save(new Department(name));

		//log
		log.info("add new department with name  {} ", name);
	}

	public Department get(String name) {
		return departmentRepository.findByName(name)
				.orElseThrow(() -> new ApplicationException(StatusCode.RECORD_NOT_FOUND, "the department {} not found", name));
	}

	public ViewDepartmentDto getDepartmentWithEmployeesPaginated(String departmentName, int pageIndex, int pageSize) {
		//check if the department exist
		Department department = get(departmentName);

		//get the page
		ViewEmployeePage employeePage = employeeService.viewPageOfEmployees(department, pageIndex, pageSize);

		//return the data
		return new ViewDepartmentDto().setId(department.getId()).setEmployees(employeePage);
	}

	public void assignEmployeeToDepartment(String departmentName, EmployeeDto request) {
		//add the employee
		employeeService.addEmployee(get(departmentName), request);

		//log
		log.info("add a new employee {} to {} department", request.getName(), departmentName);
	}

	public void updateEmployeeExistInDepartment(String departmentName, int employeeId, EmployeeDto request) {
		//check if the department exist
		Department department = get(departmentName);

		//get the employee
		Employee employee = department.getEmployee(employeeId);

		//update the data
		employeeService.updateEmployee(employee, request);

		//log
		log.info("the employee {} update his information", request.getName());
	}

	public void submitLeaveRequest(String departmentName, int employeeId, AddLeaveRequestDto request) {
		//check if the department exist
		Department department = get(departmentName);

		//get the employee
		Employee employee = department.getEmployee(employeeId);

		//add the request
		leaveRequestService.submitLeaveRequest(employee, request);
	}
}
