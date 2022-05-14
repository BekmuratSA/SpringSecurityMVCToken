package com.peaksoft.SpringSecurityMVCToken.dto.teacher;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherResponseView {

    List<TeacherResponse> teacherResponses;
}
