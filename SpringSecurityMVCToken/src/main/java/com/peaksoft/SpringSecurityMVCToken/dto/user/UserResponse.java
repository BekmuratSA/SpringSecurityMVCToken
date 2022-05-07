package com.peaksoft.SpringSecurityMVCToken.dto.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDateTime created;
    private Boolean isActive;
}
