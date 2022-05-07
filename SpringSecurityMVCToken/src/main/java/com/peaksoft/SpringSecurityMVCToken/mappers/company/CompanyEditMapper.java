package com.peaksoft.SpringSecurityMVCToken.mappers.company;

import com.peaksoft.SpringSecurityMVCToken.dto.company.CompanyRequest;
import com.peaksoft.SpringSecurityMVCToken.models.Company;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompanyEditMapper {

    public Company createCompany(CompanyRequest request) {
        if (request == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(request.getCompany_name());
        company.setLocatedCountry(request.getLocated_country());
        company.setCreated(LocalDateTime.now());
        return company;
    }

    public Company updateCompany(Company company, CompanyRequest request) {
        company.setCompanyName(request.getCompany_name());
        company.setLocatedCountry(request.getLocated_country());
        return company;
    }

}
