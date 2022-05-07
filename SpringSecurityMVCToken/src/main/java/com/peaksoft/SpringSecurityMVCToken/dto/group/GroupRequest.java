package com.peaksoft.SpringSecurityMVCToken.dto.group;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GroupRequest {

    private String group_name;
    private LocalDate date_of_start;
    private LocalDate date_of_finish;
    private Long course;
}
