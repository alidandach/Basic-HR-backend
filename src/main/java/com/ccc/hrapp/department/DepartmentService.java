package com.ccc.hrapp.department;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {
	private final DepartmentRepository departmentRepository;

	public void addDepartement(String name) {
		departmentRepository.save(new Department(name));
	}
}
