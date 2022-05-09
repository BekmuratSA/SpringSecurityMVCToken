package com.peaksoft.SpringSecurityMVCToken.api;

import com.peaksoft.SpringSecurityMVCToken.dto.course.CourseRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.course.CourseResponse;
import com.peaksoft.SpringSecurityMVCToken.dto.course.CourseResponseView;
import com.peaksoft.SpringSecurityMVCToken.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
@Tag(name = "Course controller", description = "A user with role SuperAdmin and Admin can " +
        "create, update, delete and get.")
public class CourseController {

    private final CourseService service;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can create.")
    public CourseResponse createCourse(@RequestBody CourseRequest request) {
        return service.createCourse(request);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can update.")
    public CourseResponse updateCourse(@RequestBody CourseRequest request, @PathVariable Long id) {
        return service.updateCourse(request, id);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User can watch.")
    public CourseResponse getByIdCourse(@PathVariable Long id) {
        return service.getByIdCourse(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin')")
    @Operation(summary = "A user with the SuperAdmin role can delete.")
    public CourseResponse deleteByIdCourse(@PathVariable Long id) {
        return service.deleteByIdCourse(id);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role can and User can watch")
    public List<CourseResponse> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can search.")
    public CourseResponseView getSearchPagination(@RequestParam(name = "name", required = false)
                                                    String name, @RequestParam int page,
                                                                @RequestParam int size) {
        return service.searchAndPaginationCourse(name, page-1, size);
    }

    @GetMapping("/count")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can count")
    public String countCourses() {
        return "Количество курсов: " + service.countCourse();
    }
}
