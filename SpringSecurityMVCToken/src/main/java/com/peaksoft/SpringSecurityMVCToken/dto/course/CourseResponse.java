package com.peaksoft.SpringSecurityMVCToken.dto.course;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.peaksoft.SpringSecurityMVCToken.models.Company;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CourseResponse {

    private Long id;
    private String course_name;
    private int duration;
    private Company company;
}
