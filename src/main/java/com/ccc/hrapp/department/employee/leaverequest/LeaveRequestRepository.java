package com.ccc.hrapp.department.employee.leaverequest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends CrudRepository<LeaveRequest, Integer> {
}
