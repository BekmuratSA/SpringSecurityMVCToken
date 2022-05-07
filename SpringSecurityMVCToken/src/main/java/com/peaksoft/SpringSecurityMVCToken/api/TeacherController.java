package com.peaksoft.SpringSecurityMVCToken.api;

import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.teacher.TeacherResponse;
import com.peaksoft.SpringSecurityMVCToken.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
@Tag(name = "Teacher controller", description = "A user with role SuperAdmin and Admin can " +
        "create, update, delete and get.")
public class TeacherController {

    private final TeacherService service;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can create.")
    public TeacherResponse createTeacher(@RequestBody TeacherRequest request) {
        return service.createTeacher(request);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can update.")
    public TeacherResponse updateTeacher(@RequestBody TeacherRequest request, @PathVariable Long id) {
        return service.updateTeacher(request, id);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role and User role can watch.")
    public TeacherResponse getByIdTeacher(@PathVariable Long id) {
        return service.getByIdTeacher(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin')")
    @Operation(summary = "A user with the SuperAdmin role can delete.")
    public TeacherResponse deleteByIdTeacher(@PathVariable Long id) {
        return service.deleteByIdTeacher(id);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role and user role can watch.")
    public List<TeacherResponse> getAllTeachers() {
        return service.getAllTeachers();
    }
}
