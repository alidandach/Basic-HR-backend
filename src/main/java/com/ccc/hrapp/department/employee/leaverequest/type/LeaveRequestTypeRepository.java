package com.ccc.hrapp.department.employee.leaverequest.type;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestTypeRepository extends CrudRepository<LeaveRequestType, Integer> {
	Optional<LeaveRequestType> findByName(String name);
}
