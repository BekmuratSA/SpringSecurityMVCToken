package com.peaksoft.SpringSecurityMVCToken.api;

import com.peaksoft.SpringSecurityMVCToken.dto.company.CompanyRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.company.CompanyResponse;
import com.peaksoft.SpringSecurityMVCToken.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
@Tag(name = "Company controller", description = "A user with role SuperAdmin and Admin can " +
        "create, update, delete and get.")
public class CompanyController {

    private final CompanyService service;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can create.")
    public CompanyResponse createCompany(@RequestBody CompanyRequest request) {
        return service.createCompany(request);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin')")
    @Operation(summary = "A user with the SuperAdmin role and Admin role can update.")
    public CompanyResponse updateCompany(@RequestBody CompanyRequest request, @PathVariable Long id) {
        return service.updateCompany(request, id);
    }

    @GetMapping("/getById/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the User role can watch.")
    public CompanyResponse getByIdCompany(@PathVariable Long id) {
        return service.getByIdCompany(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('SuperAdmin')")
    @Operation(summary = "A user with the SuperAdmin role can delete.")
    public CompanyResponse deleteByIdCompany(@PathVariable Long id) {
        return service.deleteByIdCompany(id);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('SuperAdmin', 'Admin', 'User')")
    @Operation(summary = "A user with the User role can watch.")
    public List<CompanyResponse> getAllCompanies() {
        return service.getAllCompanies();
    }
}
