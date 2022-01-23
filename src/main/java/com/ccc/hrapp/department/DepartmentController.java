package com.ccc.hrapp.department;

import lombok.AllArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService departmentService;

	@PutMapping("/add")
	public String add() {
		return "PUT";
	}

	@GetMapping("/{name}")
	public String dd(@PathVariable String name) {
		return name;
	}
}
