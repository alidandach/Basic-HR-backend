package com.ccc.hrapp.department.employee.expensesclaims.type;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeRepository extends CrudRepository<ExpenseType, Integer> {
	Optional<ExpenseType> findByName(String name);
}
