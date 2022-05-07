package com.peaksoft.SpringSecurityMVCToken.mappers.user;

import com.peaksoft.SpringSecurityMVCToken.dto.user.UserRequest;
import com.peaksoft.SpringSecurityMVCToken.models.securityModels.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserEditMapper {

    public User createUser(UserRequest request) {
        if (request == null) {
            return null;
        }
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setCreated(LocalDateTime.now());
        return user;
    }

    public User updateUser(User user, UserRequest request) {
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setCreated(LocalDateTime.now());
        return user;
    }
}
