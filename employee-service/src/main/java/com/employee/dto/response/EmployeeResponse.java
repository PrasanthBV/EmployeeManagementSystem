package com.employee.dto.response;



import java.time.LocalDate;

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
public class EmployeeResponse {

	private Long id;

	private String employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

	private String designation;

	private Double salary;

	private LocalDate joiningDate;

	private String departmentCode;

	private String status;
}