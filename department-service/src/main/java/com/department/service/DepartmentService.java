package com.department.service;

import org.springframework.data.domain.Page;

import com.department.dto.request.DepartmentRequest;
import com.department.dto.response.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse createDepartment(DepartmentRequest request);

    DepartmentResponse getDepartmentById(Long id);

    DepartmentResponse getDepartmentByCode(String departmentCode);

    Page<DepartmentResponse> getAllDepartments(
            int page,
            int size,
            String sortBy);

    DepartmentResponse updateDepartment(
            Long id,
            DepartmentRequest request);

    void deleteDepartment(Long id);
}