package com.department.controller;

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

import com.department.dto.request.DepartmentRequest;
import com.department.dto.response.DepartmentResponse;
import com.department.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Tag(
        name = "Department APIs",
        description = "Department Management REST APIs"
)
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(summary = "Create Department")
    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(
            @Valid @RequestBody DepartmentRequest request) {

        DepartmentResponse response =
                departmentService.createDepartment(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(summary = "Get Department By Id")
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                departmentService.getDepartmentById(id));
    }

    @Operation(summary = "Get Department By Code")
    @GetMapping("/code/{departmentCode}")
    public ResponseEntity<DepartmentResponse> getDepartmentByCode(
            @PathVariable String departmentCode) {

        return ResponseEntity.ok(
                departmentService.getDepartmentByCode(departmentCode));
    }

    @Operation(summary = "Get All Departments")
    @GetMapping
    public ResponseEntity<Page<DepartmentResponse>> getAllDepartments(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size,

            @RequestParam(defaultValue = "id") String sortBy) {

        return ResponseEntity.ok(
                departmentService.getAllDepartments(page, size, sortBy));
    }

    @Operation(summary = "Update Department")
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(

            @PathVariable Long id,

            @Valid @RequestBody DepartmentRequest request) {

        return ResponseEntity.ok(
                departmentService.updateDepartment(id, request));
    }

    @Operation(summary = "Delete Department")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(
            @PathVariable Long id) {

        departmentService.deleteDepartment(id);

        return ResponseEntity.noContent().build();
    }
}