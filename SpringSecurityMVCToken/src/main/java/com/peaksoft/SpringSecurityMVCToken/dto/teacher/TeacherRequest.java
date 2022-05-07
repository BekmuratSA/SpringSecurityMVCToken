package com.peaksoft.SpringSecurityMVCToken.dto.teacher;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherRequest {

    private String firstname;
    private String lastname;
    private String email;
    private Long course;
}
