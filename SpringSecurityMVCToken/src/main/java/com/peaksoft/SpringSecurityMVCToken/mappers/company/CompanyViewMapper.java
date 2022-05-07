package com.peaksoft.SpringSecurityMVCToken.mappers.company;

import com.peaksoft.SpringSecurityMVCToken.dto.company.CompanyResponse;
import com.peaksoft.SpringSecurityMVCToken.models.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponse response = new CompanyResponse();
        if (company.getId() != null) {
            response.setId(company.getId());
        }
        response.setCompany_name(company.getCompanyName());
        response.setLocated_country(company.getLocatedCountry());
        response.setCreated(company.getCreated());
        return response;
    }

    public List<CompanyResponse> viewCompanies(List<Company> companies) {
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company company : companies) {
            responses.add(viewCompany(company));
        }
        return responses;
    }
}
