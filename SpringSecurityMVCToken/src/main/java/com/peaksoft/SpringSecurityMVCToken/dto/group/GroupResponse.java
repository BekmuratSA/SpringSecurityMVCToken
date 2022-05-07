package com.peaksoft.SpringSecurityMVCToken.dto.group;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.peaksoft.SpringSecurityMVCToken.models.Course;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GroupResponse {

    private Long id;
    private String group_name;
    private LocalDate date_of_start;
    private LocalDate date_of_finish;
    private List<Course> courses;
}
