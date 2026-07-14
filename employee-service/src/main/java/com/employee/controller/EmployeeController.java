package com.employee.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeDepartmentResponse;
import com.employee.dto.response.EmployeeResponse;
import com.employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Employee APIs", description = "Operations related to Employee Management")
@Slf4j
@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@Operation(summary = "Create Employee")
	@PostMapping
	public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request) {
		log.info("Creating employee with employeeId={}", request.getEmployeeId());

		EmployeeResponse response = employeeService.createEmployee(request);
		log.info("Employee created successfully with id={}", response.getId());

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Operation(summary = "Get Employee by ID")
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {

		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@Operation(summary = "Get Employee by ID")
	@GetMapping("/employee-id/{employeeId}")
	public ResponseEntity<EmployeeResponse> getEmployeeByEmployeeId(@PathVariable String employeeId) {

		return ResponseEntity.ok(employeeService.getEmployeeByEmployeeId(employeeId));
	}

	@Operation(summary = "Get Employee by Email")
	@GetMapping("/email/{email}")
	public ResponseEntity<EmployeeResponse> getEmployeeByEmail(@PathVariable String email) {

		return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
	}

	@GetMapping
	public ResponseEntity<Page<EmployeeResponse>> getAllEmployees(

			@RequestParam(defaultValue = "0") int page,

			@RequestParam(defaultValue = "10") int size,

			@RequestParam(defaultValue = "id") String sortBy) {

		return ResponseEntity.ok(employeeService.getAllEmployees(page, size, sortBy));
	}

	@Operation(summary = "Update Employee")
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployee(

			@PathVariable Long id,

			@Valid @RequestBody EmployeeRequest request) {

		return ResponseEntity.ok(employeeService.updateEmployee(id, request));
	}

	@Operation(summary = "Delete Employee")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/department")
	public ResponseEntity<EmployeeDepartmentResponse> getEmployeeWithDepartment(
	        @PathVariable Long id) {

	    return ResponseEntity.ok(
	            employeeService.getEmployeeWithDepartment(id));
	}

}