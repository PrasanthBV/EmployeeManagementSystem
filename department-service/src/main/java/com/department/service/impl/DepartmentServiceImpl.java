package com.department.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.department.dto.request.DepartmentRequest;
import com.department.dto.response.DepartmentResponse;
import com.department.entity.Department;
import com.department.exception.DepartmentNotFoundException;
import com.department.exception.DuplicateResourceException;
import com.department.mapper.DepartmentMapper;
import com.department.repository.DepartmentRepository;
import com.department.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {

        log.info("Creating department with code={}", request.getDepartmentCode());

        if (departmentRepository.existsByDepartmentCode(request.getDepartmentCode())) {
            throw new DuplicateResourceException("Department Code already exists");
        }

        Department department = departmentMapper.toEntity(request);

        Department savedDepartment = departmentRepository.save(department);

        log.info("Department created successfully with id={}", savedDepartment.getId());

        return departmentMapper.toResponse(savedDepartment);
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found with ID : " + id));

        return departmentMapper.toResponse(department);
    }

    @Override
    public DepartmentResponse getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department not found with Code : " + departmentCode));

        return departmentMapper.toResponse(department);
    }

    @Override
    public Page<DepartmentResponse> getAllDepartments(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return departmentRepository.findAll(pageable)
                .map(departmentMapper::toResponse);
    }

    @Override
    public DepartmentResponse updateDepartment(
            Long id,
            DepartmentRequest request) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found with ID : " + id));

        if (!department.getDepartmentCode().equals(request.getDepartmentCode())
                && departmentRepository.existsByDepartmentCode(request.getDepartmentCode())) {

            throw new DuplicateResourceException("Department Code already exists");
        }

        departmentMapper.updateEntity(department, request);

        Department updatedDepartment = departmentRepository.save(department);

        log.info("Department updated successfully with id={}", updatedDepartment.getId());

        return departmentMapper.toResponse(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found with ID : " + id));

        departmentRepository.delete(department);

        log.info("Department deleted successfully with id={}", id);
    }
}