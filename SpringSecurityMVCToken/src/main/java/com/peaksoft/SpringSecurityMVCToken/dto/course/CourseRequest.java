package com.peaksoft.SpringSecurityMVCToken.dto.course;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CourseRequest {

    private String course_name;
    private int duration;
    private Long company;
}
