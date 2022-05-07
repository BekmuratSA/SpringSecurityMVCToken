package com.peaksoft.SpringSecurityMVCToken.dto.company;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CompanyResponse {

    private Long id;
    private String company_name;
    private String located_country;
    private LocalDateTime created;
}
