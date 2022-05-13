package com.peaksoft.SpringSecurityMVCToken.service;

import com.peaksoft.SpringSecurityMVCToken.dto.company.CompanyRequest;
import com.peaksoft.SpringSecurityMVCToken.dto.company.CompanyResponse;
import com.peaksoft.SpringSecurityMVCToken.mappers.company.CompanyEditMapper;
import com.peaksoft.SpringSecurityMVCToken.mappers.company.CompanyViewMapper;
import com.peaksoft.SpringSecurityMVCToken.models.Company;
import com.peaksoft.SpringSecurityMVCToken.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyEditMapper editMapper;
    private final CompanyViewMapper viewMapper;

    public CompanyResponse createCompany(CompanyRequest request) {
        Company company = editMapper.createCompany(request);
        repository.save(company);
        return viewMapper.viewCompany(company);
    }

    public CompanyResponse updateCompany(CompanyRequest request, Long id) {
        Company company = repository.getById(id);
        editMapper.updateCompany(company, request);
        return viewMapper.viewCompany(repository.save(company));
    }

    public CompanyResponse getByIdCompany(Long id) {
        Company company = repository.getById(id);
        return viewMapper.viewCompany(company);
    }

    public List<CompanyResponse> getAllCompanies() {
        return viewMapper.viewCompanies(repository.findAll());
    }

    public CompanyResponse deleteByIdCompany(Long id) {
        Company company = repository.getById(id);
        repository.deleteById(id);
        return viewMapper.viewCompany(company);
    }

    public Long countCompany() {
        return repository.count();
    }
}
