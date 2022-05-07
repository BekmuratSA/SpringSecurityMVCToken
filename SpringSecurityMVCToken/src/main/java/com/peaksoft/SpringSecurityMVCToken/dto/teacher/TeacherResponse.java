package com.peaksoft.SpringSecurityMVCToken.dto.teacher;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.peaksoft.SpringSecurityMVCToken.models.Course;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Course course;
}
