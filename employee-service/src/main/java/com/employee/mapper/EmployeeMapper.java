package com.employee.mapper;

import com.employee.dto.request.EmployeeRequest;
import com.employee.dto.response.EmployeeResponse;
import com.employee.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

	/**
	 * Convert EmployeeRequest DTO to Employee Entity
	 */
	public Employee toEntity(EmployeeRequest request) {

		if (request == null) {
			return null;
		}

		return Employee.builder().employeeId(request.getEmployeeId()).firstName(request.getFirstName())
				.lastName(request.getLastName()).email(request.getEmail()).mobile(request.getMobile())
				.designation(request.getDesignation()).salary(request.getSalary()).joiningDate(request.getJoiningDate())
				.departmentCode(request.getDepartmentCode()).status(request.getStatus()).build();
	}

	/**
	 * Convert Employee Entity to EmployeeResponse DTO
	 */
	public EmployeeResponse toResponse(Employee employee) {

		if (employee == null) {
			return null;
		}

		return EmployeeResponse.builder().id(employee.getId()).employeeId(employee.getEmployeeId())
				.firstName(employee.getFirstName()).lastName(employee.getLastName()).email(employee.getEmail())
				.mobile(employee.getMobile()).designation(employee.getDesignation()).salary(employee.getSalary())
				.joiningDate(employee.getJoiningDate()).departmentCode(employee.getDepartmentCode())
				.status(employee.getStatus()).build();
	}

	/**
	 * Update an existing Employee entity from EmployeeRequest. Useful for PUT
	 * operations.
	 */
	public void updateEntity(Employee employee, EmployeeRequest request) {

		employee.setEmployeeId(request.getEmployeeId());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setEmail(request.getEmail());
		employee.setMobile(request.getMobile());
		employee.setDesignation(request.getDesignation());
		employee.setSalary(request.getSalary());
		employee.setJoiningDate(request.getJoiningDate());
		employee.setDepartmentCode(request.getDepartmentCode());
		employee.setStatus(request.getStatus());
	}
}