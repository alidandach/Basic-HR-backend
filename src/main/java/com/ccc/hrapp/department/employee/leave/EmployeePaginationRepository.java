package com.ccc.hrapp.department.employee.leave;

import com.ccc.hrapp.department.Department;
import com.ccc.hrapp.department.employee.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePaginationRepository extends PagingAndSortingRepository<Employee, Integer> {

	Page<Employee> findAllByDepartment(Department department, Pageable pageable);
}
