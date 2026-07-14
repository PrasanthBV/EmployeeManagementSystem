package com.department.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class DepartmentRequest {

    @NotBlank(message = "Department Code is required")
    private String departmentCode;

    @NotBlank(message = "Department Name is required")
    private String departmentName;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Head Of Department is required")
    private String headOfDepartment;

    @NotBlank(message = "Status is required")
    private String status;
}