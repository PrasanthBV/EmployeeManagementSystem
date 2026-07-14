package com.department.mapper;

import org.springframework.stereotype.Component;

import com.department.dto.request.DepartmentRequest;
import com.department.dto.response.DepartmentResponse;
import com.department.entity.Department;

@Component
public class DepartmentMapper {

    public Department toEntity(DepartmentRequest request) {

        if (request == null) {
            return null;
        }

        return Department.builder()
                .departmentCode(request.getDepartmentCode())
                .departmentName(request.getDepartmentName())
                .location(request.getLocation())
                .headOfDepartment(request.getHeadOfDepartment())
                .status(request.getStatus())
                .build();
    }

    public DepartmentResponse toResponse(Department department) {

        if (department == null) {
            return null;
        }

        return DepartmentResponse.builder()
                .id(department.getId())
                .departmentCode(department.getDepartmentCode())
                .departmentName(department.getDepartmentName())
                .location(department.getLocation())
                .headOfDepartment(department.getHeadOfDepartment())
                .status(department.getStatus())
                .build();
    }

    public void updateEntity(Department department,
                             DepartmentRequest request) {

        department.setDepartmentCode(request.getDepartmentCode());
        department.setDepartmentName(request.getDepartmentName());
        department.setLocation(request.getLocation());
        department.setHeadOfDepartment(request.getHeadOfDepartment());
        department.setStatus(request.getStatus());
    }
}