package com.peaksoft.SpringSecurityMVCToken.api;

import com.peaksoft.SpringSecurityMVCToken.dto.group.GroupRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.group.GroupResponse;
import com.peaksoft.SpringSecurityMVCToken.dto.group.GroupResponseView;
import com.peaksoft.SpringSecurityMVCToken.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
@Tag(name = "Group controller", description = "A user with role SuperAdmin and Admin can " +
        "create, update, delete and get.")
public class GroupController {

    private final GroupService service;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can create.")
    public GroupResponse createGroup(@RequestBody GroupRequest request) {
        return service.createGroup(request);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can update.")
    public GroupResponse updateGroup(@RequestBody GroupRequest request, @PathVariable Long id) {
        return service.updateGroup(request, id);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can watch.")
    public GroupResponse getByIdGroup(@PathVariable Long id) {
        return service.getByIdGroup(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin')")
    @Operation(summary = "A user with the SuperAdmin role can delete.")
    public GroupResponse deleteGroup(@PathVariable Long id) {
        return service.deleteByIdGroup(id);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can watch.")
    public List<GroupResponse> getAllGroups() {
        return service.getAllGroups();
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can search.")
    public GroupResponseView getSearchAndPagination(@RequestParam(name = "name", required = false)
                                                    String name, @RequestParam int page,
                                                    @RequestParam int size) {
        return service.searchByDate(name, page-1, size);
    }

    @GetMapping("/count")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the SuperAdmin role, Admin role and User role can count.")
    public String countGroups() {
        return "Количество групп: " + service.countGroup();
    }
}
