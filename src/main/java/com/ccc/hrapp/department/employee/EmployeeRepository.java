package com.ccc.hrapp.department.employee;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	Optional<Employee> findByEmail(String email);
}
