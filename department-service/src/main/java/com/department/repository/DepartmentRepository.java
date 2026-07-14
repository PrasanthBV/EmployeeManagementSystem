package com.department.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByDepartmentCode(String departmentCode);

    boolean existsByDepartmentCode(String departmentCode);

}