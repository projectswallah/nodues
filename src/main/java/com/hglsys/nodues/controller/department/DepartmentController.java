package com.hglsys.nodues.controller.department;


import com.hglsys.nodues.Dto.ApiResponse;
import com.hglsys.nodues.Dto.PagedResponse;
import com.hglsys.nodues.Dto.departmentDto.DepartmentRequest;
import com.hglsys.nodues.Dto.departmentDto.DepartmentResponse;
import com.hglsys.nodues.Dto.departmentDto.DepartmentUpdateRequest;
import com.hglsys.nodues.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("department")
@PreAuthorize("hasRole('PRINCIPAL')")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@Valid @RequestBody DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.create(request));
    }

    @PutMapping("/edit")
    public ResponseEntity<ApiResponse> update(@Valid @RequestBody DepartmentUpdateRequest request) {
        return ResponseEntity.ok(departmentService.edit(request));
    }

    @DeleteMapping("/inactive")
    public ResponseEntity<ApiResponse> inactive(@RequestParam Long id) {
        return ResponseEntity.ok(departmentService.inactive(id));
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentResponse> fetchByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentService.fetchByDepartmentCode(code));
    }

    @GetMapping("/all")
    public ResponseEntity<PagedResponse<DepartmentResponse>> getAll(@PageableDefault(size = 50) Pageable pageable) {
        PagedResponse<DepartmentResponse> response = departmentService.getAll(pageable);
        if (response.getContent().isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all-active")
    public ResponseEntity<PagedResponse<DepartmentResponse>> getActiveAll(@PageableDefault(size = 20) Pageable pageable) {
        PagedResponse<DepartmentResponse> res = departmentService.getActiveAll(pageable);
        if (res.getContent().isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(res);
    }

}
