package com.peaksoft.SpringSecurityMVCToken.dto.student;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.peaksoft.SpringSecurityMVCToken.enam.StudyFormat;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StudentRequest {

    private String firstname;
    private String lastname;
    private String email;
    private StudyFormat study_format;
    private Long group;
}
