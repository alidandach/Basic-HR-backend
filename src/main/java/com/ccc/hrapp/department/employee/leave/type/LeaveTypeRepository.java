package com.ccc.hrapp.department.employee.leave.type;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends CrudRepository<LeaveType, Integer> {
	Optional<LeaveType> findByName(String name);
}
