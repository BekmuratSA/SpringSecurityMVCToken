package com.peaksoft.SpringSecurityMVCToken.api;

import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentResponse;
import com.peaksoft.SpringSecurityMVCToken.dto.student.StudentResponseView;
import com.peaksoft.SpringSecurityMVCToken.mappers.student.StudentViewMapper;
import com.peaksoft.SpringSecurityMVCToken.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
@Tag(name = "Student controller", description = "A user with role SuperAdmin and Admin can " +
        "create, update, delete and get.")
public class StudentController {

    private final StudentService service;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can create.")
    public StudentResponse createStudent(@RequestBody StudentRequest request) {
        return service.createStudent(request);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can update.")
    public StudentResponse updateStudent(@RequestBody StudentRequest request, @PathVariable Long id) {
        return service.updateStudent(request, id);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can watch.")
    public StudentResponse getByIdStudent(@PathVariable Long id) {
        return service.getByIdStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin')")
    @Operation(summary = "A user with the SuperAdmin role can delete.")
    public StudentResponse deleteByIdStudent(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role and User role can watch.")
    public List<StudentResponse> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/pagination")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can search.")
    public StudentResponseView getSearchPagination(@RequestParam(name = "name", required = false)
                                                 String name, @RequestParam int page,
                                                   @RequestParam int size) {
        return service.searchAndPagination(name, page-1, size);
    }

    @GetMapping("/count")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can count.")
    public String countStudents() {
        return "Количество студентов: " + service.countStudent() + " студенты.";
    }
}
