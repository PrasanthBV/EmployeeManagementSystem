package com.employee.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequest {

	@NotBlank(message = "Employee Id is required")
	private String employeeId;

	@NotBlank(message = "First Name is required")
	private String firstName;

	private String lastName;

	@Email(message = "Invalid Email")
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Mobile Number is required")
	private String mobile;

	@NotBlank(message = "Designation is required")
	private String designation;

	@Positive(message = "Salary must be greater than zero")
	@NotNull(message = "Salary is required")
	private Double salary;

	@NotNull(message = "Joining Date is required")
	private LocalDate joiningDate;

	@NotBlank(message = "Department Code is required")
	private String departmentCode;

	@NotBlank(message = "Status is required")
	private String status;
}